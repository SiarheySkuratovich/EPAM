
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
    PathValidation pathValidation = new PathValidation();
    String path = String.join(" ", args);
    if(pathValidation.containsSpecifierIn(path)) {
      if (!pathValidation.isValidRelativePath(path)) {
        System.out.println("Invalid relative path!");
        return;
      }
    }
    path = pathValidation.deleteSpecifiers(path);
    if (pathValidation.isExtendedLengthPath(path)) {
      if (!pathValidation.isValidExtendedLengthPath(path))
      {
        System.out.println("Invalid extended-length path!");
        return;
      }
      path = pathValidation.deletePrefix(path);
    }
    if (pathValidation.containsDiskDesignator(path)) {
      path = pathValidation.deleteDiskDesignator(path);
    }
    if (!pathValidation.checkForValidFolderEndings(path)) {
      System.out.println("Invalid path! The folder names mustn't ends with space or dot.");
      return;
    }
    if (pathValidation.containsRepeatingSlashesIn(path)) {
      System.out.println("Invalid path! The folder names mustn't contains slashes.");
      return;
    }
    if (pathValidation.containsReservedCharactersIn(path)) {
      System.out.println("Invalid path! The folder names contains illegal characters!");
      return;
    }
    if (pathValidation.сontainsReservedNamesIn(path)) {
      System.out.println("Invalid path! The folders mustn't called reserved names");
      return;
    }
    if(!pathValidation.areValidNameLengthsIn(path)) {
      System.out.println("Invalid path! Folder name lengths mustn't be more than 255 characters.");
      return;
    }

    System.out.println("Path is valid");
  }
}

