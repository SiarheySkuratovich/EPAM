/**
 * Makes objects used for giving answer
 */
public class Answer {
  /**
   * Gives answer.
   * @param analyzed is flag to give one of two answer.
   */
  public void giveAnswer(boolean analyzed) {
    if (analyzed) {
      System.out.println("the order is NOT decreasing");
    } else {
      System.out.println("the order is decreasing");
    }
  }
}
