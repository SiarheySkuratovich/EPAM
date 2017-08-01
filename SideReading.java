import java.util.Scanner;

/**
 * Gets sides of geometric shapes.
 */
public class SideReading {

  /**
   * Sets triangle sides from console to empty gotten array.
   * @param sides empty array prepared for triangle sides.
   */
  public void readSides(double[] sides) {
    Scanner in = new Scanner(System.in);
    System.out.println("Print 3 Triangle sides:");
    for (int i = 0; i < 3; i++) {
      System.out.print("side" + (i + 1) + ": ");
      sides[i] = in.nextDouble();
      System.out.print("\n");
    }
  }
}
