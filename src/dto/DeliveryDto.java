package dto;

import common.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private int id;
    private int releaseId;
    private int adminId;
    private int warehouseId;
    private int userId;
    private String createdAt;
    private String updatedAt;
    private String startDate;
    private String endDate;
    private String remarks;
    private DeliveryStatus deliveryStatus;

    public DeliveryDto(int releaseId, String remarks){
        this.releaseId = releaseId;
        this.remarks = remarks;
    }
}