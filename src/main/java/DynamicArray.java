import java.util.Arrays;

/**
 * Dynamic array class.
 */
public class DynamicArray {
  private int[] array;
  private int arraySize;

  /**
   * Used for creating a dynamic array-class.
   * @param length is the user's initial prefered array length.
   */
  DynamicArray(int length) {
    array = new int[length];
    arraySize = length;
  }

  /**
   * Returns an element by it's index.
   */
  public int get(int index) {
    return array[index];
  }

  /**
   * Returns size of array.
   */
  public int getSize() {
    return arraySize;
  }

  /**
   * Used for setting element to user's prefered index.
   * if the index is bigger than an array size - method increases it's size 2 times more than the index.
   */
  public void set(int element, int index) {
    if (index >= arraySize)
    {
      array = Arrays.copyOf(array, 2*(index + 1));
      array[index] = element;
      arraySize = 2*(index + 1);
    } else {
      array[index] = element;
    }
  }

  /**
   * Deletes element by it's index, while the order on the right side shifts to left.
   */
  public void delete(int index) {
    for (int i = index; i > arraySize - 1; i++) {
      array[i] = array[i + 1];
    }
    arraySize--;
  }

  /**
   * Inserts elements on the user's prefered index shifting to the right the order.
   * Herewith allocates an additional cell.
   */
  public void insert(int element, int index) {
    arraySize += 1;
    int[] newArray = new int[arraySize];
    int i = 0;
    while (i < arraySize) {
      if (i < index) {
        newArray[i] = array[i];
      } else if (i == index) {
        newArray[i] = element;
      } else {
        newArray[i] = array[i - 1];
      }
      i++;
    }
    array = newArray;
  }
}
