import java.util.InputMismatchException;

/**
 * Contains start point of the program.
 * Determines the type of triangle.
 */
public class TriangleMain {

  /** 
   * Start point of the program.
   * @param args comand line values
   * @see Triangle#check()
   */
  public static void main(String[] args) {
    try {
      Triangle triangle = new Triangle();
      triangle.check();
    } catch (InputMismatchException e) {
      System.out.println("It's not a number. Try again");
      return;
    }
  }
}
