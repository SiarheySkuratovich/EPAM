import java.lang.NullPointerException;

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
   * If param is null, the equals() method cause NullPointerException.
   * @param gottenSides is used for class field assigning.
   */
  Triangle(double[] gottenSides) {
    if (!(gottenSides.equals(sides))) {
      sides = gottenSides;
    }
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
    return (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]);
  }
}
    
