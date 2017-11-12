

/**
 * Makes tests on different features of path in Windows OS.
 */
public class PathValidator {
  final static String[] reservedNames;
  final static String[] forbiddenCharacters;

  static {
    reservedNames = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2",
            "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1",
            "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
    forbiddenCharacters = new String[] {"<", ">", ":", "\"", "|", "?", "*" };
  }

  /**
   * Checks whether correct folder Names, namely endings.
   * Returns true if correct and false if it's not.
   * @param path for check.
   */
  public boolean checkForValidFolderEndings(String path) {
    for (int i = 0; i < path.length() - 1; i++) {
      if((path.charAt(i) == ' ' || path.charAt(i) == '.') && (path.charAt(i + 1) == '\\' || path.charAt(i + 1) == '/')) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for reserved names in specified path.
   * Returns true if contains and false if it's not.
   * @param path for check.
   * @return
   */
  public boolean сontainsReservedNamesIn(String path) {
    for (String n : reservedNames) {
      if (path.contains(n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check for slashes in folder names.
   * Checks only ending because slashes within names not possible to check.
   * Return true if contains and false if it's not.
   * @param path for check.
   */
  public boolean containsRepeatingSlashesIn(String path) {
    for (int i = 0; i < path.length() - 2; i++) {
      if ((path.charAt(i) == '\\'  && path.charAt(i + 2) == '\\') || (path.charAt(i) == '/'  && path.charAt(i + 2) == '/')) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines whether relative path is valid.
   *
   * @param path for check.
   */
  public boolean isValidRelativePath(String path) {
    int i = path.indexOf("..\\");
    if (i < 2) {
      return false;
    }
    for (i = path.indexOf("..\\"); i < path.length() - 2; i++) {

      if ((path.substring(i, i + 3).equals("..\\") && !path.substring(i - 3, i).equals("..\\")) ||
              (path.substring(i, i + 3).equals("../") && !path.substring(i - 3, i).equals("../"))) {
        return false;
      }
    }
    return true;
  }


  public boolean containsSpecifierIn(String path) {
    String[] specifiers = {"..\\", "../", ".\\", "./"};
    for (String n: specifiers) {
      if(path.contains(n)) {
        return true;
      }
    }
    return false;
  }
  public String deleteSpecifiers(String path) {
    String[] specifiers = {"..\\", "../", ".\\", "./"};
    StringBuffer pathBuffer = new StringBuffer(path);
    for (int i = 0; i < pathBuffer.length() - 3; i++) {
      for (String n: specifiers) {
        if(pathBuffer.substring(i, i + 3).equals(n)) {
          pathBuffer.delete(i, i + 2);
          i--;
          break;
        }
      }
    }
    return pathBuffer.toString();
  }

  boolean containsReservedCharactersIn(String path) {
    for (int i = 0; i < forbiddenCharacters.length; i++) {
      if (path.contains(forbiddenCharacters[i])) {
        return true;
      }
    }
    return false;
  }

  public boolean containsDiskDesignator(String path) {
      return isLatinSymbol(path.charAt(0)) && path.charAt(1) == ':';
    }

  public boolean isLatinSymbol(char symbol) {
    if ((symbol > 65 && symbol < 90) || (symbol > 97) && (symbol < 122)) {
      return true;
    }
    return false;
  }

  public boolean areValidNameLengthsIn(String path) {
    int folderNameLength = 0;
    for(int i = 0; i < path.length(); i++) {
      folderNameLength++;
      if(path.charAt(i) == '\\' || path.charAt(i) == '/' || i == path.length() - 1) {
        if(folderNameLength >=255) {
          return false;
        }
        folderNameLength = 0;
      }
    }
    return true;
  }

  public boolean isExtendedLengthPath(String path) {
    if (path.length() > 5) {
      return path.substring(0, 4).equals("\\\\?\\") || path.substring(0, 4).equals("//?/");
    }
    return false;
  }
  public boolean isValidExtendedLengthPath(String path) {
    return !path.contains("/");
  }

  public String deletePrefix(String path) {
    return path.substring(4, path.length());
  }

  public String deleteDiskDesignator(String path) {
    return path.substring(3, path.length());
  }
}
