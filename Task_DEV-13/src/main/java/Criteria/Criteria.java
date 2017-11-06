package Criteria;

import Employees.Group;

import java.util.HashMap;

/**
 * Created by siarhey on 03.11.17.
 */
public interface Criteria {
  HashMap<String, Integer> count(int money, int ExpectedProductivity, Group[] groups);
}
