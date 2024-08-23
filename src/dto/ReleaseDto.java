package dto;

import common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseDto {

    private int id;
    private int userId;
    private String productId;
    private String customerName;
    private String customerAddress;
    private int amount;
    private Status releaseStatus;
    private String remarks;
    //시간 받기
    private String createdAt;
    private String updatedAt;

    public ReleaseDto(String customerName, String customerAddress, int amount, String productId, String remarks){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.amount = amount;
        this.productId = productId;
        this.releaseStatus = Status.PENDING;
        this.remarks = remarks;
    }
}