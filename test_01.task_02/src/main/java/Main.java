import java.util.ArrayList;

/**
 * Created by siarhey on 13.11.17.
 */
public class Main {
  public static void main(String[] args) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(1);
    arrayList.add(3);
    CountedCollection countedCollection = new CountedCollection(arrayList);
    countedCollection.removeNonRepeatable();
    System.out.println("Quantity of repeatable objects is: " + countedCollection.getSize());
  }
}
