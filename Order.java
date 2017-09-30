import java.util.Scanner;

/**
 * Contains start point of the program
 * Determines whether the order is decreasing
 */
public class Order {

  /**
   * Start point of the program
   * @param args comand line values
   * @see Analysis#analyze(String[])
   * @see Answer#giveAnswer(boolean)
   * @see Analysis#check(String[])
   */
  public static void main(String[] args) {
    String[] orderParts;
    Analysis takeTo = new Analysis();
    Answer please = new Answer();
    try {
      if (args.length == 0) {
        System.out.println("Write down any order of numbers separated by a space");	
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        System.out.println("you have written: " + order);
        orderParts = order.split(" ");
        if (takeTo.check(orderParts)) {
          return;
        }
        please.giveAnswer(takeTo.analyze(orderParts));
      } else {
        if (takeTo.check(args)) {
          return;
        }
        please.giveAnswer(takeTo.analyze(args));
      }
    } catch (NumberFormatException ex) {
      System.out.println("It is NOT an order of numbers! Try again");
    }
    return;
  }
}
