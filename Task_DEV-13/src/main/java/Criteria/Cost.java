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
      for (Group n : groupArrayList) {
        System.out.println(n.getName());
        System.out.println(n.getCommonCost());
      }
      System.out.println("____________");
      Collections.sort(groupArrayList, new Comparator<Group>() {
        public int compare(Group o1, Group o2) {
          return Double.compare(o1.getCommonCost(), o2.getCommonCost());
        }
      });

      int size = groupArrayList.size();
      for (int i = 0; i < size; i++) {
        if (groupArrayList.get(i).getCommonCost() == 0) {
          groupArrayList.remove(i);
          i--;
          size--;
        }
      }
      System.out.println("SSSSSSSSSSIIIIIIIIZZZZZEEEE:--" + groupArrayList.size());
      for (Group n : groupArrayList) {
        System.out.println(n.getName());
        System.out.println(n.getCommonCost());
      }
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      int minIndex = 0;

      ///////////////////////////////////////////////////////////////
      //нужно удалить все нули в начале
              ///////////////////////////////////////////////////////
      String nameOfMin = groupArrayList.get(minIndex).getName();
      if (!team.containsKey(nameOfMin)) {
        groupArrayList.get(minIndex).setQuantity(1);

      } else {
        int quantity = team.get(nameOfMin);
        groupArrayList.get(minIndex).setQuantity(quantity + 1);

      }
      team.put(nameOfMin, groupArrayList.get(minIndex).getQuantity());
      expectedProductivity -= groupArrayList.get(minIndex).getProductivity();
    }
    return team;
  }

  private ArrayList<Group> deleteAllZeros(ArrayList<Group> groupArrayList) {

    return groupArrayList;
  }
}
