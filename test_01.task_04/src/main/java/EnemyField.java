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

  EnemyField() {
    field = new boolean[FIELD_SIZE][FIELD_SIZE];
    shipQuantity = 0;
    fillWithFalse();
    Random random = new Random();
    for (int i = 0; i < random.nextInt(FIELD_SIZE - 1) + 1; i++) {
      int letter = random.nextInt(FIELD_SIZE);
      int number = random.nextInt(FIELD_SIZE);
      if(!(checkHorizontally(letter, number) || checkVertically(letter, number) ||
              checkFirstDiagonal(letter, number) || checkSecondDiagonal(letter, number))) {
        field[letter][number] = true;
        shipQuantity++;
      }
    }
  }

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

  public boolean contains(Coordinate coordinate) {
    return field[coordinate.getLetter()][coordinate.getNumber()];
  }

  public void kill(Coordinate coordinate) {
    shipQuantity--;
    field[coordinate.getLetter()][coordinate.getNumber()] = false;
  }

  private boolean checkHorizontally(int letter, int number) {
    if (number != 0 && number != FIELD_SIZE - 1) {
      return field[letter][number - 1] || field[letter][number + 1];
    }
    return false;
  }

  private boolean checkVertically(int letter, int number) {
    if (letter != 0 && letter != FIELD_SIZE - 1){
      return field[letter - 1][number] || field[letter + 1][number];
    }
    return false;
  }

  private boolean checkFirstDiagonal(int letter, int number) {
    if (letter != 0 && number != 0 && letter != FIELD_SIZE - 1 && number != FIELD_SIZE - 1) {
      return field[letter - 1][number - 1] || field[letter + 1][number + 1];
    }
    return false;
  }

  private boolean checkSecondDiagonal(int letter, int number) {
    if (letter != 0 && number != 0 && letter != FIELD_SIZE - 1 && number != FIELD_SIZE - 1) {
      return field[letter + 1][number - 1] || field[letter - 1][number + 1];
    }
    return false;
  }

  private void fillWithFalse() {
    for (int i = 0; i < FIELD_SIZE; i++) {
      Arrays.fill(field[i], false);
    }
  }
}
