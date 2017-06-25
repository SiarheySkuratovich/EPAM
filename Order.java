import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    System.out.println("Write down any order of numbers");
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    int Length = order.length();
    char orderArray[] = order.toCharArray();
    int q = 0;
    for (int i = 0; i < Length ; i++) {
      if (orderArray[i] == ' ') {
        q++;
      }
    }
    System.out.println(q + 1);
  }
}
