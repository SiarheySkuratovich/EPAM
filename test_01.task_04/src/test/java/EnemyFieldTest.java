import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 17.11.17.
 */
public class EnemyFieldTest {

  @Test
  public void checkInitializesWithoutExсeptions() throws Exception {
    EnemyField enemyField = new EnemyField();
  }

  @Test
  public void checkWhetherQuantityOfShipsiIsAccptable() {
    EnemyField enemyField = new EnemyField();
    if (enemyField.getShipQuantity() < 1) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Test
  public void checkWhetherShipLocationIsAcceptableForHorizontalCriterion() {
    EnemyField enemyField = new EnemyField();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (enemyField.getField()[i][j] == true) {;
          if (j != 0 && j != 9) {
            if(enemyField.getField()[i][j - 1] || enemyField.getField()[i][j + 1]) {
              throw new IllegalArgumentException();
            }
          }
        }
      }
    }
  }

  @Test
  public void checkWhetherShipLocationIsAcceptableForVerticalCriterion() {
    EnemyField enemyField = new EnemyField();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (enemyField.getField()[i][j] == true) {;
          if (i != 0 && i != 9){
            if(enemyField.getField()[i - 1][j] || enemyField.getField()[i + 1][j]) {
              throw new IllegalArgumentException();
            }
          }
        }
      }
    }
  }

  @Test
  public void checkWhetherShipLocationIsAcceptableForFirstDiagonalCriterion() {
    EnemyField enemyField = new EnemyField();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (enemyField.getField()[i][j] == true) {
          if (i != 0 && j != 0 && i != 9 && j != 9) {
            if (enemyField.getField()[i - 1][j - 1] || enemyField.getField()[i + 1][j + 1]) {
              throw new IllegalArgumentException();
            }
          }
        }
      }
    }
  }

  @Test
  public void checkWhetherShipLocationIsAcceptableForSecondDiagonalCriterion() {
    EnemyField enemyField = new EnemyField();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (enemyField.getField()[i][j] == true) {
          if (i != 0 && j != 0 && i != 9 && j != 9) {
            if(enemyField.getField()[i + 1][j - 1] || enemyField.getField()[i - 1][j + 1]) {
              throw new IllegalArgumentException();
            }
          }
        }
      }
    }
  }
}