package by.SiarheySkuratovich;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains start point of the program.
 * Determines the type of triangle.
 */
public class TriangleMain {
  private static Logger log = Logger.getLogger(TriangleMain.class.getName());

  /** 
   * Start point of the program.
   * @param args comand line values
   */
  public static void main(String[] args) {
    try {
      SideReading getting = new SideReading();
      Equilateral equilateralTriangle = new Equilateral();
      Isosceles isoscelesTriangle = new Isosceles();
      double[] sides = new double[3];
      getting.readTriangleSides(sides);
      if (equilateralTriangle.checkForEquilateral(sides)) {
        System.out.println("Triangle is equilateral");
        return;
      } else if (isoscelesTriangle.checkForIsosceles(sides)) {
        System.out.println("Triangle is isosceles");
        return;
      } else {
        System.out.println("Triangle is usual");
        return;
      }
    } catch (InputMismatchException e) {
      log.log(Level.SEVERE, "InputMismatchException: ", e);
      System.out.println("It's not a number. Try again");
      return;
    } catch (Exception ex) {
      log.log(Level.SEVERE,"Caught exception: ", ex);
      return;
    }
  }
}
