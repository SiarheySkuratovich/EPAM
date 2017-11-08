package Criteria;

import Employees.Group;

import java.util.*;

/**
 * Created by siarhey on 03.11.17.
 */
public class Cost {

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  public HashMap<String, Integer> count(int money, int expectedProductivity, ArrayList<Group> groupArrayList) {
    int[] commonCost = new int[4];
    final int JUNIOR_PRODUCTIVITY = 3;
    while (expectedProductivity >= JUNIOR_PRODUCTIVITY) {
      for (int i = 0; i < groupArrayList.size(); i++) {
        commonCost[i] = (int) (expectedProductivity / groupArrayList.get(i).getProductivity());
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
