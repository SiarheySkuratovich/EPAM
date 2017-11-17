import java.util.Scanner;

/**
 * Created by siarhey on 17.11.17.
 */
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    EnemyField enemyField = new EnemyField();
    int quantityOfShoots = 0;
    while (enemyField.getShipQuantitiy() != 0) {
      System.out.println("Print through a space assumed ship coordinates(letter and number) or print \"exit\" to exit:");
      String string = in.nextLine();
      if (string.equals("exit")){
        break;
      }
      Coordinate coordinate = new Coordinate(string);
      if (enemyField.contains(coordinate)) {
        System.out.println("you hit the target!");
        enemyField.kill(coordinate);
      } else {
        System.out.println("miss:(");
      }
      quantityOfShoots++;
    }
    System.out.println("quantity of shoots:" + quantityOfShoots);
    System.out.println("quantity of sunken ships:" + enemyField.getShipQuantitiy());
  }
}
