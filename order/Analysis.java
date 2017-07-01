public class Analysis {
  public void analyze (String[] orderParts) {
    for (int i = 0; i < orderParts.length - 1; i++) {
      if (Integer.parseInt(orderParts[i + 1]) > Integer.parseInt(orderParts[i])) {
        System.out.println("the order is NOT decreasing");
        System.exit(0);
      }
    }
  }
}
