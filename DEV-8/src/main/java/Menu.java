import java.util.ArrayList;

/**
 * The menu of commands giving info about products in the storage.
 */
public class Menu {

  /**
   * Displays available commands in the console.
   */
  public void displayTheMenu() {
    System.out.println("commands are available: ");
    System.out.println("\tcount types - get the number of product types");
    System.out.println("\tcount all - get total quantity of products;");
    System.out.println("\taverage price - get average price of all products;");
    System.out.println("\taverage price type - get average specific product type price;");
    System.out.println("\texit - Quit the program");
  }

  /**
   * Counts the number of product types.
   * @param storage The storage we want to analyze.
   * @return  The number of product types.
   */
  public int countTypes(Storage storage) {
    ArrayList<Product> tempList = (ArrayList<Product>)storage.getProductList().clone();
    for (int j = 0; j < tempList.size() - 1; j++) {
      for (int i = j; i < tempList.size() - 1; i++) {
        if (tempList.get(j).getType().equals(tempList.get(i + 1).getType())) {
          tempList.remove(i);
          i--;
        }
      }
    }
    return tempList.size();
  }

  /**
   * Counts average price of all products.
   * @param storage The storage we want to analyze.
   * @return Average price of all products.
   */
  public double countAveragePrice(Storage storage) {
    double averagePrice = 0;
    for(Product n: storage.getProductList()) {
      averagePrice += n.getCost();
    }
    averagePrice /= storage.getProductList().size();
    return averagePrice;
  }

  /**
   * Counts average specific product type price.
   * @param storage The storage we want to analyze.
   * @param productType  Specified product type.
   * @return average specific product type price.
   */
  public double countAveragePriceType(Storage storage, String productType) {
    double averagePriceType = 0;
    int typeQuantity = 0;
    for (Product n : storage.getProductList()) {
      if (n.getType().equals(productType)) {
        averagePriceType += n.getCost();
        typeQuantity++;
      }
    }
    averagePriceType /= typeQuantity;
    return averagePriceType;
  }
}
