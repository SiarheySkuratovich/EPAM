import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Translator {
  private HashMap<Character, String> ruEng = new HashMap<Character, String>();
  Translator() {
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
    ruEng.put('Ъ', "'");
    ruEng.put('Ы', "Y");
    ruEng.put('Ь', "'");
    ruEng.put('Э', "E");
    ruEng.put('Ю', "Yu");
    ruEng.put('Я', "Ya");
    HashMap<Character, String> temp = new HashMap<Character, String>();
    for (Character n : ruEng.keySet()) {
      temp.put(Character.toLowerCase(n), ruEng.get(n).toLowerCase());
    }
    ruEng.putAll(temp);
  }
  public String translateToLatin (String string) {
    ArrayList<String> arrayList = new ArrayList<>();
    for (int i = 0; i < string.length(); i++) {
      if (this.ruEng.containsKey(string.charAt(i))) {
        arrayList.add(this.ruEng.get(string.charAt(i)));
      } else {
        arrayList.add(String.valueOf((string.charAt(i))));
      }
    }
    return String.join("", arrayList);
  }
  public String translateToCyrillic (String string) {
    Iterator it = ruEng.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Character, String> pair = (Map.Entry)it.next();
      String str = pair.getValue();
      if (string.contains(pair.getValue())) {
        string = string.replaceAll(pair.getValue(), String.valueOf(pair.getKey()));
      }
    }
    return string;
  }
}

