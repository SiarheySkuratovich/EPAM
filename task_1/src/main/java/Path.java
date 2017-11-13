
/**
 * Makes tests on different features of path in Windows OS.
 */
public class Path {
  private String path;
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

  public String getPath() {
    return path;
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
   * Returns true if contains and false if doesn't.
   * @return
   */
  public boolean сontainsReservedNames() {
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
   * if path is extended length, skips prefix.
   * Return true if contains and false if doesn't.
   */
  public boolean containsRepeatingSlashes() {
    replaceAllFrontSlashes();
    int i = 0;
    if (isExtendedLengthPath()) {
      i = 5;
    }
    return path.substring(i, path.length()).contains("\\\\");
  }

  /**
   * Checks for forbidden characters in path.
   * Skips different specifiers at the beginning of path.
   * Checking is carried out with received start index gotten by {@link Path#setStartIndex()}
   * Returns true if path contains forbidden characters and false if doesn't.
   */
  public boolean containsForbiddenCharacters() {;
    for (int i = setStartIndex(); i < path.length(); i++) {
      for (char n : forbiddenCharacters) {
        if (path.charAt(i) == n) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks for valid name length in path.
   * Allowable value for name length is about 255 characters.
   * Returns true if lengths ara acceptable and false if is's not.
   */
  public boolean isPathWithValidNameLengths() {
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

  /**
   * Checks whether path is extended length.
   * Looking for appropriate prefix.
   * If prefix is found returns true and false if it's not.
   */
  public boolean isExtendedLengthPath() {
    if (path.length() > 5) {
      if (path.substring(0, 4).equals("\\\\?\\")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks whether extended length path is valid.
   * Such path mustn't contain forward slashes;
   * Returns true if contains and false if doesn't.
   */
  public boolean isValidExtendedLengthPath() {
    return !path.contains("/");
  }

  /**
   * Counts specifiers of parent folders.
   * @return quantity of specifiers.
   */
  public int countNesting() {
    int counter = 0;
    for (int i = path.indexOf("..\\"); i < path.length() - 2; i += 3) {
      if (path.substring(i, i + 3).equals("..\\")) {
        counter++;
      }
    }
    return counter;
  }

  /**
   * Replaces all forward slashes to backslashes.
   */
  public void replaceAllFrontSlashes() {
    StringBuffer buffer = new StringBuffer(path);
    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == '/') {
        buffer.replace(i, i + 1, "\\");
      }
    }
    path = buffer.toString();
  }

  /**
   * Checks whether path contains specifier current folder specifier.
   * Returns true if contains and false if doesn't.
   */
  private boolean containsCurrentFolderSpecifier() {
    replaceAllFrontSlashes();
    return (path.contains(".\\") && path.charAt(path.indexOf(".\\") - 1) != '.');
  }

  /**
   * Checks whether path contains specifier parent folder specifier.
   * Returns true if contains and false if doesn't.
   */
  private boolean containsParentFolderSpecifier() {
    replaceAllFrontSlashes();
    return path.contains("..\\");
  }

  /**
   * Checks whether path contains disk designator.
   * If path is extended-length skips prefix.
   * Return true if contains and false if doesn't.
   * @see Path#isExtendedLengthPath()
   * @see Path#isLatinSymbol(char)
   */
  private boolean containsDiskDesignator() {
    replaceAllFrontSlashes();
    int startIndex;
    if (isExtendedLengthPath()) {
      startIndex = 4;
    } else {
      startIndex = 0;
    }
    return isLatinSymbol(path.charAt(startIndex)) && path.charAt(startIndex + 1) == ':';
  }


  /**
   * Checks whether gotten symbol is latin.
   * @param symbol gotten symbol.
   * Returns true if it's latin symbol and false if it's not.
   */
  private boolean isLatinSymbol(char symbol) {
    if ((symbol > 65 && symbol < 90) || (symbol > 97) && (symbol < 122)) {
      return true;
    }
    return false;
  }

  /**
   * Sets start index for tests.
   * Method helps avoid to determine specifiers and prefixes as illegal characters.
   * If such specifiers are located in unacceptable places method skips them
   *                which will lead to determine this specifiers as illegal characters
   *
   * @return the index from which the tests begins.
   * @see Path#isExtendedLengthPath()
   * @see Path#isValidExtendedLengthPath()
   * @see Path#replaceAllFrontSlashes()
   * @see Path#containsDiskDesignator()
   */
  private int setStartIndex() {
    int startIndex = 0;
    if (isExtendedLengthPath())
    {
      if(isValidExtendedLengthPath()) {
        startIndex = 4;
      } else {
        startIndex = 0;
      }
    } else {
      if (containsCurrentFolderSpecifier()) {
        startIndex += 2;
      } else if (containsParentFolderSpecifier()) {
        startIndex += countNesting() * 3;
      }
    }
    if(containsDiskDesignator()) {
      startIndex += 2;
    }
    return startIndex;
  }
}
