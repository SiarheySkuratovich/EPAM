package Criteria;

import Employees.Group;

import java.util.*;

/**
 * Criterion1: Maximum productivity within the budget
 */
public class Productivity {

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  /**
   * Selects team in the following way:
   * Each iteration selects the most profitable group of equal Devs and adds one of this group into team.
   * After that the salary of this dev is taken away from the budget.
   * After each iteration such group may change.
   * So this method lets to choose the most profitable way to go after each iteration.
   * @param money the budget of customer.
   * @param groupArrayList available developers.
   * @return selected team of Devs.
   */
  public HashMap<String, Integer> count(int money, ArrayList<Group> groupArrayList) {
    int[] productivity = new int[4];
    final int JUNIOR_SALARY = 500;
    while (money >= JUNIOR_SALARY) {
      for (int i = 0; i < groupArrayList.size(); i++) {
        productivity[i] = money / groupArrayList.get(i).getSalary();
        productivity[i] *= groupArrayList.get(i).getProductivity();
        groupArrayList.get(i).setCommonProductivity(productivity[i]);
      }
      Collections.sort(groupArrayList, new Comparator<Group>() {
        public int compare(Group o1, Group o2) {
          return Double.compare(o1.getCommonProductivity(), o2.getCommonProductivity());
        }
      });
      int maxIndex = groupArrayList.size() - 1;
      String nameOfMax = groupArrayList.get(maxIndex).getName();
      if (!team.containsKey(nameOfMax)) {
        groupArrayList.get(maxIndex).setQuantity(1);
      } else {
        int quantity = team.get(nameOfMax);
        groupArrayList.get(maxIndex).setQuantity(quantity + 1);
      }
      team.put(nameOfMax, groupArrayList.get(maxIndex).getQuantity());
      money -= groupArrayList.get(maxIndex).getSalary();
    }
    return team;
  }
}
