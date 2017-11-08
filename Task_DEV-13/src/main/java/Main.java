import Criteria.Cost;
import Criteria.NonJunior;
import Criteria.Productivity;
import Employees.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains start point of the program.
 * Selects a team of Developers.
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * Start point of the program.
   *
   * @param args comand line values
   */
  public static void main(String[] args) {
    try {
      ArrayList<Group> groupArrayList = new ArrayList<Group>();
      groupArrayList.add(new Group("Juniors", 500, 3));
      groupArrayList.add(new Group("Middles", 700, 5));
      groupArrayList.add(new Group("Seniors", 1000, 8));
      groupArrayList.add(new Group("Leads", 1200, 10));
      System.out.println("Choose the criterion you want to get deal (1, 2 or 3):");
      Scanner in = new Scanner(System.in);
      HashMap<String, Integer> team = new HashMap<String, Integer>();
      switch (in.nextInt()) {
        case 1:
          System.out.println("Print your budget:");
          Productivity productivity = new Productivity();
          int budget = in.nextInt();
          final int JUNIOR_SALARY = 500;
          if (budget < JUNIOR_SALARY) {
            System.out.println("You haven't got enough money!");
            return;
          }
          team = productivity.count(budget, groupArrayList);
          break;
        case 2:
          System.out.println("Print your desired productivity:");
          Cost cost = new Cost();
          team = cost.count(in.nextInt(), groupArrayList);
          break;
        case 3:
          System.out.println("Print your desired productivity:");
          NonJunior nonJunior = new NonJunior();
          team = nonJunior.count(in.nextInt(), groupArrayList);
          break;
        default:
          if (team.isEmpty()) {
            System.out.println("There is no such criterion!");
            return;
          }
      }
      for (Map.Entry<String, Integer> n : team.entrySet()) {
        System.out.println(n.getKey() + ": " + n.getValue());
      }
    } catch (IllegalArgumentException e) {
      log.log(Level.SEVERE, "IllegalArgumentException: ", e);
      System.out.println("You haven't got enough money!");
    }
  }
}