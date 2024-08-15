package dao.daoImpl;

import config.ConnectionFactory;
import dao.StockRequestDao;
import dto.StockRequestDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockRequestDaoImpl implements StockRequestDao {

  @Override
  public void create(StockRequestDto stockRequest) throws SQLException {
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("INSERT INTO stockRequest (supplierID, productID, boxQuantity, boxSize, "
            + "incomingDate, cellID, approvalStatus, remarks, createdAt)")
        .append("VALUES(?,?,?,?,?,?,?,?,?)")
        .toString();

    try{
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(stockRequest.getSupplier_id()));
      pstmt.setString(2, stockRequest.getProduct_id());
      pstmt.setString(3, String.valueOf(stockRequest.getBox_quantity()));
      pstmt.setString(4, String.valueOf(stockRequest.getBox_size()));
      pstmt.setString(5, String.valueOf(stockRequest.getIncoming_date()));
      pstmt.setString(6, String.valueOf(stockRequest.getCell_id()));
      pstmt.setString(7, stockRequest.getStatus());
      pstmt.setString(8, stockRequest.getRemarks());
      pstmt.setString(9, String.valueOf(stockRequest.getCreated_at()));

      pstmt.executeUpdate();
      pstmt.close();
      connection.close();

    }catch(Exception e){
      System.out.println("입고 요청서 DB 전송 실패");
    }
    connection.close();
  }


}