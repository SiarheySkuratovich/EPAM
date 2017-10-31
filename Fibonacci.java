import java.util.Scanner;
import java.util.InputMismatchException;

public class Fibonacci {
  public static void main(String[] args) {
    long number = 0;
    long first = 0;
    long second = 0;
    long sum = 1;
    System.out.println("write down any non-negative number:");
    Scanner in = new Scanner(System.in);
    try {
      number = in.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("the number you have entered is too big");
      return;
    }
    if (number < 0) {
      System.out.println("the number you have entered is negative");
      return;
    }
    if (number == 1 || number == 0) {
      System.out.println("This is one out of two numbers, which starts the Fibinacci order");
      return;
    }
    while (sum < number) {
     first = second;
     second = sum;
     sum = first + second;
     if (sum == number) {
       System.out.println(number + " is Fibonacci number");
       return;
     }
    }
    System.out.println(number + " is NOT Fibonacci number");
  }
}
    
