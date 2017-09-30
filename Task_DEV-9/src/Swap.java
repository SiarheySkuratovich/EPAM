import java.util.Scanner;

/**
 * Contains entry point of whe program.
 */
public class Swap {

  /**
   * Start point of the program
   * @param args comand line values
   */
  public static void main(String[] args) {
    SymbolsSwap symbolsSwap = new SymbolsSwap();
    Scanner in = new Scanner(System.in);
    System.out.println("Enter any string, please");
    String firstString = in.nextLine();
    System.out.println("Enter another one, please");
    String secondString = in.nextLine();
    System.out.println("First String you have written: " + firstString);
    System.out.println("Second String you have written: " + secondString);
    System.out.println("Swapped string is following: " + symbolsSwap.swapPiecesRandomly(firstString, secondString));
  }
}