package by.SiarheySkuratovich;

import org.junit.Test;

import static org.junit.Assert.*;

public class EquilateralTest extends OutputTest{
  @Test
  public void checkForEquilateral() throws Exception {
    Equilateral equilateral = new Equilateral();
    double[] sides = {0.1, 0.1, 0.1};
    boolean actual = equilateral.checkForEquilateral(sides);
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void checkIfPrintsMessageAfterArrayIndexOutOfBoundsException() {
    try {
      Equilateral equilateral = new Equilateral();
      double[] sides = {2, 3};
      equilateral.checkForEquilateral(sides);
    } catch (ArrayIndexOutOfBoundsException ex) {
      assertEquals("It's not triangle!\n", output.toString());
    }
  }
  @Test
  public void checkIfPrintsMessageAfterNullPointerException() {
    try {
      Equilateral equilateral = new Equilateral();
      double[] sides = null;
      equilateral.checkForEquilateral(sides);
    } catch (NullPointerException ex) {
      assertEquals("No one side has been gotten\n", output.toString());
    }
  }
}
