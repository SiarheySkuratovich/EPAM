import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 14.11.17.
 */
public class CountedCollectionTest {
  @org.junit.Test
  public void removeNonRepeatable() throws Exception {
    Integer[] array = {1, 2, 3, 1};
    CountedCollection countedCollection = new CountedCollection(Arrays.asList(array));
    countedCollection.removeNonRepeatable();
    int actual = countedCollection.getSize();
    int expected = 1;
    assertEquals(expected, actual);
  }

  /*public void () throws Exception {
    Integer[] array = {1, 2, 3, 1};
    CountedCollection countedCollection = new CountedCollection(Arrays.asList(array));
    countedCollection.removeNonRepeatable();
    int actual = countedCollection.getSize();
    int expected = 1;
    assertEquals(expected, actual);
  }*/

  @org.junit.Test
  public void entrySet() throws Exception {

  }

}