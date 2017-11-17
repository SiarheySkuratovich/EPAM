import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Self-filling enemy field.
 */
public class EnemyField {
  boolean[][] field;
  int shipQuantity;
  final int FIELD_SIZE = 10;

  /**
   * Field fills by ships in random places.
   * And their number is counted.
   */
  EnemyField() {
    field = new boolean[FIELD_SIZE][FIELD_SIZE];
    shipQuantity = 0;
    fillWithFalse();
    Random random = new Random();
    for (int i = 0; i < random.nextInt(FIELD_SIZE - 1) + 1; i++) {
      Coordinate randomCoordinate = new Coordinate(FIELD_SIZE);
      int letter = randomCoordinate.getLetter();
      int number = randomCoordinate.getNumber();
      if(!(checkHorizontally(randomCoordinate) || checkVertically(randomCoordinate) ||
              checkFirstDiagonal(randomCoordinate) || checkSecondDiagonal(randomCoordinate))) {
        field[letter][number] = true;
        shipQuantity++;
      }
    }
  }

  /**
   * Returns disposition of ships as HashMap.
   */
  public HashMap<Character, Integer> getHint() {
    HashMap<Character, Integer> hint = new HashMap<Character, Integer>();
    final int numberOfFirstLatinSymbol = 97;
    for (int i = 0; i < FIELD_SIZE; i++) {
      for (int j = 0; j < FIELD_SIZE; j++) {
        if(field[i][j] == true) {
          hint.put((char)(i + numberOfFirstLatinSymbol),j + 1);
        }
      }
    }
    return hint;
  }

  public int getShipQuantitiy() {
    return shipQuantity;
  }

  /**
   * Check whether a ship in the coordinate.
   * @param coordinate gotten coordinate to check.
   * Returns false if there is not a ship and true if vice versa.
   */
  public boolean contains(Coordinate coordinate) {
    return field[coordinate.getLetter()][coordinate.getNumber()];
  }

  /**
   * "kills" a ship in gotten coordinate.
   * @param coordinate gotten coordinate to kill a ship there.
   */
  public void kill(Coordinate coordinate) {
    shipQuantity--;
    field[coordinate.getLetter()][coordinate.getNumber()] = false;
  }

  /**
   * Returns true whether a ship can stands in specified coordinate and false if can't.
   * Сhecking is carried out horizontally
   * @param coordinate gotten coordinate to check.
   */
  private boolean checkHorizontally(Coordinate coordinate) {
    int letter = coordinate.getLetter();
    int number = coordinate.getNumber();
    if (number != 0 && number != FIELD_SIZE - 1) {
      return field[letter][number - 1] || field[letter][number + 1];
    }
    return false;
  }

  /**
   * Returns true whether a ship can stands in specified coordinate and false if can't.
   * Сhecking is carried out vertically
   * @param coordinate gotten coordinate to check.
   */
  private boolean checkVertically(Coordinate coordinate) {
    int letter = coordinate.getLetter();
    int number = coordinate.getNumber();
    if (letter != 0 && letter != FIELD_SIZE - 1){
      return field[letter - 1][number] || field[letter + 1][number];
    }
    return false;
  }

  /**
   * Returns true whether a ship can stands in specified coordinate and false if can't.
   * Сhecking is carried out on first diagonal
   * @param coordinate gotten coordinate to check.
   */
  private boolean checkFirstDiagonal(Coordinate coordinate) {
    int letter = coordinate.getLetter();
    int number = coordinate.getNumber();
    if (letter != 0 && number != 0 && letter != FIELD_SIZE - 1 && number != FIELD_SIZE - 1) {
      return field[letter - 1][number - 1] || field[letter + 1][number + 1];
    }
    return false;
  }

  /**
   * Returns true whether a ship can stands in specified coordinate and false if can't.
   * Сhecking is carried out on second diagonal
   * @param coordinate gotten coordinate to check.
   */
  private boolean checkSecondDiagonal(Coordinate coordinate) {
    int letter = coordinate.getLetter();
    int number = coordinate.getNumber();
    if (letter != 0 && number != 0 && letter != FIELD_SIZE - 1 && number != FIELD_SIZE - 1) {
      return field[letter + 1][number - 1] || field[letter - 1][number + 1];
    }
    return false;
  }

  /**
   * Fills field with default false value.
   */
  private void fillWithFalse() {
    for (int i = 0; i < FIELD_SIZE; i++) {
      Arrays.fill(field[i], false);
    }
  }
}
