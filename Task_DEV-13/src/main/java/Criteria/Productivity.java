package Criteria;

import Employees.Group;

import java.util.*;

public class Productivity implements Criteria{

  private HashMap<String, Integer> team = new HashMap<String, Integer>();

  public HashMap<String, Integer> count(int money, int ExpectedProductivity, Group[] groups) {
    int[] productivity = new int[4];
    int iterator = 0;
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
      for (Group n : groups) {
        System.out.println(n.getName());
        System.out.println(n.getCommonProductivity());
      }
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      if (!team.containsKey(groups[groups.length - 1].getName())) {
        iterator = 1;
      } else {
        iterator = team.get(groups[groups.length - 1].getName()) + 1;
      }
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println(iterator);
      team.put(groups[groups.length - 1].getName(), iterator);
      money -= groups[groups.length - 1].getSalary();
      System.out.println(money);
      System.out.println(team.size());
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    return team;
  }


}
