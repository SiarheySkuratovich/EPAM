package by.SiarheySkuratovich;
import static java.lang.Math.abs;

/**
 * Compares different values.
 */
public class Comparator {
  private final double EPSILON = 0.00001;

  /**
   * Compares two double-type values with 0.00001 precision.
   * Returns true if values are equal with 0.00001 precision and false if not.
   * @param a First value to compare.
   * @param b Second value to compare.
   */
  public boolean compareDouble(double a, double b) {
    return abs(a - b) < EPSILON;
  }
}