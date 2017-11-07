package Criteria;

import Employees.Group;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by siarhey on 03.11.17.
 */
public class Cost {

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  public HashMap<String, Integer> count(int money, int expectedProductivity, Group[] groups) {
    int[] commonCost = new int[4];
    final int JUNIOR_SALARY = 500;
    while (money >= JUNIOR_SALARY) {
      for (int i = 0; i < groups.length; i++) {
        commonCost[i] = (int) (expectedProductivity / groups[i].getProductivity());
        commonCost[i] *= groups[i].getSalary();
        groups[i].setCommonProductivity(commonCost[i]);
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
    return new HashMap<String, Integer>();
  }
}
