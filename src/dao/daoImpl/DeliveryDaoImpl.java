package dao.daoImpl;

import common.DeliveryStatus;
import config.ConnectionFactory;
import dao.DeliveryDao;
import dto.DeliveryDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao {
    static ConnectionFactory factory;
    static ResultSet rs;
    static PreparedStatement pstmt;
    static Connection con;
    static Deque<Integer> waitDeliveryMan;

    public DeliveryDaoImpl() {
    }

    public void createDelivery(DeliveryDto dto) {
        ReleaseDaoImpl releaseDaoImpl = new ReleaseDaoImpl();
        boolean decide = this.existenceByRelease(dto.getRelease_id());
        if (decide) {
            waitDeliveryMan = this.waitDeliveryMan();
            if (waitDeliveryMan.isEmpty()) {
                System.out.println("배송 가능한 기사가 없습니다.");
            } else {
                Integer deliveryManId = (Integer)waitDeliveryMan.getFirst();
                if (deliveryManId != null) {
                    con = factory.open();
                    String query = "INSERT INTO delivery (id, admin_id, created_at, end_date, Release_id, remarks, start_date , status, updated_at, user_id, warehouse_id) VALUES(NULL,?,?,?,?,?,?,?,NULL,?,?)";

                    try {
                        pstmt = con.prepareStatement(query);
                        pstmt.setInt(1, (Integer)waitDeliveryMan.pollFirst());
                        LocalDateTime dateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        String created_at = dateTime.format(formatter);
                        pstmt.setString(2, created_at);
                        dateTime = dateTime.plusDays(2L);
                        DateTimeFormatter end = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        String end_date = dateTime.format(end);
                        pstmt.setString(3, end_date);
                        pstmt.setInt(4, dto.getRelease_id());
                        pstmt.setString(5, dto.getRemarks());
                        dateTime = dateTime.minusDays(1L);
                        DateTimeFormatter start = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        String start_date = dateTime.format(start);
                        pstmt.setString(6, start_date);
                        pstmt.setString(7, DeliveryStatus.WAIT.toString());
                        pstmt.setInt(8, releaseDaoImpl.findById(dto.getRelease_id()).getUser_id());
                        pstmt.setInt(9, 1);
                        pstmt.executeUpdate();
                        pstmt.close();
                        con.close();
                        factory.close();
                    } catch (NullPointerException | SQLException var13) {
                        var13.printStackTrace();
                    }

                    System.out.println("배차가 등록되었습니다.");
                } else {
                    System.out.println("배송 가능한 기사가 없습니다.");
                }
            }
        } else {
            System.out.println("배차 등록이 불가능한 아이디입니다.");
        }

    }

    public void updateDelivery(int id, int select) {
        String query = "";
        con = factory.open();
        switch (select) {
            case 1:
                query = "UPDATE delivery SET status = 'OUT', updated_at = NOW() WHERE id = ?";
                break;
            case 2:
                query = "UPDATE delivery SET status = 'CANCEL', updated_at = NOW() WHERE id = ?";
                break;
            case 3:
                query = "UPDATE delivery SET status = 'CLEAR', updated_at = NOW() WHERE id = ?";
        }

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

    }

    public List<Integer> deliveryManAll() {
        List<Integer> deliveryManAll = new ArrayList();
        con = factory.open();
        String query = "SELECT id FROM admin WHERE department = 'DELIVERY'";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                deliveryManAll.add(id);
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return deliveryManAll;
    }

    public List<DeliveryDto> findByAll() {
        List<DeliveryDto> findAll = new ArrayList();
        con = factory.open();
        String query = "SELECT * FROM delivery";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                int release_id = rs.getInt("release_id");
                int admin_id = rs.getInt("admin_id");
                int user_id = rs.getInt("user_id");
                int warehouse_id = rs.getInt("warehouse_id");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                String start_date = rs.getString("start_date");
                String end_date = rs.getString("end_date");
                String remarks = rs.getString("remarks");
                String status = rs.getString("status");
                DeliveryDto dto = new DeliveryDto(id, release_id, admin_id, warehouse_id, user_id, created_at, updated_at, start_date, end_date, remarks, DeliveryStatus.valueOf(status));
                findAll.add(dto);
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var15) {
            var15.printStackTrace();
        }

        return findAll;
    }

    public DeliveryDto findByID(int delivery_id) {
        DeliveryDto findId = null;
        con = factory.open();
        String query = "SELECT * FROM delivery WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, delivery_id);

            int id;
            int release_id;
            int admin_id;
            int user_id;
            int warehouse_id;
            String created_at;
            String updated_at;
            String start_date;
            String end_date;
            String remarks;
            String status;
            for(rs = pstmt.executeQuery(); rs.next(); findId = new DeliveryDto(id, release_id, admin_id, warehouse_id, user_id, created_at, updated_at, start_date, end_date, remarks, DeliveryStatus.valueOf(status))) {
                id = rs.getInt("id");
                release_id = rs.getInt("release_id");
                admin_id = rs.getInt("admin_id");
                user_id = rs.getInt("user_id");
                warehouse_id = rs.getInt("warehouse_id");
                created_at = rs.getString("created_at");
                updated_at = rs.getString("updated_at");
                start_date = rs.getString("start_date");
                end_date = rs.getString("end_date");
                remarks = rs.getString("remarks");
                status = rs.getString("status");
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var15) {
            var15.printStackTrace();
        }

        return findId;
    }

    public Deque<Integer> waitDeliveryMan() {
        List<DeliveryDto> deliveryAll = this.findByAll();
        List<Integer> deliveryManAll = this.deliveryManAll();
        waitDeliveryMan = new LinkedList(deliveryManAll);
        if (!deliveryAll.isEmpty()) {
            Iterator var3 = deliveryAll.iterator();

            while(var3.hasNext()) {
                DeliveryDto deliveryDto = (DeliveryDto)var3.next();
                if (deliveryDto.getDeliveryStatus().toString().equals("CLEAR")) {
                    if (waitDeliveryMan.size() <= deliveryAll.size()) {
                        waitDeliveryMan.add(deliveryDto.getAdmin_id());
                    }
                } else if (!deliveryDto.getDeliveryStatus().toString().equals("CANCEL")) {
                    waitDeliveryMan.remove(deliveryDto.getAdmin_id());
                }
            }
        }

        return waitDeliveryMan;
    }

    public boolean existenceByRelease(int id) {
        boolean result = false;
        con = factory.open();
        String query = "SELECT status FROM releases WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            result = rs.next();

            while(rs.next()) {
                String status = rs.getString("status");
                if (status.equals("APPROVAL")) {
                    result = true;
                }
            }

            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return result;
    }

    static {
        new ConnectionFactory();
        factory = ConnectionFactory.getInstance();
        rs = null;
        pstmt = null;
        con = null;
        waitDeliveryMan = new LinkedList();
    }
}
