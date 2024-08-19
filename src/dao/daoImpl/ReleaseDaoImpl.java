package dao.daoImpl;

import common.ReleaseStatus;
import config.ConnectionFactory;
import dao.ReleaseDao;
import dto.DeliveryDto;
import dto.ReleaseDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReleaseDaoImpl implements ReleaseDao {
    static ConnectionFactory factory;
    static ResultSet rs;
    static PreparedStatement pstmt;
    static Connection con;

    public ReleaseDaoImpl() {
    }

    public void createRelease(ReleaseDto releaseDto) {
        if (!this.productCheck(releaseDto.getProduct_id())) {
            System.out.println("주문코드 잘못 입력 또는 해당 상품이 창고에 존재하지 않습니다.");
        } else {
            con = factory.open();
            String query = "INSERT INTO releases (id, user_id, product_id, customer_name, customer_address, amount, status, remarks, request_date) VALUES(NULL,?,?,?,?,?,?,?,?)";

            try {
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, 1);
                pstmt.setString(2, releaseDto.getProduct_id());
                pstmt.setString(3, releaseDto.getCustomer_name());
                pstmt.setString(4, releaseDto.getCustomer_address());
                pstmt.setInt(5, releaseDto.getAmount());
                pstmt.setString(6, releaseDto.getReleaseStatus().name());
                pstmt.setString(7, releaseDto.getRemarks());
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String request_date = dateTime.format(formatter);
                pstmt.setString(8, request_date);
                pstmt.executeUpdate();
                pstmt.close();
                con.close();
                factory.close();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }

            System.out.println("요청 완료");
        }
    }

    public List<ReleaseDto> findAll() {
        List<ReleaseDto> releaseAll = new ArrayList();
        con = factory.open();
        String query = "SELECT * FROM releases";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String product_id = rs.getString("product_id");
                String customer_name = rs.getString("customer_name");
                String customer_address = rs.getString("customer_address");
                int amount = rs.getInt("amount");
                ReleaseStatus Status = ReleaseStatus.valueOf(rs.getString("status"));
                String remarks = rs.getString("remarks");
                String request_date = rs.getString("request_date");
                String update_date = rs.getString("approval_date");
                ReleaseDto dto = new ReleaseDto(id, user_id, product_id, customer_name, customer_address, amount, Status, remarks, request_date, update_date);
                releaseAll.add(dto);
            }

            pstmt.close();
            rs.close();
            con.close();
            factory.close();
        } catch (SQLException var14) {
            System.err.println("커넥션 에러");
        }

        return releaseAll;
    }

    public int stockCheck(int id) {
        int cal = -2;
        ReleaseDto findDto = this.findById(id);
        if (findDto.getReleaseStatus() != ReleaseStatus.PENDING) {
            return cal;
        } else {
            con = factory.open();
            String query = "SELECT quantity FROM stock s INNER JOIN product p on p.id = ? and s.product_id = p.id";

            try {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, findDto.getProduct_id());
                rs = pstmt.executeQuery();

                while(rs.next()) {
                    int stock = rs.getInt("quantity");
                    if (stock > findDto.getAmount()) {
                        cal = stock - findDto.getAmount();
                    } else {
                        cal = -1;
                    }
                }

                pstmt.close();
                rs.close();
                con.close();
            } catch (SQLException var6) {
                System.err.println("커넥션 에러");
            }

            return cal;
        }
    }

    public void updateRelease(int id, int select) {
        DeliveryDaoImpl deliveryDaoImpl = new DeliveryDaoImpl();
        String query = "UPDATE releases SET status = ?, approval_date = ? WHERE id = ?";
        con = factory.open();

        try {
            pstmt = con.prepareStatement(query);
            if (select == 1) {
                pstmt.setString(1, ReleaseStatus.APPROVED.toString());
            } else if (select == 2) {
                pstmt.setString(1, ReleaseStatus.REJECTED.toString());
            } else {
                List<DeliveryDto> deliveryDtos = deliveryDaoImpl.findByAll();
                Iterator var6 = deliveryDtos.iterator();

                while(var6.hasNext()) {
                    DeliveryDto deliveryDto = (DeliveryDto)var6.next();
                    if (deliveryDto.getRelease_id() == id) {
                        System.out.println("취소 불가");
                        return;
                    }

                    pstmt.setString(1, ReleaseStatus.CANCEL.toString());
                }

                System.out.println("취소 완료");
            }

            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String approval_date = dateTime.format(formatter);
            pstmt.setString(2, approval_date);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException var8) {
            System.err.println("커넥션 에러");
        }

    }

    public boolean productCheck(String product_id) {
        boolean check = false;
        con = factory.open();
        String query = "SELECT COUNT(*) FROM stock s INNER JOIN product p ON s.product_id = p.id and p.id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product_id);
            rs = pstmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }

            if (count > 0) {
                check = true;
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return check;
    }

    public ReleaseDto findById(int id) {
        ReleaseDto findDto = null;
        con = factory.open();
        String query = "SELECT * FROM releases WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            int release_id;
            int user_id;
            String product_id;
            String customer_name;
            String customer_address;
            int amount;
            ReleaseStatus Status;
            String remarks;
            String request_date;
            String update_date;
            for(rs = pstmt.executeQuery(); rs.next(); findDto = new ReleaseDto(release_id, user_id, product_id, customer_name, customer_address, amount, Status, remarks, request_date, update_date)) {
                release_id = rs.getInt("id");
                user_id = rs.getInt("user_id");
                product_id = rs.getString("product_id");
                customer_name = rs.getString("customer_name");
                customer_address = rs.getString("customer_address");
                amount = rs.getInt("amount");
                Status = ReleaseStatus.valueOf(rs.getString("status"));
                remarks = rs.getString("remarks");
                request_date = rs.getString("request_date");
                update_date = rs.getString("approval_date");
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException var14) {
            var14.printStackTrace();
        }

        return findDto;
    }

    static {
        new ConnectionFactory();
        factory = ConnectionFactory.getInstance();
        rs = null;
        pstmt = null;
        con = null;
    }
}
