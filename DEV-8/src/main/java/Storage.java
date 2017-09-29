import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents storage containing any products.
 */
public class Storage {

  /**
   * Is array-storage for containing products.
   */
  private ArrayList<Product> productList = new ArrayList<Product>();

  /**
   * Is used for adding new products with properties selected by the user to the storage.
   * It is presented as a dialogue with the user.
   * Products are being added until the user has entered 0;
   * Else the user continues adding by pressing 1.
   */
  public void store() {
    Scanner in = new Scanner(System.in);
    byte mark = 1;
    while (mark == 1) {
      System.out.println("type:");
      String type = in.nextLine();
      System.out.println("name:");
      String name = in.nextLine();
      System.out.println("quantity:");
      int quantity = in.nextInt();
      System.out.println("cost:");
      double cost = in.nextDouble();
      productList.add(new Product(type, name, quantity, cost));
      System.out.println("enter 1 if you want to add another one product or 0 to finish");
      mark = in.nextByte();
      in.nextLine();
    }
  }

  public ArrayList<Product> getProductList() {
   return productList;
  }

  /**
   * Adds one product to the storage.
   * Method was created for tests for visualization of the test process.
   * @param product is object that the user wants to add.
   */
  public void addProduct(Product product) {
    productList.add(product);
  }
}
