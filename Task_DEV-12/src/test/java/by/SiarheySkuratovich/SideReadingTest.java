package by.SiarheySkuratovich;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class SideReadingTest extends OutputTest {
  @Test
  public void readTriangleSides() throws Exception {
    double[] sides = new double[3];
    ByteArrayInputStream input = new ByteArrayInputStream("1.2 2.01 3".getBytes());
    System.setIn(input);
    SideReading sideReading = new SideReading();
    sideReading.readTriangleSides(sides);
    double[] expected = {1.2, 2.01, 3};
    final double EPSILON = 0.00001;
    assertArrayEquals(expected, sides, EPSILON);
  }
  @Test
  public void checkForIllegalArgumentExceptionMessage() {
    try {
      double[] sides = new double[3];
      ByteArrayInputStream input = new ByteArrayInputStream("2 3 6".getBytes());
      System.setIn(input);
      SideReading sideReading = new SideReading();
      sideReading.readTriangleSides(sides);
    } catch (IllegalArgumentException ex) {
      assertEquals("The sum of  two of them should be more than the third number\n", output.toString());
    }
  }
}