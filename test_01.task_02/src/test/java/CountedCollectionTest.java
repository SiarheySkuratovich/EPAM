import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 14.11.17.
 */
public class CountedCollectionTest {
  @org.junit.Test
  public void testConstructor() {
    Integer[] array = {1, 2, 3, 1, 2, 2};
    CountedCollection actual = new CountedCollection(Arrays.asList(array));
    HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
    expected.put(1, 2);
    expected.put(2, 3);
    expected.put(3, 1);
    assertEquals(expected.entrySet(), actual.entrySet());
  }

  @org.junit.Test
  public void removeNonRepeatable() throws Exception {
    Integer[] array = {1, 2, 3, 1};
    CountedCollection countedCollection = new CountedCollection(Arrays.asList(array));
    countedCollection.removeNonRepeatable();
    int actual = countedCollection.getSize();
    int expected = 1;
    assertEquals(expected, actual);
  }

  @org.junit.Test
  public void emptyCollection() throws Exception {
    CountedCollection countedCollection = new CountedCollection(new ArrayList());
    countedCollection.removeNonRepeatable();
    int actual = countedCollection.getSize();
    int expected = 0;
    assertEquals(expected, actual);
  }
}