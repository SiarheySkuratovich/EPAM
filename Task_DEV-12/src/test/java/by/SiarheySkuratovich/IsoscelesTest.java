package by.SiarheySkuratovich;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsoscelesTest extends OutputTest{
  @Test
  public void checkForIsosceles() throws Exception {
    Isosceles isosceles = new Isosceles();
    double[] sides = {0.1, 0.1, 0.19};
    boolean actual = isosceles.checkForIsosceles(sides);
    boolean expected = true;
    assertEquals(expected, actual);
  }
  @Test
  public void checkIfPrintsMessageAfterArrayIndexOutOfBoundsException() {
    try {
      Isosceles isosceles = new Isosceles();
      double[] sides = {2, 3};
      isosceles.checkForIsosceles(sides);
    } catch (ArrayIndexOutOfBoundsException ex) {
      assertEquals("It's not triangle!\n", output.toString());
    }
  }
  @Test
  public void checkIfPrintsMessageAfterNullPointerException() {
    try {
      Isosceles isosceles = new Isosceles();
      double[] sides = null;
      isosceles.checkForIsosceles(sides);
    } catch (NullPointerException ex) {
      assertEquals("No one side has been gotten\n", output.toString());
    }
  }
}