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
  public void readTriangleSides(double[] sides) throws IllegalArgumentException {
    Scanner in = new Scanner(System.in);
    String[] strings = in.nextLine().split("\\s");
    for (int i = 0; i < 3; i++) {
     sides[i] = Double.parseDouble(strings[i]);
   }
   if (!(sides[0] + sides[1] > sides[2] && sides[1] + sides[2] > sides[0] && sides[2] + sides[0] > sides[1])) {
     System.out.println("The sum of  two of them should be more than the third number");
      throw new IllegalArgumentException("The sum of  two of them should be more than the third number");
   }
  }
}
