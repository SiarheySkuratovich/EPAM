import java.util.Arrays;

/**
 * Created by siarhey on 09.11.17.
 */
public class ReservedCharacters {
  final static String reservedCharacters;

  static {
    reservedCharacters = "<>:\"|?*";
  }

  boolean containedIn(String path) {
    for (int i = 1; i < reservedCharacters.length(); i++) {
      if (Arrays.asList(path).contains(reservedCharacters.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}
