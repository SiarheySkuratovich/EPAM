package by.SiarheySkuratovich;
import java.util.Scanner;

/**
 * Gets sides of geometric shapes.
 */
public class SideReading {

  /**
   * Sets triangle sides from console to empty gotten array.
   * @param sides empty array prepared for triangle sides.
   */
  public void readTriangleSides(double[] sides) {
    Scanner in = new Scanner(System.in);
    System.out.println("Print 3 Triangle sides through a space :");
    String[] strings = in.nextLine().split("\\s");
   for (int i = 0; i < 3; i++) {
     sides[i] = Double.parseDouble(strings[i]);
   }
  }
}
