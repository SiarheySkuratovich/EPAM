package Criteria;

import Employees.Group;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Criterion3: The minimum number of employees is higher than Junior for fixed productivity.
 */
public class NonJunior{

  /**
   * Realizes {@link Cost#count(int, ArrayList)} without juniors.
   * @param expectedProductivity expectedProductivity of customer.
   * @param groupArrayList available developers
   * @return selected team of Devs.
   */
  public HashMap<String, Integer> count(int expectedProductivity, ArrayList<Group> groupArrayList) {
    final int JUNIOR_INDEX = 0;
    groupArrayList.remove(JUNIOR_INDEX);
    Cost cost = new Cost();
    return cost.count(expectedProductivity, groupArrayList);
  }
}
