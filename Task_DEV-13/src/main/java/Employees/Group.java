package Employees;

import java.util.Comparator;

/**
 * Created by siarhey on 02.11.17.
 */
public class Group {
  private final String name;
  private final int salary;
  private final int productivity;
  private int commonProductivity;
  private int commonCost;
  private int quantity;
  private final double coefficient;

  public Group(String name, int salary, int productivity) {
    this.name = name;
    this.salary = salary;
    this.productivity = productivity;
    quantity = 0;
    coefficient = productivity / salary;
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

  public double getProductivity() {
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

  public double getCoefficient() {
    return coefficient;
  }

  public int getCommonCost() {
    return commonCost;
  }
}
