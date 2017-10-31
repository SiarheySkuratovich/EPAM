package by.SiarheySkuratovich;


/*
 * Operates with equilateral triangles.
 */
public class Isosceles {

  /*
   * Checks whether triangle is equilateral.
   * @param sides array of sides of explored.
   * @return true if the triangle is equilateral and false if it is not.
   */
  public boolean checkForIsosceles(double[] sides) throws NullPointerException, IndexOutOfBoundsException {
    try {
      Comparator comparator = new Comparator();
      boolean requirement1 = comparator.compareDouble(sides[0], sides[1]);
      boolean requirement2 = comparator.compareDouble(sides[1], sides[2]);
      boolean requirement3 = comparator.compareDouble(sides[2], sides[0]);
      return (requirement1 || requirement2 || requirement3);
    } catch (NullPointerException e) {
      System.out.println("No one side has been gotten");
      throw e;
    } catch (IndexOutOfBoundsException ex) {
      System.out.println("It's not triangle!");
      throw ex;
    }
  }
}
