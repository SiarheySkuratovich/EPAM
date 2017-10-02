/**
 * Determines elements occurring in different arrays two or more times.
 * Does it for 4 stages.
 * First: deletes equal elements from each array.
 * Second: Combines all arrays to one long array.
 * Third: Highlights elements occurring two or more times.
 * Fourth: Removes repeating elemens.
 * @see ArraysWorker#deleteEqual(Double[], boolean)
 */
public class Main {

  /**
   * Entry point of the program.
   * @param args comand line values.
   */
  public static void main(String[] args) {
    Double[] a = {2.2, 4.3, 5.0, 4.2, 3.2, 3.0, 5.7};
    Double[] b = {2.1, 2.2, 4.0, 3.2, 2.1, 4.9};
    Double[] c = {3.6, 5.7, 2.5, 5.0, 8.5, 3.3, 2.7, 4.9};
    Double[][] commonArray = new Double[3][];
    commonArray[0] = a;
    commonArray[1] = b;
    commonArray[2] = c;
    ArraysWorker arraysWorker = new ArraysWorker();
    for (int i = 0; i < commonArray.length; i++) {
      commonArray[i] = arraysWorker.deleteEqual(commonArray[i], false);
    }
    Double[] commonLongArray = {};
    for (int i = 0; i < 3; i++) {
      commonLongArray = arraysWorker.combineArrays(commonLongArray, commonArray[i]);
    }
    Double[] almostAnswer = arraysWorker.deleteEqual(commonLongArray, true);
    Double[] answer = arraysWorker.deleteEqual(almostAnswer, false);
    System.out.println("Elements occurring two or more times:");
    for (Double n : answer) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}
