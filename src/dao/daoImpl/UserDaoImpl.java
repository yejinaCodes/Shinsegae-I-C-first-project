package dao.daoImpl;

import config.ConnectionFactory;
import dao.UserDao;
import dto.request.UserRequestDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static Connection connection = null;
    private static ResultSet rs = null;

    @Override
    public void createUser(UserRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("INSERT INTO User ")
            .append("(name, business_number, company_name, user_id, password, email, phone, zip_code, address, created_at)")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getName());
            pstmt.setString(2, request.getBusinessNumber());
            pstmt.setString(3, request.getCompanyName());
            pstmt.setString(4, request.getUserId());
            pstmt.setString(5, request.getPassword());
            pstmt.setString(6, request.getEmail());
            pstmt.setString(7, request.getPhone());
            pstmt.setString(8, request.getZipCode());
            pstmt.setString(9, request.getAddress());
            pstmt.setString(10, request.getCreatedAt());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }
}
