import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Counts quantity of repetitions in collections.
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * Entry-point of the program.
   * @param args args of command line.
   */
  public static void main(String[] args) {
    try {
      ArrayList arrayList = new ArrayList();
      arrayList.add(1);
      arrayList.add(2);
      arrayList.add(1);
      arrayList.add(2);
      arrayList.add(1);
      arrayList.add(3);
      CountedCollection countedCollection = new CountedCollection(arrayList);
      countedCollection.removeNonRepeatable();
      System.out.println("Quantity of repeatable objects is: " + countedCollection.getSize());
    } catch (Exception e) {
      log.log(Level.SEVERE, "Exception: ", e);
    }
  }
}
