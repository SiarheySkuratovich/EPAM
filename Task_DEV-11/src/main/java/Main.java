import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Asks for string and transliterates it according to the chosen alphabet.
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * Entry-point of the program.
   * @param args args of command line.
   */
  public static void main(String[] args) throws IllegalArgumentException {
    try {
      Transliterator transliterator = new Transliterator();
      Scanner in = new Scanner(System.in);
      System.out.println("enter a sentence:");
      String string = in.nextLine();
      System.out.println("enter 1 for Cyrillic-Latin or 2 for Latin-Cyrillic transliteration");
      int language = in.nextInt();
      if (language == 1) {
        System.out.println(transliterator.transliterateToLatin(string));
      } else if (language == 2) {
        System.out.println(transliterator.translateToCyrillic(string));
      } else throw new IllegalArgumentException("There is not such alphabet");
    } catch (IllegalArgumentException e) {
      log.log(Level.SEVERE, "IllegalArgumentException: ", e);
    } catch (NullPointerException ex) {
      log.log(Level.SEVERE, "NullPointerException: ", ex);
    }
  }
}