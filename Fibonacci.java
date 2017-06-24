import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    long number, first, second = 0, sum = 1;
    System.out.println("write down any non-negative number:");
    Scanner in = new Scanner(System.in);
    try {
      number = in.nextInt();
      if (number < 0) {
        System.out.println("the number you have entered is negative");
        return;
      }
    } catch (Exception e) {
      System.out.println("the number you have entered is too big");
      return;
    }
    while (sum < number) {
     first = second;
     second = sum;
     sum = first + second;
     if (sum == number) {
       System.out.println(number + " is Fibonacci number");
       System.exit(0);    
     }
     System.out.println(number + " is NOT Fibonacci number");
    }
  }
}
    
