package Employees;

/**
 * Group of equal devs with te following properties.
 */
public class Group {
  private final String name;
  private final int salary;
  private int commonCost;
  private final int productivity;
  private int commonProductivity;
  private int quantity;

  public Group(String name, int salary, int productivity) {
    this.name = name;
    this.salary = salary;
    this.productivity = productivity;
    quantity = 0;
  }

  public void setCommonProductivity(int commonProductivity) {
    this.commonProductivity = commonProductivity;
  }

  public void setCommonCost(int commonCost) {
    this.commonCost = commonCost;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return salary;
  }

  public int getProductivity() {
    return productivity;
  }

  public double getCommonProductivity() {
    return commonProductivity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getCommonCost() {
    return commonCost;
  }
}
