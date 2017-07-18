import java.util.InputMismatchException;

/**
 * Contains start point of the program.
 * Determines the type of triangle.
 */
public class TriangleMain {

  /** 
   * Start point of the program.
   * @param args comand line values
   * @see Triangle#checkForEquilateral()
   * @see Triangle#checkForIsosceles()
   * @see SideReading#readSides();
   */
  public static void main(String[] args) {
    try {
      SideReading getting = new SideReading();
      Triangle triangle = new Triangle(getting.readSides());
      if (triangle.checkForEquilateral()) {
        System.out.println("Triangle is equilateral");
        return;
      } else if (triangle.checkForIsosceles()) {
        System.out.println("Triangle is isosceles");
        return;
      } else {
        System.out.println("Triangle is usual");
        return;
      }
    } catch (InputMismatchException e) {
      System.out.println("It's not a number. Try again");
      return;
    } catch (java.lang.NullPointerException ex) {
      System.out.println("NullPointerException was caught");
      return;
    }
  }
}
