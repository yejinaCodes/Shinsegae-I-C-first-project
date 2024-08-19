//package dao.daoImpl;
//
//import config.ConnectionFactory;
//import dao.StockRequestDao;
//import dto.StockRequestDto;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.stream.Stream;
//
//public class StockRequestDaoImpl implements StockRequestDao {
//  ArrayList<StockRequestDto> stockRequestDb = new ArrayList<StockRequestDto>();
//  private static ResultSet rs = null;
//
//  @Override
//  public void create(StockRequestDto stockRequest) {
//    Connection connection = ConnectionFactory.getInstance().open();
//
//    String query = new StringBuilder()
//        .append("INSERT INTO stockRequest (supplierID, productID, boxQuantity, boxSize, "
//            + "incomingDate, cellID, approvalStatus, remarks, createdAt)")
//        .append("VALUES(?,?,?,?,?,?,?,?,?)")
//        .toString();
//
//    try{
//      PreparedStatement pstmt = connection.prepareStatement(query);
//      pstmt.setString(1, String.valueOf(stockRequest.getSupplier_id()));
//      pstmt.setString(2, stockRequest.getProduct_id());
//      pstmt.setString(3, String.valueOf(stockRequest.getBox_quantity()));
//      pstmt.setString(4, String.valueOf(stockRequest.getBox_size()));
//      pstmt.setString(5, String.valueOf(stockRequest.getIncoming_date()));
//      pstmt.setString(6, String.valueOf(stockRequest.getCell_id()));
//      pstmt.setString(7, stockRequest.getStatus());
//      pstmt.setString(8, stockRequest.getRemarks());
//      pstmt.setString(9, String.valueOf(stockRequest.getCreated_at()));
//
//      pstmt.executeUpdate();
//      pstmt.close();
//      ConnectionFactory.getInstance().close();
//
//    }catch(Exception e){
//      System.out.println("입고 요청서 DB 전송 실패");
//    }
//    ConnectionFactory.getInstance().close();
//  }
//
//  @Override
//  public ArrayList<StockRequestDto> findByAll() throws SQLException {
//    stockRequestDb.clear();
//    Connection connection = ConnectionFactory.getInstance().open();
//
//    String query = new StringBuilder()
//        .append("SELECT * from stockRequest")
//        .toString();
//
//    try{
//      PreparedStatement pstmt = connection.prepareStatement(query);
//      rs = pstmt.executeQuery();
//      while(rs.next()) {
//        StockRequestDto stockRequest = new StockRequestDto();
//        stockRequest.setId(rs.getInt("ID"));
//        stockRequest.setProduct_id(rs.getString("productID"));
//        stockRequest.setBox_quantity(rs.getInt("boxQuantity"));
//        stockRequest.setBox_size(rs.getString("boxSize").charAt(0));
//        stockRequest.setCell_id(rs.getInt("cellID"));
//        stockRequest.setStatus(rs.getString("approvalStatus"));
//        stockRequest.setRemarks(rs.getString("remarks"));
//        stockRequest.setCreated_at(LocalDate.parse(rs.getString("createdAt")));
//        stockRequest.setIncoming_date(LocalDate.parse(rs.getString("incomingDate")));
//
//        stockRequestDb.add(stockRequest);
//      }
//
//      pstmt.close();
//      ConnectionFactory.getInstance().close();
//
//    }catch(Exception e){
//      System.out.println("입고 요청서 DB list 받기 실패");
//    }
//    connection.close();
//    return stockRequestDb;
//  }
//
//  @Override
//  public ArrayList<StockRequestDto> findByStatus(){
//    stockRequestDb.clear();
//    Connection connection = ConnectionFactory.getInstance().open();
//
//    String query = new StringBuilder()
//        .append("SELECT * from stockRequest ")
//        .append("WHERE approvalStatus like 'PENDING' ")
//        .append("ORDER BY createdAt asc")
//        .toString();
//
//    try{
//      PreparedStatement pstmt = connection.prepareStatement(query);
//      rs = pstmt.executeQuery();
//      while(rs.next()) {
//        StockRequestDto stockRequest = new StockRequestDto();
//        stockRequest.setId(rs.getInt("ID"));
//        stockRequest.setProduct_id(rs.getString("productID"));
//        stockRequest.setBox_quantity(rs.getInt("boxQuantity"));
//        stockRequest.setBox_size(rs.getString("boxSize").charAt(0));
//        stockRequest.setCell_id(rs.getInt("cellID"));
//        stockRequest.setStatus(rs.getString("approvalStatus"));
//        stockRequest.setRemarks(rs.getString("remarks"));
//        stockRequest.setCreated_at(LocalDate.parse(rs.getString("createdAt")));
//        stockRequest.setIncoming_date(LocalDate.parse(rs.getString("incomingDate")));
//
//        stockRequestDb.add(stockRequest);
//      }
//      pstmt.close();
//      ConnectionFactory.getInstance().close();
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//    return stockRequestDb;
//  };
//
//  @Override
//  public boolean updateStatus(ArrayList<Integer> updateList){
//    stockRequestDb.clear();
//    boolean result = false;
//    Connection connection = ConnectionFactory.getInstance().open();
//
//    String query = new StringBuilder()
//        .append("UPDATE stockRequest ")
//        .append("SET approvalStatus = 'APPROVED' ")
//        .append("WHERE approvalStatus = 'PENDING' and ID = ?")
//        .toString();
//
//    try{
//      PreparedStatement pstmt = connection.prepareStatement(query);
//      //procedure사용하기
//      Stream<Integer> strm = updateList.stream();
//      strm.forEach(id -> {
//          try{
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//          } catch (SQLException e) {
//            throw new RuntimeException(e);
//          }
//          }
//          );
//      result = true;
//      pstmt.close();
//      ConnectionFactory.getInstance().close();
//
//    } catch (SQLException ex) {
//      throw new RuntimeException(ex);
//    }
//    return result;
//  };
//
//
//
//}