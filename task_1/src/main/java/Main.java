import java.util.Arrays;

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
    if (pathValidation.isDiskDesignator(fullString)) {
      fullString = fullString.substring(2, fullString.length());
    }
    fullString = pathValidation.deleteSpecifiers(fullString);
    if (!pathValidation.checkForValidFolderEndings(fullString)) {
      System.out.println("Invalid path! The folder names mustn't ends with space or dot.");
      return;
    }
    if (pathValidation.containsRepeatingSlashesIn(fullString)) {
      System.out.println("Invalid path! The folder names mustn't contains slashes.");
    }

    System.out.println(fullString);

    if (pathValidation.containsReservedCharactersIn(fullString)) {
      System.out.println("Invalid path! The folder names contains illegal characters!");
      return;
    }
    if (pathValidation.сontainsReservedNamesIn(fullString)) {
      System.out.println("Invalid path! The folders mustn't called reserved names");
      return;
    }
    System.out.println("Path is valid");
  }
}

