
/**
 * Created by siarhey on 01.10.17.
 */
public class Main {
  public static void main(String[] args) {
    Double[] a = {2.2, 4.3, 5.0, 4.2, 3.2, 3.0, 5.7};
    Double[] b = {2.1, 2.2, 4.0, 3.2, 2.1, 4.9};
    Double[] c = {3.6, 5.7, 2.5, 5.0, 8.5, 3.3, 2.7, 4.9};
    Double[][] commonArray = new Double[3][];
    commonArray[0] = a;
    commonArray[1] = b;
    commonArray[2] = c;
    SearchForItem searchForItem = new SearchForItem();
    System.out.println("Source arrays:");
    for (Double[] n : commonArray) {
      for (Double k : n) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
    for (int i = 0; i < commonArray.length; i++) {
      commonArray[i] = searchForItem.deleteEqual(commonArray[i], false);
    }
    System.out.println("Deleted equal elements from each array:");
    for (Double[] n : commonArray) {
      for (Double k : n) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
    Double[] commonLongArray = {};
    for (int i = 0; i < 3; i++) {
      commonLongArray = searchForItem.joinArrays(commonLongArray, commonArray[i]);
    }
    System.out.println("All arrays are combined to one long array:");
    for (Double n : commonLongArray) {
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("Elements occurring in arrays two or more times");
    Double[] almostAnswer = searchForItem.deleteEqual(commonLongArray, true);
    for (Double n : almostAnswer) {
      System.out.print(n + " ");
    }
    System.out.println();
    Double[] answer = searchForItem.deleteEqual(almostAnswer, false);
    System.out.println("Repeating elements are removed. Final answer:");
    for (Double n : answer) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}
