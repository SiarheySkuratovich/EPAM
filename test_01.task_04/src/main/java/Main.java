import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sea battle game
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * Start point of the program.
   * @param args comand line values
   */
  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(System.in);
      EnemyField enemyField = new EnemyField();
      int quantityOfShoots = 0;
      while (enemyField.getShipQuantity() != 0) {
        System.out.println("Print through a space assumed ship coordinates(letter and number) or print \"exit\" to exit:");
        String string = in.nextLine();
        if (string.equals("exit")) {
          break;
        }
        Coordinate coordinate = new Coordinate(string);
        if (enemyField.contains(coordinate)) {
          System.out.println("you hit the target!");
          enemyField.kill(coordinate);
        } else {
          System.out.println("miss:(");
        }
        quantityOfShoots++;
      }
      System.out.println("quantity of shoots:" + quantityOfShoots);
      System.out.println("quantity of sunken ships:" + enemyField.getShipQuantity());
    } catch (Exception e) {
      log.log(Level.SEVERE, "Exception: ", e);
    }
  }
}
