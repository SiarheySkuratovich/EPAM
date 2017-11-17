import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Coordinate of ship.
 */
public class Coordinate {
  private final static HashMap<Character, Integer> CONVERTER = new HashMap<Character, Integer>();
  private int letter;
  private int number;

  /**
   * fills {@link Coordinate#CONVERTER} with character-number dictionary.
   */
  static {
    for (int i = (int)'a'; i < (int)'a' + 10; i++) {
      CONVERTER.put((char)i, i - (int)'a');
    }
  }

  /**
   * Initializes "letter" with appropriate digit of letter from gotten string and
   *           "number" with number from gotten string.
   * @param coordinate gotten string-coordinate to parse.
   */
  Coordinate(String coordinate) {
    try {
      letter = CONVERTER.get(coordinate.charAt(0));
      number = Integer.parseInt(coordinate.substring(2)) - 1;
    } catch (Exception e) {
      Scanner in = new Scanner(System.in);
      System.out.println("Illegal arguments. Try again");
      new Coordinate(in.nextLine());
    }
  }

  /**
   * Initializes "letter" and "number" with random number within field size.
   * @param fieldSize gotten field size.
   */
  Coordinate (int fieldSize) {
    Random random = new Random();
    letter = random.nextInt(fieldSize);
    number = random.nextInt(fieldSize);
  }

  public int getLetter() {
    return letter;
  }

  public int getNumber() {
    return number;
  }
}
