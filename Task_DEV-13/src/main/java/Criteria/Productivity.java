package Criteria;

import Employees.Group;

import java.util.*;

public class Productivity implements Criteria{

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  public HashMap<String, Integer> count(int money, int ExpectedProductivity, Group[] groups) {
    int[] productivity = new int[4];
    final int JUNIOR_SALARY = 500;
    while (money >= JUNIOR_SALARY) {
      for (int i = 0; i < groups.length; i++) {
        productivity[i] = money / groups[i].getSalary();
        productivity[i] *= groups[i].getProductivity();
        groups[i].setCommonProductivity(productivity[i]);
      }
      Arrays.sort(groups, new Comparator<Group>() {
        public int compare(Group o1, Group o2) {
          return Double.compare(o1.getCommonProductivity(), o2.getCommonProductivity());
        }
      });
      int maxIndex = groups.length - 1;
      String nameOfMax = groups[maxIndex].getName();
      if (!team.containsKey(nameOfMax)) {
        groups[maxIndex].setQuantity(1);

      } else {
        int quantity = team.get(nameOfMax);
        groups[maxIndex].setQuantity(quantity + 1);

      }
      team.put(nameOfMax, groups[maxIndex].getQuantity());
      money -= groups[maxIndex].getSalary();
    }
    return team;
  }
}
