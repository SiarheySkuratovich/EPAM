import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Transliterates Cyrillic to Latin and vice versa.
 * Contains 2 catalogs of Cyrillic-Latin alphabets.
 * The first of them is full. The second contains only pairs, which consists of complex combinations in Latin.
 * Contains different methods committing transliteration:
 */
public class Transliterator {
  private HashMap<Character, String> ruEng = new HashMap<Character, String>();
  private HashMap<Character, String> complexComb = new HashMap<Character, String>();

  /**
   * Fills the сatalogs with the Cyrillic-Latin alphabets.
   * At first puts Upper Case pairs. After that through a cycle fills lower case pairs.
   * Similarly for complexComb catalog.
   */
  Transliterator() {
    ruEng.put('А', "A");
    ruEng.put('Б', "B");
    ruEng.put('В', "V");
    ruEng.put('Г', "G");
    ruEng.put('Д', "D");
    ruEng.put('Е', "Ye");
    ruEng.put('Ё', "Yo");
    ruEng.put('Ж', "Zh");
    ruEng.put('З', "Z");
    ruEng.put('И', "I");
    ruEng.put('Й', "Y");
    ruEng.put('К', "K");
    ruEng.put('Л', "L");
    ruEng.put('М', "M");
    ruEng.put('Н', "N");
    ruEng.put('О', "O");
    ruEng.put('П', "P");
    ruEng.put('Р', "R");
    ruEng.put('С', "S");
    ruEng.put('Т', "T");
    ruEng.put('У', "U");
    ruEng.put('Ф', "F");
    ruEng.put('Х', "Kh");
    ruEng.put('Ц', "Ts");
    ruEng.put('Ч', "Ch");
    ruEng.put('Ш', "Sh");
    ruEng.put('Щ', "Shch");
    ruEng.put('ъ', "#");
    ruEng.put('Ы', "Y");
    ruEng.put('ь', "'");
    ruEng.put('Э', "E");
    ruEng.put('Ю', "Yu");
    ruEng.put('Я', "Ya");
    HashMap<Character, String> temp = new HashMap<Character, String>();
    for (Character n : ruEng.keySet()) {
      temp.put(Character.toLowerCase(n), ruEng.get(n).toLowerCase());
    }
    ruEng.putAll(temp);
    complexComb.put('Е', "Ye");
    complexComb.put('Ё', "Yo");
    complexComb.put('Ж', "Zh");
    complexComb.put('Х', "Kh");
    complexComb.put('Ц', "Ts");
    complexComb.put('Ч', "Ch");
    complexComb.put('Щ', "Shch");
    complexComb.put('Ш', "Sh");
    complexComb.put('Ю', "Yu");
    complexComb.put('Я', "Ya");
    temp.clear();
    for (Character n : complexComb.keySet()) {
      temp.put(Character.toLowerCase(n), complexComb.get(n).toLowerCase());
    }
    complexComb.putAll(temp);

  }

  /**
   * Transliterates Cyrillic words to Latin.
   * After that corrects endings according to the transliterations rules
   * by {@link Transliterator#correctLatinEndings(String)}
   * @param string we are going to transliterate.
   * @return transliterated string.
   */
  public String transliterateToLatin(String string) {
    for (int i = 0; i < string.length(); i++) {
      if (this.ruEng.containsKey(string.charAt(i))) {
        string = string.replaceAll(string.substring(i, i + 1), this.ruEng.get(string.charAt(i)));
      }
    }
    return this.correctLatinEndings(string);
  }

  /**
   * After after the character-by-character transliteration string can contains such combinations as "yy"
   * at the end of words. According to the transliteration rules, method rewrites "yy" to "y".
   * @param string
   * @return
   */
  private String correctLatinEndings(String string) {
    Pattern pattern = Pattern.compile("(yy(\\p{Punct}|\\s))|(yy$)");
    Matcher matcher = pattern.matcher(string);
    int i = 0;
    while (matcher.find()) {
      string = string.substring(0, matcher.start() - i) + string.substring(matcher.start() - i + 1);
      i++;
    }
    return string;
  }

  /**
   * Transliterates Latin-written words to Cyrillic.
   * First of all transliterates complex combinations of letters corresponding cyrillic letters.
   * After that transliterates other letters.
   * Then corrects endings according to the transliterations rules by
   * {@link Transliterator#correctCyrillicEndings(String)}
   * @param string we are going to transliterate.
   * @return transliterated string.
   */
  public String translateToCyrillic (String string) {
    Iterator it = complexComb.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Character, String> pair = (Map.Entry)it.next();
      if (string.contains(pair.getValue())) {
        string = string.replaceAll(pair.getValue(), String.valueOf(pair.getKey()));
      }
    }
    it = ruEng.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Character, String> pair = (Map.Entry)it.next();
      if (string.contains(pair.getValue())) {
        string = string.replaceAll(pair.getValue(), String.valueOf(pair.getKey()));
      }
    }
    return this.correctCyrillicEndings(string);
  }

  /**
   * After the character-by-character transliteration string can contains wrong endings of words as
   * "(some consonants character) + й"
   * According to the transliteration rules, method rewrites "й" to "ый".
   * @param string
   * @return
   */
  private String correctCyrillicEndings(String string) {
    Pattern pattern = Pattern.compile("([^и]й(\\p{Punct}|\\s))|([^и]й$)");
    Matcher matcher = pattern.matcher(string);
    int i = 0;
    while (matcher.find()) {
      string = string.substring(0, matcher.start() + i + 1) + "ы" + string.substring(matcher.start() + i + 1);
      i++;
    }
    return string;
  }
}

