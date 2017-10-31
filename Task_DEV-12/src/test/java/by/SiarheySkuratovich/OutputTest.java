package by.SiarheySkuratovich;
import org.junit.Before;

import java.io.*;

public abstract class OutputTest {

  protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(output));
  }
}