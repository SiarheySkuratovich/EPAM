import java.util.InputMismatchException;

/**
 * Contains start point of the program.
 * Determines the type of triangle.
 */
public class TriangleMain {

  /** 
   * Start point of the program.
   * @param args comand line values
   * @see Equilateral#checkForEquilateral()
   * @see Isosceles#checkForIsosceles()
   * @see SideReading#readSides();
   */
  public static void main(String[] args) {
    try {
      SideReading getting = new SideReading();
      Equilateral equilateralTriangle = new Equilateral();
      Isosceles isoscelesTriangle = new Isosceles();
      double[] sides = new double[3];
      getting.readSides(sides);
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
      System.out.println("It's not a number. Try again");
      return;
    }
  }
}
