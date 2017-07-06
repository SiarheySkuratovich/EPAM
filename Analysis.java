/**
 * This class makes string-analyzing objects
 */
public class Analysis {
  /**
   * The method determines whether the order is increasing.
   * @param orderParts a string we get to analyze.
   * @return 1 means that order is NOT decreasing.
   * @return 2 means that order is decreasing.
   * @return 3 means that some wrong values was entered.
   */
  public byte analyze (String[] orderParts) {
    try {
      if (orderParts.length == 1) {
        return 3;
      }
      for (int i = 0; i < orderParts.length - 1; i++) {
        if (Integer.parseInt(orderParts[i + 1]) > Integer.parseInt(orderParts[i])) {
          return 1;
        }
      }
      return 2;
    } catch (NumberFormatException ex) {
      return 3;
    }
  }
}
