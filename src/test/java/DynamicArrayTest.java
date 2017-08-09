import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 08.08.17.
 */
public class DynamicArrayTest {
  @Test
  public void setIfStackNotOverflow() throws Exception {
    DynamicArray array = new DynamicArray(5);
    array.set(2, 0);
    assertEquals(2, array.get(0));
  }

  @Test
  public void setIfStackOverflow() throws Exception {
    DynamicArray array = new DynamicArray(5);
    array.set(2, 7);
    assertEquals(2, array.get(7));
  }

  @Test
  public void checkIfElementsAreShiftedToTheLefttAfterDeletion() throws Exception {
    DynamicArray array = new DynamicArray(5);
    for (int i = 0; i < 5; i++) {
      array.set(i + 1, i);
    }
    array.delete(2);
    for (int i = 2; i < 5; i++) {
      assertEquals(i + 1, array.get(i));
    }
  }

  @Test
  public void checkifElementInserted() throws Exception {
    DynamicArray array = new DynamicArray(5);
    array.insert(5,2);
    int expectedElement = 5;
    int actualElement = array.get(2);
    assertEquals(expectedElement, actualElement);
  }

  @Test
  public void checkIfElementsAreShiftedToTheRightAfterInsertion () throws Exception {
    DynamicArray array = new DynamicArray(5);
    for (int i = 0; i < 5; i++) {
      array.set(i + 1, i);
    }
    array.insert(5,2);
    for (int i = 3; i < array.getSize(); i++) {
      assertEquals(i, array.get(i));
    }
  }

  @Test
  public void checkIfSizeHasRisedAfterInsertion () {
    DynamicArray array = new DynamicArray(5);
    array.insert(5,2);
    int expectedSize = 6;
    int actualSize = array.getSize();
    assertEquals(expectedSize, actualSize);
  }



}