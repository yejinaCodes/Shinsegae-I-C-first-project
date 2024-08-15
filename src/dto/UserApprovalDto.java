package dto;

import common.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserApprovalDto {

    private int id;
    private int userId;
    private int approverId;
    private Status approvalStatus;
    private String rejectionReason;
    private String createdAt;
}
