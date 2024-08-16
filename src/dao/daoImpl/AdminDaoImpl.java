package dao.daoImpl;

import config.ConnectionFactory;
import dao.AdminDao;
import dto.request.AdminRequestDto;
import dto.response.AdminResponseDto;
import dto.response.AuthResponseDto;
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
            .append("(name, admin_id, password, salt, company_email, phone, created_at)")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?)").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getName());
            pstmt.setString(2, request.getAdminId());
            pstmt.setString(3, request.getPassword());
            pstmt.setString(4, request.getSalt());
            pstmt.setString(5, request.getCompanyEmail());
            pstmt.setString(6, request.getPhone());
            pstmt.setString(7, request.getCreatedAt());

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
    public String findAdminId(int id) {
        String response = "";
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("SELECT CONCAT(LEFT(admin_id, 3), REPEAT('*', LENGTH(admin_id) - 3)) AS admin_id ")
            .append("FROM Admin ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                response = rs.getString("admin_id");
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
    public AuthResponseDto findAuth(String adminId) {
        AuthResponseDto response = null;
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("SELECT id, password, salt ")
            .append("FROM Admin ")
            .append("WHERE admin_id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, adminId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                response = new AuthResponseDto(rs);
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
            .append("name = ?, admin_id = ?, company_email = ?, ")
            .append("phone = ?, updated_at = ? ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getName());
            pstmt.setString(2, request.getAdminId());
            pstmt.setString(3, request.getCompanyEmail());
            pstmt.setString(4, request.getPhone());
            pstmt.setString(5, request.getUpdatedAt());
            pstmt.setInt(6, request.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }

    @Override
    public void updatePwd(String adminId, AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("UPDATE Admin ")
            .append("SET ")
            .append("password = ?, salt = ?, updated_at = ? ")
            .append("WHERE admin_id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getPassword());
            pstmt.setString(2, request.getSalt());
            pstmt.setString(3, request.getUpdatedAt());
            pstmt.setString(4, adminId);

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
    public void updateAdminDeptPos(int targetEmployeeId, AdminRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("UPDATE Admin ")
            .append("SET ")
            .append("department = ?, position = ?, updated_at = ? , authorizer_id = ? ")
            .append("WHERE id = ?").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, request.getDepartment().toString());
            pstmt.setString(2, request.getPosition().toString());
            pstmt.setString(3, request.getUpdatedAt());
            pstmt.setInt(4, request.getId());
            pstmt.setInt(5, targetEmployeeId);

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
