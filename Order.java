import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    System.out.println("Write down any order of numbers separated by a space");
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    String[] orderParts = order.split(" ");
    int Length = orderParts.length;
    boolean identifier = true;
    try { 
      for (int i = 0; i < Length - 1; i++) {
        if (Integer.parseInt(orderParts[i + 1]) > Integer.parseInt(orderParts[i])) {
          identifier = false;
          break;
        }
      }
    } catch (NumberFormatException ex) {
      System.out.println("It is NOT an order of numbers! Try again");
      return;
    }
    if (identifier) {
      System.out.println("the order is decreasing");
    } else {
      System.out.println("the order is NOT decreasing");
    }
  }
}
