import java.util.*;

/**
 * Collection in which all elements ara counted for number of repetitions.
 * Elements don't repeats.
 * The number of repetitions corresponds to each element.
 */
public class CountedCollection {
  private HashMap<Object, Integer> hashMap;

  /**
   * Initializes countedCollection on the basis of the gotten.
   * Counts quantity of repetitions of each elements and saves into {@link CountedCollection#hashMap}
   * @param collection collection on tha basis of which builds counted collection.
   */
  public CountedCollection(Collection collection) {
    hashMap = new HashMap<Object, Integer>();
    Integer am;
    for (Object i : collection) {
      am = hashMap.get(i);
      hashMap.put(i, am == null ? 1 : am + 1);
    }
  }

  /**
   * Removes non-repeatable elements from {@link CountedCollection#hashMap}
   */
  public void removeNonRepeatable() {
    for(Object key : hashMap.keySet().toArray()) {
      if (hashMap.get(key) == 1) {
        hashMap.remove(key);
      }
    }
  }

  public Set<Map.Entry<Object,Integer>> entrySet()   {
    return hashMap.entrySet();
  }

  public int getSize() {
    return hashMap.size();
  }
}
