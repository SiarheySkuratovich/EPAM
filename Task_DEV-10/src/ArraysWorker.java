import java.util.ArrayList;
import java.util.Collections;

/**
 * Works with floating-point arrays.
 * Contains useful methods.
 */
public class ArraysWorker {

  /**
   * Deletes equal floating-point elements.
   * @param array array wherein we are deletes equal elements.
   * @param WhichReturn manages return.
   * @return if true returns array of deleted symbols else returns purified source array.
   */
  public Double[] deleteEqual(Double[] array, boolean WhichReturn) {
    ArrayList<Double> deletedSymbols = new ArrayList<>();
    ArrayList<Double> arrayList = new ArrayList<>();
    Collections.addAll(arrayList, array);
    for (int i = 0; i < arrayList.size(); i++) {
      for (int j = i + 1; j < arrayList.size(); j++) {
        if (arrayList.get(i).equals(arrayList.get(j))) {
          deletedSymbols.add(arrayList.get(i));
          arrayList.remove(j);
          j--;
        }
      }
    }
    if (!WhichReturn) {
      return arrayList.toArray(new Double[0]);
    } else return deletedSymbols.toArray(new Double[0]);
  }

  /**
   * Combines floating-point arrays.
   * @param array1 Array we are going to put by the first.
   * @param array2 Array we are going to put by the second.
   * @return Combined array.
   */
  public Double[] combineArrays(Double[] array1, Double[] array2) {
    Double[] combinedArray = new Double[array1.length + array2.length];
    for (int i = 0; i < array1.length + array2.length; i++) {
      if (i < array1.length) {
        combinedArray[i] = array1[i];
      } else {
        combinedArray[i] = array2[i - array1.length];
      }
    }
    return combinedArray;
  }
}

