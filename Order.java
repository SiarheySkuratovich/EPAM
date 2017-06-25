import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
  System.out.println("Write down any order of numbers");
  Scanner in = new Scanner(System.in);
  String order = in.nextLine();
  System.out.println("you have written: " + order);
  }
}
