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
    assertEquals(expected.entrySet(), actual.entrySet());
  }

  @org.junit.Test
  public void emptyCollection() throws Exception {
    CountedCollection countedCollection = new CountedCollection(new ArrayList());
    int actual = countedCollection.getSize();
    int expected = 0;
    assertEquals(expected, actual);
  }
}