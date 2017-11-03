import java.util.Scanner;

/**
 * Created by siarhey on 03.11.17.
 */
public class Path {
  public static void main(String[] args) {
    System.out.println(args[0]);
    char[] array = args[0].toCharArray();
    if (array[0] != '/') {
      System.out.println("invalid path!");
      return;
    }
    for (int i = 1; i < array.length - 1; i++) {
      if (array[i] != '\\') {
        switch (array[i + 1]) {
          case '@':
          case '#':
          case '$':
          case '&':
          case '~':
          case '%':
          case '*':
          case '(':
          case ')':
          case '[':
          case ']':
          case '{':
          case '}':
          case '\'':
          case '"':
          case '\\':
          case ':':
          case ';':
          case '>':
          case '<':
          case '`':
            System.out.println("invalid path!");
            return;
          default:
            break;
        }
      }
    }
    System.out.println("path is valid.");
  }
}
