/*
 * Operates with equilateral triangles.
 */
public class Isosceles {
  
  /*
   * Checks whether triangle is equilateral.
   * @param sides array of sides of explored.
   * @return true if the triangle is equilateral and false if it is not.
   */
  public boolean checkForIsosceles(double[] sides) {
    return (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]);
  }
}
