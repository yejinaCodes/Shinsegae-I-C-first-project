package dao.daoImpl;

import config.ConnectionFactory;
import dao.PurchaseOrderDao;
import dto.PurchaseOrderDto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

  @Override
  public void create(PurchaseOrderDto purchaseOrder) throws IOException, SQLException {
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("INSERT INTO purchaseOrder (purchaseOrderID, productID, quantity, cellID, deliveryDate, status, creationDate) ")
        .append("VALUES(?,?,?,?,?,?,?)")
        .toString();

    try{
      //injection 코드 작성하기
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(purchaseOrder.getPurchaseOrderNo()));
      pstmt.setString(2, String.valueOf(purchaseOrder.getProduct_id()));
      pstmt.setString(3, String.valueOf(purchaseOrder.getProduct_quantity()));
      pstmt.setString(4, String.valueOf(purchaseOrder.getCell_id()));
      pstmt.setString(5, purchaseOrder.getDeliver_date());
      pstmt.setString(6, purchaseOrder.getApproval_status());
      pstmt.setString(7, purchaseOrder.getCreated_at());

      pstmt.executeUpdate();
      pstmt.close();
      connection.close();

    }catch(Exception e){
      System.out.println("DB insert중 에러 발생");
    }
    connection.close();
  }
}