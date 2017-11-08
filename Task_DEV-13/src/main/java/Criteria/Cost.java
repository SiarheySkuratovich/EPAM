package Criteria;

import Employees.Group;

import java.util.*;

/**
 * Criterion2: The minimum cost for a fixed productivity.
 */
public class Cost {

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  /**
   * Selects team in the following way:
   * Each iteration selects the most profitable group of equal Devs and adds one of this group into team.
   * After that the productivity of this dev is taken away from the expected productivity.
   * After each iteration such group may change.
   * So this method lets to choose the most profitable way to go after each iteration.
   * @param expectedProductivity expectedProductivity of customer.
   * @param groupArrayList available developers.
   * @return selected team of Devs.
   */
  public HashMap<String, Integer> count(int expectedProductivity, ArrayList<Group> groupArrayList) {
    int[] commonCost = new int[groupArrayList.size()];
    final int MIN_PRODUCTIVITY = groupArrayList.get(0).getProductivity();
    while (expectedProductivity >= MIN_PRODUCTIVITY) {
      for (int i = 0; i < groupArrayList.size(); i++) {
        commonCost[i] = (expectedProductivity / groupArrayList.get(i).getProductivity());
        commonCost[i] *= groupArrayList.get(i).getSalary();
        groupArrayList.get(i).setCommonCost(commonCost[i]);
      }
      deleteAllZeros(groupArrayList);
      Collections.sort(groupArrayList, new Comparator<Group>() {
        public int compare(Group o1, Group o2) {
          return Double.compare(o1.getCommonCost(), o2.getCommonCost());
        }
      });
      final int INDEX_OF_MIN = 0;
      String nameOfMin = groupArrayList.get(INDEX_OF_MIN).getName();
      if (!team.containsKey(nameOfMin)) {
        groupArrayList.get(INDEX_OF_MIN).setQuantity(1);

      } else {
        int quantity = team.get(nameOfMin);
        groupArrayList.get(INDEX_OF_MIN).setQuantity(quantity + 1);

      }
      team.put(nameOfMin, groupArrayList.get(INDEX_OF_MIN).getQuantity());
      expectedProductivity -= groupArrayList.get(INDEX_OF_MIN).getProductivity();
    }
    return team;
  }

  private void deleteAllZeros(ArrayList<Group> groupArrayList) {
    int size = groupArrayList.size();
    for (int i = 0; i < size; i++) {
      if (groupArrayList.get(i).getCommonCost() == 0) {
        groupArrayList.remove(i);
        i--;
        size--;
      }
    }
  }
}
