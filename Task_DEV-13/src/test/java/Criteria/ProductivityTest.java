package Criteria;

import Employees.Group;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 08.11.17.
 */
public class ProductivityTest {
  @org.junit.Test(expected = IllegalArgumentException.class )
  public void count() throws Exception {
    ArrayList<Group> groupArrayList = new ArrayList<Group>();
    groupArrayList.add(new Group("Juniors", 500, 3));
    groupArrayList.add(new Group("Middles", 700, 5));
    groupArrayList.add(new Group("Seniors", 1000, 8));
    groupArrayList.add(new Group("Leads", 1200, 10));
    Productivity productivity = new Productivity();
    HashMap<String, Integer> team = productivity.count(2, groupArrayList);
  }

}