import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    System.out.println("Write down any order of numbers");
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    String[] orderParts = order.split(" ");
    int Length = orderParts.length;
    int NumArr[] = new int [Length];
    int q = 0;
    for (int i = 0; i < Length; i++) {
      NumArr[i] =  Integer.parseInt(orderParts[i]);
      System.out.println(NumArr[i]);
      if (i > 0) {
       if (NumArr[i] < NumArr[i - 1]) {
         q++;
       }
      }
    }
    if (q == Length - 1) {
      System.out.println("the order is decreasing");
    }
      else {
      System.out.println("the order is NOT decreasing");
    }
  }
}
