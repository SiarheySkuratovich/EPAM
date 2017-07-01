package order.classes;
import java.util.Scanner;

/**
 *This class contains readString() method
 */
public class Read {
    /**
     *The method gets a string from comand line
     *@return order A string from comand line
     */
    public String readString() {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        return order;
    }
}
