import java.util.Scanner;

/**
 * This class makes string-reading objects
 */
public class Reading {
  /**
   * The method gets a string from command line
   * @return order A string from comand line
   */
  public String readString() {
    Scanner in = new Scanner(System.in);
    String order = in.nextLine();
    return order;
  }
}
