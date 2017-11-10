

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
      if((path.charAt(i) == ' ' || path.charAt(i) == '.') && path.charAt(i + 1) == '\\') {
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
      if ((path.charAt(i) == '\\'  && path.charAt(i + 2) == '\\')) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines whether path is relative.
   * Returns true if it is and false if it's not.
   * @param path for check.
   */
  public boolean isRelativePath(String path) {
    int startIndex;
    if(containsDiskDesignator(path)) {
      startIndex = 2;
    } else {
      startIndex = 0;
    }
    if (path.indexOf("..\\") == startIndex || path.indexOf(".\\") == startIndex) {
      return true;
    }
    return false;
  }


  boolean containsForbiddenCharactersIn(String path) {
    int i = 0;
    if (isExtendedLengthPath(path))
    {
      if(isValidExtendedLengthPath(path)) {
        path = replaceAllFrontSlashes(path);
        i = 5;
      } else {
        return false;
      }
    }
    if(containsDiskDesignator(path)) {
      i += 2;
      if (isRelativePath(path)) {
        i += 3;
      }
    }
    while (i < forbiddenCharacters.length) {
      if (path.contains(forbiddenCharacters[i])) {
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean containsDiskDesignator(String path) {
    int startIndex;
    if (isExtendedLengthPath(path)) {
      startIndex = 5;
    } else if (isRelativePath(path)){
      startIndex = 0;
    }
      return isLatinSymbol(path.charAt(startIndex)) && path.charAt(startIndex + 1) == ':';
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
      if(path.charAt(i) == '\\' || i == path.length() - 1) {
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
      if (path.substring(0, 4).equals("\\\\?\\")) {
        return true;
      }
    }
    return false;
  }
  public boolean isValidExtendedLengthPath(String path) {
    return !path.contains("/");
  }

  public String replaceAllFrontSlashes(String path) {
    StringBuffer buffer = new StringBuffer(path);
    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == '/') {
        buffer.replace(i, i + 1, "\\");
      }
    }
    return buffer.toString();
  }

  private int setStartIndex(String path) {
    int startIndex = 0;
    if (isExtendedLengthPath(path))
    {
      startIndex = 5;
    } else if (isRelativePath(path)) {
      startIndex += 3;
    }
    if(containsDiskDesignator(path)) {
      startIndex += 2;

    }
    return startIndex;
  }
}
