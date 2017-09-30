import java.util.Random;

public class RandomSymbolsSwap {
  public String swap(String firstString, String secondString) {
    Random random = new Random();
    int quantityOfSymbols = random.nextInt(secondString.length());
    int fromPlaceInTheSecondString = random.nextInt(secondString.length() - quantityOfSymbols);
    String temp = secondString.substring(fromPlaceInTheSecondString, fromPlaceInTheSecondString + quantityOfSymbols);
    int toPlaceInTheFirstString = random.nextInt(firstString.length() - quantityOfSymbols);
    String PartOfFirstString = firstString.substring(0, toPlaceInTheFirstString).concat(temp);
    String finalFirstString = PartOfFirstString.concat(firstString.substring(toPlaceInTheFirstString + quantityOfSymbols));
    return finalFirstString;
  }
}