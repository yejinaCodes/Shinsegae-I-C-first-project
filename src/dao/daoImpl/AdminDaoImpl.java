package dao.daoImpl;

import config.ConnectionFactory;
import dao.AdminDao;
import dto.request.AdminRequestDto;
import dto.response.AdminResponseDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private static Connection connection = null;
    private static ResultSet rs = null;

    @Override
    public void createAdmin(AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("INSERT INTO Admin ")
            .append("(name, admin_id, password, email, company_email, phone, zip_code, address, created_at)")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getName());
            pstmt.setString(2, request.getAdminId());
            pstmt.setString(3, request.getPassword());
            pstmt.setString(4, request.getEmail());
            pstmt.setString(5, request.getCompanyEmail());
            pstmt.setString(6, request.getPhone());
            pstmt.setString(7, request.getZipCode());
            pstmt.setString(8, request.getAddress());
            pstmt.setString(9, request.getCreatedAt());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }

    @Override
    public AdminResponseDto findById(int id) {
        AdminResponseDto response = null;
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("SELECT * ")
            .append("FROM Admin ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                response = new AdminResponseDto(rs);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }

        return response;
    }

    @Override
    public List<AdminResponseDto> findAll() {
        List <AdminResponseDto> response = new ArrayList<>();
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("SELECT * ")
            .append("FROM Admin").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                response.add(new AdminResponseDto(rs));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }

        return response;
    }

    @Override
    public List<AdminResponseDto> findByRole(String role) {
        List <AdminResponseDto> response = new ArrayList<>();
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("SELECT * ")
            .append("FROM Admin ")
            .append("WHERE role = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, role);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                response.add(new AdminResponseDto(rs));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }

        return response;
    }

    @Override
    public void updateAdmin(AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("UPDATE Admin ")
            .append("SET ")
            .append("name = ?, admin_id = ?, email = ?, company_email = ?, ")
            .append("phone = ?, zip_code = ?, address = ?, updated_at = ? ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getName());
            pstmt.setString(2, request.getAdminId());
            pstmt.setString(3, request.getEmail());
            pstmt.setString(4, request.getCompanyEmail());
            pstmt.setString(5, request.getPhone());
            pstmt.setString(6, request.getZipCode());
            pstmt.setString(7, request.getAddress());
            pstmt.setString(8, request.getUpdatedAt());
            pstmt.setInt(9, request.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }

    @Override
    public void updatePwd(AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("UPDATE Admin ")
            .append("SET ")
            .append("password = ?, updated_at = ? ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getPassword());
            pstmt.setString(2, request.getUpdatedAt());
            pstmt.setInt(3, request.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }

    @Override
    public void updateRole(int targetEmployeeId, AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("UPDATE Admin ")
            .append("SET ")
            .append("role = ?, updated_at = ? , authorizer_id = ? ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getRole().toString());
            pstmt.setString(2, request.getUpdatedAt());
            pstmt.setInt(3, request.getId());
            pstmt.setInt(4, targetEmployeeId);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }

    @Override
    public void deleteAdmin(int targetEmployeeId) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("DELETE FROM Admin ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, targetEmployeeId);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }
}
