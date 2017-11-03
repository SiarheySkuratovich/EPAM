package Criteria;

import Employees.*;

import java.util.ArrayList;

/**
 * Created by siarhey on 03.11.17.
 */
public class Productivity implements Criteria {

  int productivity;

  public int count(int cost, int productivity) {
    Junior junior = new Junior();
    Middle middle = new Middle();
    Senior senior = new Senior();
    Lead lead = new Lead();
    ArrayList<Employee> team = new ArrayList<Employee>();

      ArrayList<Double> versions = new ArrayList<Double>();
      versions.add((double)cost / junior.getSalary());
      versions.add((double)cost / middle.getSalary());
      versions.add((double)cost / senior.getSalary());
      versions.add((double)cost / lead.getSalary());

      double prod1 = versions.get(0) * junior.getProductivity();
      double prod2 = versions.get(1) * middle.getProductivity();
      double prod3 = versions.get(2) * senior.getProductivity();
      double prod4 = versions.get(3) * lead.getProductivity();

      System.out.println(prod1);
      System.out.println(prod2);
      System.out.println(prod3);
      System.out.println(prod4);


    return 0;
  }

}
