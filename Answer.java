/**
 * Gives answers.
 */
public class Answer {
  /**
   * Prints an answer to the console to the task of the program (@link Order).
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
