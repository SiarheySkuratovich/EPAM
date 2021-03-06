import java.util.Random;

/**
 * Swaps symbols in strings.
 */
public class SymbolsSwap {

  /**
   * Gets a piece of the second string and puts instead another piece in the first string.
   * Length of string pieces, places of cutting and insertion are chosen randomly.
   * @param firstString a string we gets to insert symbols into it.
   * @param secondString a string we gets to cut symbols from it.
   * @return first string after swapping.
   */
  public String swapPiecesRandomly(String firstString, String secondString) throws java.lang.IllegalArgumentException {
    if (firstString.length() == 1 || secondString.length() == 1) {
      throw new  java.lang.IllegalArgumentException("Requires a sequence of characters. Not one symbol.");
    }
    Random random = new Random();
    int quantityOfSymbolsInSecond = random.nextInt(secondString.length() - 1) + 1;
    int fromPlaceInTheSecondString = random.nextInt(secondString.length() - quantityOfSymbolsInSecond);
    String temp = secondString.substring(fromPlaceInTheSecondString, fromPlaceInTheSecondString + quantityOfSymbolsInSecond);
    int toPlaceInTheFirstString = random.nextInt(firstString.length());
    String PartOfFirstString = firstString.substring(0, toPlaceInTheFirstString).concat(temp);
    int quantityOfSymbolsInFirst = 0;
    if (firstString.length() == toPlaceInTheFirstString + 1) {
      quantityOfSymbolsInFirst = 1;
    } else {
      quantityOfSymbolsInFirst = random.nextInt(firstString.length() - toPlaceInTheFirstString - 1) + 1;
    }
    firstString = PartOfFirstString.concat(firstString.substring(toPlaceInTheFirstString + quantityOfSymbolsInFirst));
    return firstString;
  }
}