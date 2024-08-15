package dto.response;

import common.Department;
import common.Position;
import common.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDto {
    private int id;
    private String name;
    private String adminId;
    private String password;
    private String email;
    private String companyEmail;
    private Department department;
    private Position position;
    private Role role;
    private String phone;
    private String zipCode;
    private String address;
    private String createdAt;
    private int authorizerId;
    private String updatedAt;

    public AdminResponseDto(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.adminId = rs.getString("admin_id");
        this.password = rs.getString("password");
        this.email = rs.getString("email");
        this.companyEmail = rs.getString("company_email");
        this.department = Optional.ofNullable(rs.getString("department"))
            .map(d -> {
                try {
                    return Department.valueOf(d);
                } catch (IllegalArgumentException e) {
                    return null;
                }
            })
            .orElse(null);
        this.position = Optional.ofNullable(rs.getString("position"))
            .map(d -> {
                try {
                    return Position.valueOf(d);
                } catch (IllegalArgumentException e) {
                    return null;
                }
            })
            .orElse(null);
        this.role = Optional.ofNullable(rs.getString("role"))
            .map(d -> {
                try {
                    return Role.valueOf(d);
                } catch (IllegalArgumentException e) {
                    return null;
                }
            })
            .orElse(null);
        this.phone = rs.getString("phone");
        this.zipCode = rs.getString("zip_code");
        this.address = rs.getString("address");
        this.createdAt = rs.getString("created_at");
        this.authorizerId = rs.getInt("authorizer_id");
        this.updatedAt = rs.getString("updated_at");
    }
}

