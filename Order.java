import java.util.Scanner;

public class Order {
  public static void main(String[] args) {
    System.out.println("Write down any order of numbers");
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    System.out.println("you have written: " + order);
    int Length = order.length();
    char strArray[] = order.toCharArray();
    int q = 0;
    for (int i = 0; i < Length ; i++) {
      if (strArray[i] == ' ') {
        q++;
      }
    }
    System.out.println("there are " + (q + 1) + " numbers");
    int numberArray[] = new int[q];
    String temp;
    for (int i = 0; i < Length ; i++) {
      if (strArray[i] == ' ') {
        temp = 
        numberArray[i] = Integer.parseInt(strArray[i - 1]);
        System.out.println(numberArray[i] + "!!!!!!!");
      }
    }
  }
} 
