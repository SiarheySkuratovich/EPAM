import java.util.Random;

public class RandomSymbolsSwap {
  public String swap(String firstString, String secondString) {
    Random random = new Random();
    int quantityOfSymbolsInSecond = random.nextInt(secondString.length());
    int fromPlaceInTheSecondString = random.nextInt(secondString.length() - quantityOfSymbolsInSecond);
    String temp = secondString.substring(fromPlaceInTheSecondString, fromPlaceInTheSecondString + quantityOfSymbolsInSecond);
    int toPlaceInTheFirstString = random.nextInt(firstString.length());
    String PartOfFirstString = firstString.substring(0, toPlaceInTheFirstString).concat(temp);
    int quantityOfSymbolsInFirst = random.nextInt(firstString.length() - toPlaceInTheFirstString);
    String finalFirstString = PartOfFirstString.concat(firstString.substring(toPlaceInTheFirstString + quantityOfSymbolsInFirst));
    return finalFirstString;
  }
}