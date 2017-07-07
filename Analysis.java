/**
 * Makes string-analyzing objects
 */
public class Analysis {
  /**
   * Determines whether the order is increasing.
   * @param orderParts a string we get to analyze.
   * @return true is NOT decreasing.
   * @return false is decreasing.
   */
  public boolean analyze (String[] arrayOfnumbers) {
    for (int i = 0; i < arrayOfnumbers.length - 1; i++) {
      if (Integer.parseInt(arrayOfnumbers[i + 1]) >= Integer.parseInt(arrayOfnumbers[i])) {
        return true;
      }
    }
    return false;
  }
  public boolean check(String[] arrayOfsymbols) {
    if (arrayOfsymbols.length == 1) {
      System.out.println("There is only one member. Try again");
      return true;
    }
    return false;
  }
}

