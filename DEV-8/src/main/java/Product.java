
/**
 * Represents any storage product.
 */
public class Product {

  /**
   * Product properties.
   */
  private String type;
  private String name;
  private int quantity;
  private double cost;

  /**
   * Assigns the values selected by the user to the object fields.
   */
  public Product(String gottenType, String gottenName, int gottenQuantity, double gottenCost) {
    type = gottenType;
    name = gottenName;
    quantity = gottenQuantity;
    cost = gottenCost;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getCost() {
    return cost;
  }

  /**
   * Displays on the console full information about a product.
   */
  public void getFullInformation() {
    System.out.print("Type: " + type);
    System.out.print("; Name: " + name);
    System.out.print("; Quantity: " + quantity);
    System.out.println("; Cost: " + cost);
  }
}
