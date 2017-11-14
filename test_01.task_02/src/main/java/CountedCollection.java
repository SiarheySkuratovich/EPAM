import java.util.*;

/**
 * Created by siarhey on 13.11.17.
 */
public class CountedCollection {
  private HashMap<Object, Integer> hashMap;

  public CountedCollection(List arrayList) {
    hashMap = new HashMap<Object, Integer>();
    Integer am;
    for (Object i : arrayList) {
      am = hashMap.get(i);
      hashMap.put(i, am == null ? 1 : am + 1);
    }
  }

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
