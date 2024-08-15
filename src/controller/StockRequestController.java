package controller;

import common.Form;
import dto.StockRequestDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import library.Script;
import service.serviceImpl.StockRequestServiceImpl;


public class StockRequestController {
  public static int supplier_id = 1; //나중에 userDto.getID하기
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  Script script = new Script();
  StockRequestServiceImpl stockRequestService = new StockRequestServiceImpl();
  public static boolean q = false;

  public void menu(){
    try {
      while (!q) {
        script.selectMenu();
        String menu = br.readLine();
        //menu 유효성 검사하기 validation check 추가하기
        switch (menu) {
          case "1":
            createStockRequest();
            break;
          case "2":
            script.readStockRequest();
            break;
          case "3":
            script.updateStockRequest();
            break;
          case "4":
            script.cancelStockRequest();
            break;
          case "5":
            q = true;
            break;
        }
      }
      } catch(IOException | SQLException e){
        throw new RuntimeException(e);
      }
  }

  public void createStockRequest() throws IOException, SQLException {
    //handler에서 처리하지 않아도 될 것 같음.
    System.out.print(Form.PRODUCTID.getDescription());
    String productID = br.readLine();
    System.out.print(Form.BOXQUANTITY.getDescription());
    int boxQuantity = Integer.parseInt(br.readLine());
    System.out.print(Form.BOXSIZE.getDescription());
    char boxSize = br.readLine().charAt(0);
    System.out.print(Form.CELLID.getDescription());
    int cellID = Integer.parseInt(br.readLine());
    System.out.print(Form.INCOMINGDATE.getDescription());
    String incomingDate = br.readLine();
    System.out.print(Form.REMARKS.getDescription());
    String remarks = br.readLine();

    StockRequestDto stockRequest = new StockRequestDto(productID, boxQuantity,
        boxSize, incomingDate, cellID, supplier_id, remarks);

    stockRequestService.create(stockRequest);
  }
}
