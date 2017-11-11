/**
 * Created by siarhey on 09.11.17.
 */
public class Main {
  public static void main(String[] args) {
    PathValidation pathValidation = new PathValidation();
    String fullString = String.join(" ", args);
    if(pathValidation.containsSpecifierIn(fullString)) {
      if (!pathValidation.isValidRelativePath(fullString)) {
        System.out.println("Invalid relative path!");
        return;
      }
    }
    if (pathValidation.isExtendedLengthPath(fullString)) {
      if (!pathValidation.isValidExtendedLengthPath(fullString))
      {
        System.out.println("Invalid extended-length path!");
        return;
      }
      fullString = pathValidation.deletePrefix(fullString);
    }
    if (pathValidation.containsDiskDesignator(fullString)) {
      fullString = pathValidation.deleteDiskDesignator(fullString);
    }
    fullString = pathValidation.deleteSpecifiers(fullString);
    if (!pathValidation.checkForValidFolderEndings(fullString)) {
      System.out.println("Invalid path! The folder names mustn't ends with space or dot.");
      return;
    }
    if (pathValidation.containsRepeatingSlashesIn(fullString)) {
      System.out.println("Invalid path! The folder names mustn't contains slashes.");
      return;
    }
    if (pathValidation.containsReservedCharactersIn(fullString)) {
      System.out.println("Invalid path! The folder names contains illegal characters!");
      return;
    }
    if (pathValidation.сontainsReservedNamesIn(fullString)) {
      System.out.println("Invalid path! The folders mustn't called reserved names");
      return;
    }
    if(!pathValidation.areValidNameLengthsIn(fullString)) {
      System.out.println("Invalid path! Folder name lengths mustn't be more than 255 characters.");
      return;
    }

    System.out.println("Path is valid");
  }
}

