
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
  ////////////////////////чистим каждый от повторяшек/////////////////////////////
  for (int i = 0; i < commonArray.length; i++) {
    commonArray[i] = searchForItem.deleteEqual(commonArray[i], false);
    }

    for (Integer[] n : commonArray) {
      for (Integer k : n) {
        System.out.print(k + " ");
      }
      System.out.println( "!!!!!!!!!!!!");
    }
    ///////////////////////////////////////////////////////////////////////////////

    //////////////объеденяем чищеные массивы в один/////////////////
    Integer[] commonLongArray = {};
  for (int i = 0; i < 3; i++) {
    commonLongArray = searchForItem.joinArrays(commonLongArray, commonArray[i]);
  }
    for (Integer n : commonLongArray) {
      System.out.print(n + " ");
    }
    System.out.println();
  //////////////////////////////////////////////////////////////////////
 Integer[] almostAnswer = searchForItem.deleteEqual(commonLongArray, true);
    for (Integer n : almostAnswer) {
      System.out.print(n + " ");
    }
    System.out.println();

    Integer[] answer = searchForItem.deleteEqual(almostAnswer, false);
    for (Integer n : answer) {
      System.out.print(n + " ");
    }
    System.out.println();

  }
}
