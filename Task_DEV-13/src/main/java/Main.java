import Criteria.Cost;
import Criteria.Productivity;
import Employees.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siarhey on 02.11.17.
 */
public class Main {
  public static void main(String[] args) {

    ArrayList<Group> groupArrayList = new ArrayList<Group>();
    groupArrayList.add(new Group("Juniors", 500, 3));
    groupArrayList.add( new Group("Middles", 700, 5));
    groupArrayList.add(new Group("Seniors", 1000, 8));
    groupArrayList.add(new Group("Leads", 1200, 10));
    /*Productivity productivity = new Productivity();
    HashMap<String, Integer> team = productivity.count(5700, 20, groups);*/

    Cost cost = new Cost();
    HashMap<String, Integer> team = cost.count(5700, 20, groupArrayList);
    for (Map.Entry<String, Integer> n : team.entrySet()) {
      System.out.println(n.getKey() + ": " + n.getValue());
    }
  }
}
