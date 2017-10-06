import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
   // String string = in.nextLine();
    Translator translator = new Translator();
    System.out.println(translator.translateToCyrillic("Privyet Vsyem myenya zovut Syergyey, ya otlichnyy paryen i vsyo takoye bla bla bla, ya ochyen ustal programmirovat"));

  }
}
