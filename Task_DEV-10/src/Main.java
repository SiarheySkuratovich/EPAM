import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by siarhey on 01.10.17.
 */
public class Main {
  public static void main(String[] args) {
   Integer[] a = {2, 4, 5 ,42, 32,3};
   Integer[] b = {21,3,4,3,21,4};
   Integer[] c = {3,5,2,5,8,3,2,5,6};

  Integer[][] commonArray = new Integer[3][];

  commonArray[0] = a;
  commonArray[1] = b;
  commonArray[2] = c;

  SearchForItem searchForItem = new SearchForItem();
  for (int i = 0; i < commonArray.length; i++) {
    commonArray[i] = searchForItem.deleteEqual(commonArray[i]);
    }

    for (Integer[] n : commonArray) {
      for (Integer k : n) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
  /*ArrayList<Integer> ARRAY = searchForItem.findEqual(array);
    for (int i = 0; i < ARRAY.size(); i++) {
      System.out.println(ARRAY.get(i));
    }*/

    /*for (Integer n:arrayList) {
      System.out.println(n);
    }*/

  }
}
