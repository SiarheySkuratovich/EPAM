import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    System.out.println("Write down any order of numbers separated by a space");
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    String[] orderParts = order.split(" ");
    int Length = orderParts.length;
    int numArr[] = new int [Length];
    int q = 0;
    for (int i = 0; i < Length; i++) {
      numArr[i] =  Integer.parseInt(orderParts[i]);
      if (i > 0) {
       if (numArr[i] < numArr[i - 1]) {
         q++;
       }
      }
    }
    if (q == Length - 1) {
      System.out.println("the order is decreasing");
    } else {
      System.out.println("the order is NOT decreasing");
    }
  }
}
