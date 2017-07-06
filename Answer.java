/**
 * This class makes answering objects
 */
public class Answer {
  /**
   * The method gives answer dependent on parameter value.
   * @param analyzed is flag to give one of three answer.
   */
  public void giveAnswer(byte analyzed) {
    switch (analyzed) {
      case 1 :
        System.out.println("the order is NOT decreasing");
        break;
      case 2 :
        System.out.println("the order is decreasing");
        break;
      case 3 :
        System.out.println("It is NOT an order of numbers! Try again");
        break;
    }
  }
}
