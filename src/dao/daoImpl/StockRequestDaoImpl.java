package dao.daoImpl;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import common.ErrorCode;
import config.ConnectionFactory;
import dao.StockRequestDao;
import dto.StockRequestDto;
import exception.Exception;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StockRequestDaoImpl implements StockRequestDao {

  ArrayList<StockRequestDto> stockRequestDb = new ArrayList<StockRequestDto>();
  private static ResultSet rs = null;


  @Override
  public void create(StockRequestDto stockRequest) {
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("INSERT INTO StockRequest (supplier_id, product_id, box_quantity, box_size, "
            + "incoming_date, cell_id, approval_status, remarks, created_at)")
        .append("VALUES(?,?,?,?,?,?,?,?,?)")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(stockRequest.getSupplierId()));
      pstmt.setString(2, stockRequest.getProductId());
      pstmt.setString(3, String.valueOf(stockRequest.getBoxQuantity()));
      pstmt.setString(4, String.valueOf(stockRequest.getBoxSize()));
      pstmt.setString(5, String.valueOf(stockRequest.getIncomingDate()));
      pstmt.setString(6, String.valueOf(stockRequest.getCellId()));
      pstmt.setString(7, stockRequest.getStatus());
      pstmt.setString(8, stockRequest.getRemarks());
      pstmt.setString(9, String.valueOf(stockRequest.getCreatedAt()));

      pstmt.executeUpdate();
      pstmt.close();
      ConnectionFactory.getInstance().close();
      System.out.println("\n**요청서 입력 완료**");

    } catch (Exception | SQLException e) {
      System.err.println("입고 요청서 DB 전송 실패");
    }
    ConnectionFactory.getInstance().close();
  }

  @Override
  public ArrayList<StockRequestDto> findByAll() throws SQLException {
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();
        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approva_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
        stockRequest = null;
      }

      pstmt.close();
      ConnectionFactory.getInstance().close();

    } catch (Exception e) {
      System.err.println("입고 요청서 DB list 받기 실패");
    }
    ConnectionFactory.getInstance().close();
    return stockRequestDb;
  }

  @Override
  public ArrayList<StockRequestDto> findById(int requestId){
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest ")
        .append("WHERE id = ?")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setInt(1, requestId);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approval_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();
    }catch (Exception | SQLException e) {
      System.err.println("DB 입고요청서 불러오기 실패");
      System.err.println(ErrorCode.NOREQUESTAVAILABLE.getMessage());

    }
    return stockRequestDb;
  }

  @Override
  public ArrayList<StockRequestDto> findByProductId(String productId){
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest ")
        .append("WHERE product_id = ?")
        .toString();
    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, productId);

      rs = pstmt.executeQuery();
      while(rs.next()){
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approval_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();

    }catch (Exception | SQLException e) {
      System.err.println("DB 입고요청서 불러오기 실패");
    }
    return stockRequestDb;
  }

  @Override
  public ArrayList<StockRequestDto> findByCreatedDate(String createdDate){
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest ")
        .append("WHERE created_at = ?")
        .toString();
    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, createdDate);
      rs = pstmt.executeQuery();

      while(rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approval_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();
    }catch (Exception | SQLException e) {
      System.err.println("DB 입고요청서 불러오기 실패");
    }
    return stockRequestDb;

  }

  @Override
  public ArrayList<StockRequestDto> findByIncomingDate(String incomingDate){
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest ")
        .append("WHERE incoming_date = ?")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      Date sqlDate = Date.valueOf(LocalDate.parse(incomingDate, formatter));
      pstmt.setDate(1, sqlDate);
      rs = pstmt.executeQuery();

      while(rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approval_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();
    }catch (Exception | SQLException e) {
      System.err.println("DB 입고요청서 불러오기 실패");
      System.err.println(ErrorCode.NOREQUESTAVAILABLE.getMessage());
    }
    return stockRequestDb;
  }

  @Override
  public ArrayList<StockRequestDto> findByStatus(int status) {
    stockRequestDb.clear();
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("SELECT * from StockRequest ")
        .append("WHERE approval_status like ? ")
        .append("ORDER BY created_at asc")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, status == 1 ? "PENDING" : "APPROVED");
      rs = pstmt.executeQuery();
      while (rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setProductId(rs.getString("product_id"));
        stockRequest.setBoxQuantity(rs.getInt("box_quantity"));
        stockRequest.setBoxSize(rs.getString("box_size").charAt(0));
        stockRequest.setCellId(rs.getInt("cell_id"));
        stockRequest.setStatus(rs.getString("approval_status"));
        stockRequest.setRemarks(rs.getString("remarks"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        stockRequest.setIncomingDate(LocalDate.parse(rs.getString("incoming_date")));

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return stockRequestDb;
  }

  @Override
  public boolean updateStatus(ArrayList<Integer> updateList) {
    stockRequestDb.clear();
    boolean result = false;
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("UPDATE StockRequest ")
        .append("SET approval_status = 'APPROVED' ")
        .append("WHERE approval_status = 'PENDING' and id = ?")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      //procedure사용하기
      Stream<Integer> strm = updateList.stream();
      strm.forEach(id -> {
            try {
              pstmt.setInt(1, id);
              pstmt.executeUpdate();
            } catch (SQLException e) {
              throw new RuntimeException(e);
            }
          }
      );
      result = true;
      pstmt.close();
      ConnectionFactory.getInstance().close();

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return result;
  }

  @Override
  public boolean updateForm(int formID, StockRequestDto updateForm) throws SQLException {
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("UPDATE StockRequest ")
        .append("SET product_id = ?, box_quantity = ?, box_size = ?, "
            + "incoming_date = ?, cell_id = ?, remarks = ? ")
        .append("WHERE id = ?")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(updateForm.getProductId()));
      pstmt.setString(2, String.valueOf(updateForm.getBoxQuantity()));
      pstmt.setString(3, String.valueOf(updateForm.getBoxSize()));
      pstmt.setDate(4, Date.valueOf(updateForm.getIncomingDate()));
      pstmt.setString(5, String.valueOf(updateForm.getCellId()));
      pstmt.setString(6, String.valueOf(updateForm.getRemarks()));
      pstmt.setString(7, String.valueOf(formID));

      pstmt.executeUpdate();
      System.out.println("\n**수정 완료**");
      pstmt.close();
      ConnectionFactory.getInstance().close();
    } catch (RuntimeException e) {
      System.err.println(e.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public void delete(int formID) {
    Connection connection = ConnectionFactory.getInstance().open();

    String query = new StringBuilder()
        .append("DELETE FROM StockRequest ")
        .append("WHERE id = ?")
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, String.valueOf(formID));
      int rowsAffected = pstmt.executeUpdate();

      pstmt.close();
      ConnectionFactory.getInstance().close();
      if (rowsAffected == 0) {
        System.err.println(ErrorCode.NOREQUESTAVAILABLE.getMessage());
      } else {
        System.out.println("**취소 완료**");
      }
    } catch (SQLException e) {
      if ("02000".equals(e.getSQLState())) {
        System.err.println("해당 요청서는 DB에 존재하지 않습니다.");
      } else {
        e.printStackTrace();
      }
    }
  }

  @Override
  public ArrayList<StockRequestDto> printInstr(){
    Connection connection = ConnectionFactory.getInstance().open();
    stockRequestDb.clear();
    String query = new StringBuilder()
        .append("SELECT * FROM ReceivingInstructions") //CellID도 가지고 와야 함.
        .toString();

    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        StockRequestDto stockRequest = new StockRequestDto();

        stockRequest.setId(rs.getInt("id"));
        stockRequest.setStockRequestId(Optional.ofNullable(rs.getInt("stock_request_id")));
        stockRequest.setBoxQuantity(rs.getInt("box_unit"));
        stockRequest.setCreatedAt(LocalDate.parse(rs.getString("created_at")));
        //stockRequest.setCell_id(rs.getInt("cellID"));
        stockRequest.setLoadingInstr(Optional.ofNullable(rs.getString("loading_instrc")));
        stockRequest.setRemarks(rs.getString("remarks"));;

        stockRequestDb.add(stockRequest);
      }
      pstmt.close();
      ConnectionFactory.getInstance().close();

    } catch (Exception e) {
      System.out.println("입고지시서 DB list 받기 실패");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionFactory.getInstance().close();
    return stockRequestDb;
  }
}