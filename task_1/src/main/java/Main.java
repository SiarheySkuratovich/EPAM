

/**
 * Validates some object path of the file system in Windows OS.
 */
public class Main {

  /**
   * Entry-point of the program.
   * When user enter a path with folder names containing the spaces it leads to separation of path into args of command line.
   * So that's why we have to join args into one path.
   * @param args separated by spaces path.
   */
  public static void main(String[] args) {
    PathValidator pathValidator = new PathValidator();
    String path = String.join(" ", args);

    if (pathValidator.containsForbiddenCharactersIn(path)) {
      System.out.println("Invalid path! The folder names contains illegal characters!");
      return;
    }

    if (!pathValidator.checkForValidFolderEndings(path)) {
      System.out.println("Invalid path! The folder names mustn't ends with space or dot.");
      return;
    }
    if (pathValidator.containsRepeatingSlashesIn(path)) {
      System.out.println("Invalid path! The folder names mustn't contains slashes.");
      return;
    }

    if (pathValidator.сontainsReservedNamesIn(path)) {
      System.out.println("Invalid path! The folders mustn't called reserved names");
      return;
    }
    if(!pathValidator.areValidNameLengthsIn(path)) {
      System.out.println("Invalid path! Folder name lengths mustn't be more than 255 characters.");
      return;
    }

    System.out.println("Path is valid");
  }
}

