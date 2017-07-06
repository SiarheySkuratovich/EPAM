import java.util.Arrays;

/**
 * This class contains start point of the program
 * The program determines whether the order is decreasing
 */
public class Order {

  /**
   * Start point of the program
   * @param args comand line values
   * @see Analysis#analyze(String[])
   * @see Read#readString()
   * @see Answer#giveAnswer(byte)
   */
  public static void main(String[] args) {
    String[] orderParts;
    Analysis takeTo = new Analysis();
    Answer please = new Answer();
    if (args.length == 0) {
      System.out.println("Write down any order of numbers separated by a space");
      Reading in = new Reading();
      String order = in.readString();
      System.out.println("you have written: " + order);
      orderParts = order.split(" ");
      please.giveAnswer(takeTo.analyze(orderParts));
    } else {
      please.giveAnswer(takeTo.analyze(args));
    }
  }
}
