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
        .append("INSERT INTO PurchaseOrder (purchase_order_id, product_id, quantity, cell_id, delivery_date, status, creation_date) ")
        .append("VALUES(?,?,?,?,?,?,?)")
        .toString();

    try{
      //injection 코드 작성하기
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(purchaseOrder.getPurchaseOrderNo()));
      pstmt.setString(2, String.valueOf(purchaseOrder.getProductId()));
      pstmt.setString(3, String.valueOf(purchaseOrder.getProductQuantity()));
      pstmt.setString(4, String.valueOf(purchaseOrder.getCellId()));
      pstmt.setString(5, purchaseOrder.getDeliverDate());
      pstmt.setString(6, purchaseOrder.getApprovalStatus());
      pstmt.setString(7, purchaseOrder.getCreatedAt());

      pstmt.executeUpdate();
      pstmt.close();
      connection.close();

    }catch(Exception e){
      System.out.println("DB insert중 에러 발생");
    }
    connection.close();
  }
}