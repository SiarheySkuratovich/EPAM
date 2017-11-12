

/**
 * Makes tests on different features of path in Windows OS.
 */
public class Path {
  String path;
  final static String[] reservedNames;
  final static char[] forbiddenCharacters;

  static {
    reservedNames = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2",
            "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1",
            "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
    forbiddenCharacters = new char[] {'<', '>', ':', '\"', '|', '?', '*'};
  }

  Path(String path) {
    this.path = path;
  }

  /**
   * Checks whether correct folder Names, namely endings.
   * Returns true if correct and false if it's not.
   */
  public boolean checkForValidFolderEndings() {
    replaceAllFrontSlashes();
    for (int i = setStartIndex(); i < path.length() - 1; i++) {
      if((path.charAt(i) == ' ' || path.charAt(i) == '.') && path.charAt(i + 1) == '\\') {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for reserved names in specified path.
   * Returns true if contains and false if it's not.
   * @return
   */
  public boolean сontainsReservedNamesIn() {
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
   */
  public boolean containsRepeatingSlashesIn() {
    replaceAllFrontSlashes();
    int i = 0;
    if (isExtendedLengthPath()) {
      i = 5;
    }
    while (i < path.length() - 2) {
      if ((path.charAt(i) == '\\'  && path.charAt(i + 2) == '\\')) {
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean containsForbiddenCharactersIn() {
    for (int i = setStartIndex(); i < path.length(); i++) {
      for (char n : forbiddenCharacters) {
        if (path.charAt(i) == forbiddenCharacters[i]) {
          return true;
        }
      }
    }
    return false;
  }


  public boolean areValidNameLengthsIn() {
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

  public boolean isExtendedLengthPath() {
    if (path.length() > 5) {
      if (path.substring(0, 4).equals("\\\\?\\")) {
        return true;
      }
    }
    return false;
  }
  public boolean isValidExtendedLengthPath() {
    return !path.contains("/");
  }


  public int countNesting() {
    int counter = 0;
    for (int i = path.indexOf("..\\"); i < path.length() - 2; i += 3) {
      if (path.substring(i, i + 3).equals("..\\")) {
        counter++;
      }
    }
    return counter;
  }

  private boolean containsCurrentFolderSpecifier() {
    return path.contains(".\\");
  }

  private boolean containsParentFolderSpecifier() {
    return path.contains("..\\");
  }

  private boolean containsDiskDesignator() {
    int startIndex;
    if (isExtendedLengthPath()) {
      startIndex = 5;
    } else {
      startIndex = 0;
    }
    return isLatinSymbol(path.charAt(startIndex)) && path.charAt(startIndex + 1) == ':';
  }


  private boolean isLatinSymbol(char symbol) {
    if ((symbol > 65 && symbol < 90) || (symbol > 97) && (symbol < 122)) {
      return true;
    }
    return false;
  }


  private void replaceAllFrontSlashes() {
    StringBuffer buffer = new StringBuffer(path);
    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == '/') {
        buffer.replace(i, i + 1, "\\");
      }
    }
    path = buffer.toString();
  }

  private int setStartIndex() {

    int startIndex = 0;
    if (isExtendedLengthPath())
    {
      if(isValidExtendedLengthPath()) {
        startIndex = 5;
      } else {
        startIndex = 0;
      }
    }
    replaceAllFrontSlashes();
    if (containsCurrentFolderSpecifier()) {
      startIndex += 2;
    } else if (containsParentFolderSpecifier()) {
      startIndex += countNesting();
    }
    if(containsDiskDesignator()) {
      startIndex += 2;

    }
    System.out.println(startIndex);
    return startIndex;
  }
}
