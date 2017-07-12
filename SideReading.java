import java.util.Scanner;

/**
 * Gets sides from command line and writes to array.
 */
public class SideReading {

  /**
   * Gets sides from command line and writes to array.
   * @param sides is sides value array.
   */
  public void readSide(double[] sides) {
    Scanner in = new Scanner(System.in);
    System.out.println("Print 3 Triangle sides:");
    for (int i = 0; i < 3; i++) {
      System.out.print("side" + (i + 1) + ": ");
      sides[i] = in.nextDouble();
      System.out.print("\n");
    }
  }
}
