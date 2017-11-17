import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 17.11.17.
 */
public class CoordinateTest {

  @Test
  public void checkFirstConstructor() {
    String string = "a 2";
    Coordinate coordinate = new Coordinate(string);
    assertEquals(0, coordinate.getLetter());
    assertEquals(1, coordinate.getNumber());
  }

  @Test
  public void checkSecondConstructor() {
    Coordinate coordinate = new Coordinate(10);
    if (coordinate.getLetter() > 9 || coordinate.getNumber() > 9) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkSecondConstructorForThriwingExeption() {
    Coordinate coordinate = new Coordinate(-10);
  }
}