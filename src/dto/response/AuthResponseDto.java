package dto.response;

import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponseDto {
    private int id;
    private String password;
    private String salt;

    public AuthResponseDto(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.password = rs.getString("password");
        this.salt = rs.getString("salt");
    }
}
