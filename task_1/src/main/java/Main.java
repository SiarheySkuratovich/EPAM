/**
 * Created by siarhey on 09.11.17.
 */
public class Main {
  public static void main(String[] args) {
    FullPathChecker fullPathChecker = new FullPathChecker();
    ReservedCharacters reservedCharacters = new ReservedCharacters();
    PathValidation pathValidation = new PathValidation();
    String fullString = String.join(" ", args);
    if (!pathValidation.checkForValidRelativePaths(fullString)) {
      System.out.println("Invalid relative path!");
      return;
    }
    fullString = pathValidation.deleteSpecifiers(fullString);
    if (!pathValidation.checkIsValidFolderEndings(fullString)) {
      System.out.println("Invalid path! The folder names mustn't ends with space or dot.");
      return;
    }
    if (pathValidation.isContainedRepeatedSlashes(fullString)) {
      System.out.println("Invalid path! The folder names mustn't contains slashes.");
    }
    if (!fullPathChecker.checkForValidDiskDesignator(fullString)) {
      System.out.println("Invalid path! Invalid Disk Designator");
      return;
    } else if (reservedCharacters.containedIn(fullString)) {
      System.out.println("Invalid path! The folder names contains illegal characters!");
      return;
    }
    if (pathValidation.isContainedReservedNames(fullString)) {
      System.out.println("Invalid path! The folders mustn't called reserved names");
      return;
    }
    System.out.println("Path is valid");
  }
}


