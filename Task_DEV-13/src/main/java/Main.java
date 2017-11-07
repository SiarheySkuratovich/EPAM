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

    Group[] groups = new Group[4];
    groups[0] = new Group("Juniors", 500, 3);
    groups[1] = new Group("Middles", 700, 5);
    groups[2] = new Group("Seniors", 1000, 8);
    groups[3] = new Group("Leads", 1200, 10);
    Productivity productivity = new Productivity();
    HashMap<String, Integer> team = productivity.count(5700, 20, groups);

    for (Map.Entry<String, Integer> n : team.entrySet()) {
      System.out.println(n.getKey() + ": " + n.getValue());
    }
  }
}
