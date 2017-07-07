/*
 * Cheks on the type of triangle.
 */
public class Triangle {
  
  /*
   * An array of sides values.
   */
  double[] sides;

  /*
   * Creates the Triangle object using (@link SideReading#readSide(double[]).
   */
  Triangle() {
    sides = new double[3];
    SideReading getting = new SideReading();
    getting.readSide(sides);
  }

  /*
   * Cheks on the type of triangle.
   */
  public void check() {
    if(sides[0] == sides[1] && sides[1] == sides[2]) {
      System.out.println("Triangle is equilateral");
    } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
      System.out.println("Triangle is isosceles");
    } else {
      System.out.println("Triangle is usual");
    }
  }
}
    
