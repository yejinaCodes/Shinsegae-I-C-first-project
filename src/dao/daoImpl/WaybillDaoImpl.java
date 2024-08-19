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

public class WaybillDaoImpl implements WaybillDao {
    static DeliveryDaoImpl deliveryDaoImpl = new DeliveryDaoImpl();
    static ConnectionFactory factory;
    static ResultSet rs;
    static PreparedStatement pstmt;
    static Connection con;

    public WaybillDaoImpl() {
    }

    public void createWaybill(WaybillDto dto) {
        con = factory.open();
        String query = "INSERT INTO waybill VALUES(NULL,?,?,?,?,NULL)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dto.getWaybill_number());
            pstmt.setInt(2, dto.getDelivery_id());
            pstmt.setInt(3, deliveryDaoImpl.findByID(dto.getDelivery_id()).getRelease_id());
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String created_at = dateTime.format(formatter);
            pstmt.setString(4, created_at);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            factory.close();
        } catch (NullPointerException | SQLException var6) {
            var6.printStackTrace();
        }

        deliveryDaoImpl.updateDelivery(dto.getDelivery_id(), 3);
        System.out.println("운송장이 등록되었습니다.");
    }

    public List<WaybillDto> findByAll() {
        List<WaybillDto> findAll = new ArrayList();
        con = factory.open();
        String query = "SELECT * FROM waybill";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String waybill_number = rs.getString("waybill_number");
                int delivery_id = rs.getInt("delivery_id");
                int release_id = rs.getInt("release_id");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                WaybillDto dto = new WaybillDto(id, waybill_number, delivery_id, release_id, created_at, updated_at);
                findAll.add(dto);
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return findAll;
    }

    public WaybillDto findById(int id) {
        WaybillDto findId = null;
        con = factory.open();
        String query = "SELECT * FROM waybill WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            int waybill_id;
            String waybill_number;
            int delivery_id;
            int release_id;
            String created_at;
            String updated_at;
            for(rs = pstmt.executeQuery(); rs.next(); findId = new WaybillDto(waybill_id, waybill_number, release_id, delivery_id, created_at, updated_at)) {
                waybill_id = rs.getInt("id");
                waybill_number = rs.getString("waybill_number");
                delivery_id = rs.getInt("delivery_id");
                release_id = rs.getInt("release_id");
                created_at = rs.getString("created_at");
                updated_at = rs.getString("updated_at");
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return findId;
    }

    static {
        new ConnectionFactory();
        factory = ConnectionFactory.getInstance();
        rs = null;
        pstmt = null;
        con = null;
    }
}
