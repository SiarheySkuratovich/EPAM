import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 10.11.17.
 */
public class PathValidationTest {
  @org.junit.Test
  public void checkForValidFolderEndings() throws Exception {
  }

  @org.junit.Test
  public void сontainsReservedNamesIn() throws Exception {
  }

  @org.junit.Test
  public void containsRepeatingSlashesIn() throws Exception {
  }

  @org.junit.Test
  public void isValidRelativePath() throws Exception {
  }

  @org.junit.Test
  public void containsSpecifierIn() throws Exception {
  }

  @org.junit.Test
  public void deleteSpecifiers() throws Exception {
  }

  @org.junit.Test
  public void containsReservedCharactersIn() throws Exception {
  }

  @org.junit.Test
  public void isDiskDesignator() throws Exception {
  }
  @Test
  public void isLatinSymbol() throws Exception{
    PathValidation pathValidation = new PathValidation();
    boolean actual = pathValidation.isLatinSymbol('#');
    boolean expected = false;
    assertEquals(expected, actual);
  }

}