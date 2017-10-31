package by.SiarheySkuratovich;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComparatorTest {
  @org.junit.Test
  public void compareDouble() throws Exception {
    Comparator comparator = new Comparator();
    boolean actual = comparator.compareDouble(5.7652, 3.56789);
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void CheckIFComparesWithEpsilonPrecision() {
    Comparator comparator = new Comparator();
    boolean actual = comparator.compareDouble(0.00001, 0.000019);
    boolean expected = true;
    assertEquals(expected, actual);
  }
}