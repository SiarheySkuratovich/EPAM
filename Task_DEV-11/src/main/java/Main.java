import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Translator translator = new Translator();
      Scanner in = new Scanner(System.in);
      System.out.println("enter a sentence:");
      String string = in.nextLine();
      System.out.println("enter ru-eng or eng-ru for translate");
      String language = in.next();
      if (language.equals("ru-eng")) {
        System.out.println(translator.translateToLatin(string));
      } else {
        System.out.println(translator.translateToCyrillic(string));
      }
    } catch (Exception e) {};
  }
}
