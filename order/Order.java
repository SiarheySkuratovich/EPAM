import java.util.Arrays;

public class Order {
  public static void main(String[] args) {
    String[] orderParts;
    if (args.length == 0) {
      System.out.println("Write down any order of numbers separated by a space");
      Read in = new Read();
      String order = in.readString();
      System.out.println("you have written: " + order);
      orderParts = order.split(" ");
    } else {
        orderParts = Arrays.copyOf(args, args.length);
    }
    Analysis takeTo = new Analysis();
    try { 
      takeTo.analyze(orderParts); 
    } catch (NumberFormatException ex) {
      System.out.println("It is NOT an order of numbers! Try again");
      return;
    }
    System.out.println("the order is decreasing");
  }
}
