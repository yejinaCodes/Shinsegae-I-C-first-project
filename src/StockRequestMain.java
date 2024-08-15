import controller.StockRequestController;

public class StockRequestMain {

  public static void main(String[] args) {
    try {
      StockRequestController poc = new StockRequestController();
      poc.menu();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
