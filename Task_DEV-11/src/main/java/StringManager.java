import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siarhey on 03.10.17.
 */
public class StringManager {
  public String translate (String string) {
    Map<Character, String> map = new HashMap<Character, String>();
    map.put('А', "A");
    map.put('Б', "B");
    map.put('В', "V");
    map.put('Г', "G");
    map.put('Д', "D");
    map.put('Е', "Ye");
    map.put('Ё', "Ye");
    map.put('Ж', "Zh");
    map.put('З', "Z");
    map.put('И', "I");
    map.put('Й', "Y");
    map.put('К', "K");
    map.put('Л', "L");
    map.put('М', "M");
    map.put('Н', "N");
    map.put('О', "O");
    map.put('П', "P");
    map.put('Р', "R");
    map.put('С', "S");
    map.put('T', "T");
    map.put('У', "U");
    map.put('Ф', "F");
    map.put('Х', "Kh");
    map.put('Ц', "Ts");
    map.put('Ч', "Ch");
    map.put('Ш', "Sh");
    map.put('Щ', "Shch");
    map.put('Ъ', "'");
    map.put('Ы', "Y");
    map.put('Ь', "'");
    map.put('Э', "E");
    map.put('Ю', "Yu");
    map.put('Я', "Ya");
    ArrayList<String> arrayList = new ArrayList<>();
    for (int i = 0; i < string.length(); i++) {
      System.out.println(string.charAt(i) +  " " + map.get(string.charAt(i)));
      arrayList.add(map.get(string.charAt(i)));
    }
    String newString = String.join("", arrayList);

    return newString;
  }
}
