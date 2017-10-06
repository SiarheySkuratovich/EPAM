/**
 * Aanalyzes sequences.
 */
public class Analysis {
  /**
   * Determines whether the order is increasing.
   * @param orderParts a string we get to analyze.
   * @return false if the order is decreasing and true if it is not.
   */
  public boolean analyze (String[] arrayOfnumbers) {
    for (int i = 0; i < arrayOfnumbers.length - 1; i++) {
      if (Integer.parseInt(arrayOfnumbers[i + 1]) >= Integer.parseInt(arrayOfnumbers[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks whether the order contains less than 2 symbol.
   * @param arrayOfsymbols a string we get to check.
   * @return true if the order consists of 1 symbol and false if it doesn't.
   */
  public boolean check(String[] arrayOfsymbols) {
    if (arrayOfsymbols.length == 1) {
      System.out.println("There is only one member. Try again");
      return true;
    }
    return false;
  }
}

