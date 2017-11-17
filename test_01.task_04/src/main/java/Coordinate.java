import java.util.HashMap;

/**
 * Created by siarhey on 17.11.17.
 */
public class Coordinate {
  private final static HashMap<Character, Integer> CONVERTER = new HashMap<Character, Integer>();
  private int letter;
  private int number;

  static {
    for (int i = (int)'a'; i < (int)'a' + 10; i++) {
      CONVERTER.put((char)i, i - (int)'a');
    }
  }

  Coordinate(String coordinate) {
    letter = CONVERTER.get(coordinate.charAt(0));
    number = Integer.parseInt(coordinate.substring(2)) - 1;
  }

  public int getLetter() {
    return letter;
  }

  public int getNumber() {
    return number;
  }
}
