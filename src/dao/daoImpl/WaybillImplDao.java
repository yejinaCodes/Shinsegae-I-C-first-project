package dao.daoImpl;

import config.ConnectionFactory;
import dao.WaybillDao;
import dto.WaybillDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WaybillImplDao implements WaybillDao {
    static DeliveryImplDao deliveryImplDao = new DeliveryImplDao();
    static ConnectionFactory factory = new ConnectionFactory().getInstance();
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection con = null;

    @Override
    public void createWaybill(WaybillDto dto){
        con = factory.open();

        String query = "INSERT INTO waybill VALUES(?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,dto.getId());
            pstmt.setInt(2,dto.getDeliveryId());
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String created_at = dateTime.format(formatter);
            pstmt.setString(3,created_at);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        deliveryImplDao.updateDelivery(dto.getDeliveryId(),3);
        System.out.println("운송장이 등록되었습니다.");
    }

    public List<WaybillDto> findByAll(){
        List<WaybillDto> findAll = new ArrayList<>();

        con = factory.open();

        String query = "SELECT * FROM waybill";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()){
                String waybill_number = rs.getString("id");
                int delivery_id = rs.getInt("delivery_id");
                String created_at = rs.getString("created_at");

                WaybillDto dto = new WaybillDto(
                        waybill_number,
                        delivery_id,
                        created_at);
                findAll.add(dto);
            }
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findAll;
    }

    public WaybillDto findById(String id){
        WaybillDto findId = null;

        con = factory.open();

        String query = "SELECT * FROM waybill WHERE id = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()){
                String waybill_number = rs.getString("id");
                int delivery_id = rs.getInt("delivery_id");
                String created_at = rs.getString("created_at");

                findId = new WaybillDto(
                        waybill_number,
                        delivery_id,
                        created_at);
            }
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findId;
    }
}