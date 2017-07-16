/*
 * Operates with triangles.
 */
public class Triangle {
  
  /*
   * An array of sides values.
   */
  double[] sides;

  /*
   * Creates the Triangle object.
   * @param gottenSides we get from console. 
   */
  Triangle(double[] gottenSides) {
    sides = gottenSides;
  }

  /*
   * Checks whether triangle is equilateral.
   * @return true if the triangle is Equilateral and false if it is not.
   */
  public boolean checkForEquilateral() {
    if(sides[0] == sides[1] && sides[1] == sides[2]) {
      return true;
    } else {
      return false;
    }
  } 

  /*
   * Checks whether triangle is equilateral.
   * @return true if the triangle is equilateral and false if it is not.
   */
  public boolean checkForIsosceles() {
    if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
      return true;
    } else {
      return false;
    }
  }
}
    
