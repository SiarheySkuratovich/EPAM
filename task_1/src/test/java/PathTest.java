import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {
  @Test
  public void checkWhetherFalseIfDotIsLocatedAtTheAndOfDolderName() throws Exception {
    Path path = new Path("asdf./asd");
    assertEquals(false, path.checkForValidFolderEndings());
  }

  @Test
  public void checkWhetherFalseIfSpaceIsLocatedAtTheAndOfDolderName() throws Exception {
    Path path = new Path("asdf /asd");
    assertEquals(false, path.checkForValidFolderEndings());
  }

  @Test
  public void checkWhetherTrueIfNameOfFoldersAreValid() throws Exception {
    Path path = new Path("asdf/cvb");
    assertEquals(true, path.checkForValidFolderEndings());
  }

  @Test
  public void checkIfFalseWithExtendedLengthAndRelativePathSpecifier() throws Exception {
    Path path = new Path("\\\\?\\D:..\\sdgfdfg\\sdf\\");
    assertEquals(false, path.checkForValidFolderEndings());
  }

  @Test
  public void сontainsReservedNamesIn() throws Exception {
    Path path = new Path("asdafs/CON/fs");
    assertEquals(true, path.сontainsReservedNames());
  }

  @Test
  public void checkIfPathDoesntContainsReservedNames() throws Exception {
    Path path = new Path("asdafs/sadgh/fs");
    assertEquals(false, path.сontainsReservedNames());
  }

  @Test
  public void containsRepeatingSlashesIn() throws Exception {
    Path path = new Path("asdafs//sadgh/fs");
   assertEquals(true, path.containsRepeatingSlashes());
  }

  @Test
  public void containsForbiddenCharactersIn() throws Exception {
    Path path = new Path("asdafs/s?adgh/fs");
    assertEquals(true, path.containsForbiddenCharacters());
  }

  @Test
  public void checkIfFalseWithSpecifiers() {
    Path path = new Path("\\\\?\\D:\\asdafs\\sadgh\\fs");
    assertEquals(false, path.containsForbiddenCharacters());
  }

  @Test
  public void checkIfTrueWithExtendedLengthSpecifierAndFrontSlashes() throws Exception {
    Path path = new Path("\\\\?\\D:\\asdafs/sadgh/fs");
    assertEquals(true, path.containsForbiddenCharacters());
  }

  @Test
  public void areValidNameLengthsIn() throws Exception {
    String invalidName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    Path path = new Path("asdafs/" + invalidName + "/fs");
    assertEquals(false, path.isPathWithValidNameLengths());
  }

  @Test
  public void isExtendedLengthPath() throws Exception {
    Path path = new Path("\\\\?\\afs\\sadgh\\fs");
    assertEquals(true, path.isExtendedLengthPath());
  }

  @Test
  public void isValidExtendedLengthPath() throws Exception {
    Path path = new Path("\\\\?\\afs/sadgh/fs");
    assertEquals(false, path.isValidExtendedLengthPath());
  }

  @Test
  public void countNesting() throws Exception {
    Path path = new Path("..\\..\\..\\fs/sadgh/fs");
    assertEquals(3, path.countNesting());
  }
}