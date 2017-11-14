import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Validates some object path of the file system in Windows OS.
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * Entry-point of the program.
   * When user enter a path with folder names containing the spaces it leads to separation of path into args of command line.
   * So that's why we have to join args into one path.
   * @param args separated by spaces path.
   */
  public static void main(String[] args) {
    try {
      Path path = new Path(String.join(" ", args));
      if (path.containsForbiddenCharacters()) {
        System.out.println("Invalid path!");
        return;
      }
      if (!path.checkForValidFolderEndings()) {
        System.out.println("Invalid path!");
        return;
      }
      if (path.containsRepeatingSlashes()) {
        System.out.println("Invalid path!");
        return;
      }
      if (path.сontainsReservedNames()) {
        System.out.println("Invalid path!");
        return;
      }
      if (!path.isPathWithValidNameLengths()) {
        System.out.println("Invalid path!");
        return;
      }
      System.out.println("Path is valid");
    } catch (Exception e) {
      log.log(Level.SEVERE, "Exception:  ", e);
    }
  }
}

