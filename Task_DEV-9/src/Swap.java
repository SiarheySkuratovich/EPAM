import java.util.Scanner;

public class Swap {
  public static void main(String[] args) {
    RandomSymbolsSwap randomSymbolsSwap = new RandomSymbolsSwap();
    Scanner in = new Scanner(System.in);
    System.out.println("Enter any string, please");
    String firstString = in.nextLine();
    System.out.println("Enter another one, please");
    String secondString = in.nextLine();
    System.out.println("First String you have written: " + firstString);
    System.out.println("Second String you have written: " + secondString);
    System.out.println("Swapped string is following: " + randomSymbolsSwap.swap(firstString, secondString));
  }
}