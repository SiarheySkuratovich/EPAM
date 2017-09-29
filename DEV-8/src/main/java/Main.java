import java.util.Scanner;

/**
 * Contains entry point of the program.
 */
public class Main {

  /**
   * Entry point of the program.
   * Organizes a dialog with user:
   * Proposes to enter some products user would like to store.
   * After that user can enter commands giving info about products in the storage.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Storage storage = new Storage();
    System.out.println("write some products you would like to be:");
    storage.store();
    System.out.println("Our storage contains:");
    for (Product product : storage.getProductList()) {
      product.getFullInformation();
    }
    Menu menu = new Menu();
    boolean mark = true;
    while (mark) {
      menu.displayTheMenu();
      String command = in.nextLine();
      switch (command) {
        case "count types":
          System.out.println("product type quantity: " + menu.countTypes(storage));
          break;
        case "count all":
          System.out.println("total quantity of products: " + storage.getProductList().size());
          break;
        case "average price":
          System.out.println("average price of all products: " + menu.countAveragePrice(storage));
          break;
        case "exit":
          mark = false;
          break;
        default:
          if(command.contains("average price ")) {
            String productType = command.substring(14);
            double averagePriceType = menu.countAveragePriceType(storage, productType);
            if(averagePriceType == 0) {
              System.out.println("There is not such product type. Try again.");
              break;
            }
            System.out.println("average specified product type price " + productType + ": " + averagePriceType);
            break;
          } else {
            System.out.println("Unknown command");
            break;
          }
      }
    }
  }
}
