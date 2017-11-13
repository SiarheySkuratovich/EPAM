import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siarhey on 12.11.17.
 */
public class PathTest {
  @Test
  public void checkWhetherFalseIfDotIsLocatedAtTheAndOfDolderName() throws Exception {
    Path path = new Path("asdf./asd");
    boolean actual = path.checkForValidFolderEndings();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void checkWhetherFalseIfSpaceIsLocatedAtTheAndOfDolderName() throws Exception {
    Path path = new Path("asdf /asd");
    boolean actual = path.checkForValidFolderEndings();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void checkWhetherTrueIfNameOfFoldersAreValid() throws Exception {
    Path path = new Path("asdf/cvb");
    boolean actual = path.checkForValidFolderEndings();
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void checkIfFalseWithExtendedLengthAndRelativePathSpecifier() throws Exception {
    Path path = new Path("\\\\?\\D:..\\sdgfdfg\\sdf\\");
    boolean actual = path.checkForValidFolderEndings();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void сontainsReservedNamesIn() throws Exception {
    Path path = new Path("asdafs/CON/fs");
    boolean actual = path.сontainsReservedNames();
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void checkIfPathDoesntContainsReservedNames() throws Exception {
    Path path = new Path("asdafs/sadgh/fs");
    boolean actual = path.сontainsReservedNames();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void containsRepeatingSlashesIn() throws Exception {
    Path path = new Path("asdafs//sadgh/fs");
    boolean actual = path.containsRepeatingSlashes();
    boolean expected = true;
   assertEquals(expected, actual);
  }

  @Test
  public void containsForbiddenCharactersIn() throws Exception {
    Path path = new Path("asdafs/s?adgh/fs");
    boolean actual = path.containsForbiddenCharacters();
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void checkIfFalseWithSpecifiers() {
    Path path = new Path("\\\\?\\D:\\asdafs\\sadgh\\fs");
    boolean actual = path.containsForbiddenCharacters();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void checkIfTrueWithExtendedLengthSpecifierAndFrontSlashes() throws Exception {
    Path path = new Path("\\\\?\\D:\\asdafs/sadgh/fs");
    boolean actual = path.containsForbiddenCharacters();
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void areValidNameLengthsIn() throws Exception {
    char[] invalidName = new char[257];
    for (int i = 0; i < 257; i++) {
      invalidName[i] = 'a';
    }
    String stringInvalidName = String.valueOf(invalidName);
    Path path = new Path("asdafs/" + stringInvalidName + "/fs");
    boolean actual = path.isPathWithValidNameLengths();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void isExtendedLengthPath() throws Exception {
    Path path = new Path("\\\\?\\afs\\sadgh\\fs");
    boolean actual = path.isExtendedLengthPath();
    boolean expected = true;
    assertEquals(expected, actual);
  }

  @Test
  public void isValidExtendedLengthPath() throws Exception {
    Path path = new Path("\\\\?\\afs/sadgh/fs");
    boolean actual = path.isValidExtendedLengthPath();
    boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void countNesting() throws Exception {
    Path path = new Path("..\\..\\..\\fs/sadgh/fs");
    int actual = path.countNesting();
    int expected = 3;
    assertEquals(expected, actual);
  }

}