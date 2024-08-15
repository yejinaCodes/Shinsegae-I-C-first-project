package dto.response;

import common.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserApprovalResponseDto {

    private int id;
    private int userId;
    private int approverId;
    private Status approvalStatus;
    private String rejectionReason;
    private String createdAt;
    private String businessNumber;
    private String companyName;

    public UserApprovalResponseDto(ResultSet rs) throws SQLException {
        this.userId = rs.getInt("user_id");
        this.businessNumber = rs.getString("business_number");
        this.companyName = rs.getString("company_name");
        this.createdAt = rs.getString("created_at");
        this.approvalStatus = Status.valueOf(rs.getString("approval_status"));
    }
}
