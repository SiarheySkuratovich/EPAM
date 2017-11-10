/**
 * Created by siarhey on 09.11.17.
 */
public class FullPathChecker {

  public boolean checkForValidDiskDesignator(String path) {
    if (isLatinSymbol(path.charAt(0)) && path.charAt(1) == ':') {
      if (path.charAt(2) != '\\' || path.charAt(2) == '/') {
        return false;
      }
    }
    return true;
  }
  private boolean isLatinSymbol(char symbol) {
    if ((symbol > 65 && symbol < 90) || (symbol > 97) && (symbol < 122)) {
      return true;
    }
    return false;
  }
}
