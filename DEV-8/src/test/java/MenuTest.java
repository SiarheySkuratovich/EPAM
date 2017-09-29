import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
  @Test
  public void countTypes() throws Exception {
    Storage storage = new Storage();
    setDefaultStorage(storage);
    Menu menu = new Menu();
    int expected = 2;
    int actual = menu.countTypes(storage);
    assertEquals(expected, actual);
  }

  @Test
  public void countAveragePrice() throws Exception {
    Storage storage = new Storage();
    setDefaultStorage(storage);
    Menu menu = new Menu();
    double expected = 6;
    double actual = menu.countAveragePrice(storage);
    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void countAveragePriceType() throws Exception {
    Storage storage = new Storage();
    setDefaultStorage(storage);
    Menu menu = new Menu();
    double expected = 6.5;
    double actual = menu.countAveragePriceType(storage, "furniture");
    assertEquals(expected, actual, 0.01);
  }

  /**
   * Sets 3 products created manually into storage.
   */
  public void setDefaultStorage(Storage storage) {
    Product apple = new Product("fruit", "apple", 2, 5);
    Product pencil= new Product("furniture", "table", 3, 4);
    Product chair = new Product("furniture", "chair", 5, 9);
    storage.addProduct(apple);
    storage.addProduct(pencil);
    storage.addProduct(chair);
  }
}