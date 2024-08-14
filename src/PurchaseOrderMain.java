import controller.PurchaseOrderController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PurchaseOrderMain {
  //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {

    try{
      PurchaseOrderController poc = new PurchaseOrderController();
      poc.insert_order();

    }catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}
