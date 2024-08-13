package dao.daoImpl;

import config.ConnectionFactory;
import dao.AdminDao;
import dto.AdminDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdminDaoImpl implements AdminDao {

    private static Connection connection = null;
    private static ResultSet rs = null;

    @Override
    public void createAdmin(AdminDto admin) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("INSERT INTO Admin ")
            .append("(name, admin_id, password, email, company_email, phone, zip_code, address, created_at)")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, admin.getName());
            pstmt.setString(2, admin.getAdminId());
            pstmt.setString(3, admin.getPassword());
            pstmt.setString(4, admin.getEmail());
            pstmt.setString(5, admin.getCompanyEmail());
            pstmt.setString(6, admin.getPhone());
            pstmt.setString(7, admin.getZipCode());
            pstmt.setString(8, admin.getAddress());
            pstmt.setString(9, admin.getCreatedAt());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
