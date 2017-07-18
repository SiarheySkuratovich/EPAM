import java.util.Scanner;

/**
 * Gets sides of geometric shapes.
 */
public class SideReading {

  /**
   * Gets triangle sides from console.
   * @return array of gotten sides.
   */
  public double[] readSides() {
    Scanner in = new Scanner(System.in);
    System.out.println("Print 3 Triangle sides:");
    double[] gottenSides = new double[3];
    for (int i = 0; i < 3; i++) {
      System.out.print("side" + (i + 1) + ": ");
      gottenSides[i] = in.nextDouble();
      System.out.print("\n");
    }
    return gottenSides;
  }
}
