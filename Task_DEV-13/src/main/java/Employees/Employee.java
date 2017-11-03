package Employees;

/**
 * Created by siarhey on 02.11.17.
 */
public abstract class Employee {
  private int salary;
  private int productivity;

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public void setProductivity(int productivity) {
    this.productivity = productivity;
  }

  public int getSalary() {
    return salary;
  }

  public int getProductivity() {
    return productivity;
  }
}
