/*
 * Operates with equilateral triangles.
 */
public class Equilateral {

  /*
   * Checks whether triangle is equilateral.
   * @param sides array of sides of explored triangle.
   * @return true if the triangle is Equilateral and false if it is not.
   */
  public boolean checkForEquilateral(double[] sides) throws NullPointerException {
    if(!(sides == null)) {
      return (sides[0] == sides[1] && sides[1] == sides[2]);
    } else {
      throw new NullPointerException("null has been got");
    }
  }
} 
