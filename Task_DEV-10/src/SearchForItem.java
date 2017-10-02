import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by siarhey on 01.10.17.
 */
public class SearchForItem {
  public ArrayList<Integer> findEqual(Integer[][] array) {
    ArrayList<Integer> finalArray = new ArrayList<>();
    boolean mark = false;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        for (int k = i + 1; k < array.length; k++) {
          for (int l = 0; l < array[k].length; l++) {
            if (array[i][j] == array[k][l]) {
              finalArray.add(array[i][j]);
              mark = true;
              break;
            }
          }
          if (mark) {
            break;
          }
        }
      }
    }
    return finalArray;
  }

  public Integer[] deleteEqual(Integer[] array, boolean WhichReturn) {
    ArrayList<Integer> deletedSymbols = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    Collections.addAll(arrayList, array);
    for (int i = 0; i < arrayList.size(); i++) {
      for (int j = i + 1; j < arrayList.size(); j++) {
        if (arrayList.get(i) == arrayList.get(j)) {
          deletedSymbols.add(arrayList.get(i));
          arrayList.remove(j);
          j--;
        }
      }
    }
    if (!WhichReturn) {
      return arrayList.toArray(new Integer[0]);
    } else return deletedSymbols.toArray(new Integer[0]);
  }

  public Integer[] joinArrays (Integer[] array1, Integer[] array2) {
    Integer[] joinedArray = new Integer[array1.length + array2.length];
    for (int i = 0; i < array1.length + array2.length; i++) {
      if (i < array1.length) {
        joinedArray[i] = array1[i];
      } else {
        joinedArray[i] = array2[i - array1.length];
      }
    }
    return joinedArray;
  }
}

