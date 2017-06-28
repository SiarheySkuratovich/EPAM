import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    if (args.length == 0) {
    System.out.println("Write down any order of numbers separated by a space");
    Scanner in = new Scanner(System.in);    
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    String[] orderParts = order.split(" ");
    } else {
      String[] orderParts = new String[args.length];
      for(int i = 0; i < args.length; i++) {
        orderParts[i] = args[i];
      }
    }
    try { 
      for (int i = 0; i < orderParts.length - 1; i++) {
        if (Integer.parseInt(orderParts[i + 1]) > Integer.parseInt(orderParts[i])) {
          System.out.println("the order is NOT decreasing");
          return;
        }
      }  
    } catch (NumberFormatException ex) {
      System.out.println("It is NOT an order of numbers! Try again");
      return;
    }
    System.out.println("the order is decreasing");
  }
}
