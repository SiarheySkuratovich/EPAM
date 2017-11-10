import java.util.Arrays;

/**
 * Created by siarhey on 09.11.17.
 */
public class PathValidation {
  final static String[] reservedNames;
  final static String[] reservedCharacters;

  static {
    reservedNames = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2",
            "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1",
            "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
    reservedCharacters = new String[] {"<", ">", ":", "\"", "|", "?", "*" };
  }
  public boolean checkForValidFolderEndings(String path) {
    for (int i = 0; i < path.length() - 1; i++) {
      if((path.charAt(i) == ' ' || path.charAt(i) == '.') && (path.charAt(i + 1) == '\\' || path.charAt(i + 1) == '/')) {
        return false;
      }
    }
    return true;
  }
    public boolean сontainsReservedNamesIn(String path) {
    for (String n : reservedNames) {
      if (path.contains(n)) {
        return true;
      }
    }
    return false;
  }

  public boolean containsRepeatingSlashesIn(String path) {
    for (int i = 1; i < path.length() - 1; i++) {
      if (path.charAt(i - 1) == '\\' && path.charAt(i) == '\\' && path.charAt(i + 1) == '\\') {
        return true;
      }
    }
    return false;
  }
  public boolean isValidRelativePath(String path) {
    if (path.length() > 6) {
      for (int i = 3; i < path.length() - 2; i++) {
        if ((path.substring(i, i + 3).equals("..\\") && !path.substring(i - 3, i).equals("..\\")) ||
                (path.substring(i, i + 3).equals("../") && !path.substring(i - 3, i).equals("../"))) {
          return false;
        }
      }
    }
    return true;
  }
  public boolean containsSpecifierIn(String path) {
    return path.contains("..\\") || path.contains("../");
  }
  public String deleteSpecifiers(String path) {
    StringBuffer pathBuffer = new StringBuffer(path);
    for (int i = 0; i < pathBuffer.length() - 2; i++) {
      if (pathBuffer.substring(i, i + 3).equals("..\\") || pathBuffer.substring(i, i + 3).equals("../")) {
        pathBuffer.delete(i, i + 3);
        i--;
      }
    }
    return pathBuffer.toString();
  }

  boolean containsReservedCharactersIn(String path) {
    for (int i = 0; i < reservedCharacters.length; i++) {
      System.out.println(reservedCharacters);
      if (Arrays.asList(path).contains(reservedCharacters[i])) {
        System.out.println(" я зашол!!");
        return true;
      }
    }
    return false;
  }

  public boolean isDiskDesignator(String path) {
      return isLatinSymbol(path.charAt(0)) && path.charAt(1) == ':';
    }

  public boolean isLatinSymbol(char symbol) {
    if ((symbol > 65 && symbol < 90) || (symbol > 97) && (symbol < 122)) {
      return true;
    }
    return false;
  }
}
