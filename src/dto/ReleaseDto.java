package dto;

import common.ReleaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseDto {

    private int id;
    private int user_id;
    private String product_id;
    private String customer_name;
    private String customer_address;
    private int amount;
    private ReleaseStatus releaseStatus;
    private String remarks;
    //시간 받기
    private String created_at;
    private String updated_at;

    public ReleaseDto(String customer_name, String customer_address, int amount, String product_id, String remarks){
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.amount = amount;
        this.product_id = product_id;
        this.releaseStatus = ReleaseStatus.PENDING;
        this.remarks = remarks;
    }
}