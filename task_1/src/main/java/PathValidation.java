/**
 * Created by siarhey on 09.11.17.
 */
public class PathValidation {
  final static String[] reservedNames;

  static {
    reservedNames = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2",
            "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1",
            "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
  }
  public boolean checkIsValidFolderEndings(String path) {
    for (int i = 0; i < path.length() - 1; i++) {
      if((path.charAt(i) == ' ' || path.charAt(i) == '.') && (path.charAt(i + 1) == '\\' || path.charAt(i + 1) == '/')) {
        return false;
      }
    }
    return true;
  }
  public boolean isContainedReservedNames(String path) {
    for (String n : reservedNames) {
      if (path.contains(n)) {
        return true;
      }
    }
    return false;
  }

  public boolean isContainedRepeatedSlashes(String path) {
    for (int i = 1; i < path.length() - 1; i++) {
      if (path.charAt(i - 1) == '\\' && path.charAt(i) == '\\' && path.charAt(i + 1) == '\\') {
        return true;
      }
    }
    return false;
  }
  public boolean checkForValidRelativePaths(String path) {
    String specifier = returnSpecifier(path);
    if (specifier == null) {
      return true;
    }
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
  public String returnSpecifier(String path) {
    if (path.contains("..\\")) {
      return "..\\";
    } else if(path.contains("../")) {
      return "../";
    } else {
      return null;
    }
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
}
