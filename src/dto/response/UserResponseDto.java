package dto.response;

import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private int id;
    private String name;
    private String businessNumber;
    private String companyName;
    private String userId;
    private String password;
    private String email;
    private String phone;
    private String zipCode;
    private String address;
    private int isUnregister;
    private String createdAt;
    private String updatedAt;
    private int updatedAdminId;
    private String updatedAdminAt;
    private String unregisteredAt;

    public UserResponseDto(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.businessNumber = rs.getString("business_number");
        this.companyName = rs.getString("company_name");
        this.userId = rs.getString("user_id");
        this.password = rs.getString("password");
        this.email = rs.getString("email");
        this.phone = rs.getString("phone");
        this.zipCode = rs.getString("zip_code");
        this.address = rs.getString("address");
        this.isUnregister = rs.getInt("is_unregister");
        this.createdAt = rs.getString("created_at");
        this.updatedAt = rs.getString("updated_at");
        this.updatedAdminId = rs.getInt("updated_admin_id");
        this.updatedAdminAt = rs.getString("updated_admin_at");
        this.unregisteredAt = rs.getString("unregistered_at");
    }
}
