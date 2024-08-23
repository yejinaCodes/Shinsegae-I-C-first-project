package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaybillDto {
    private String id;
    private int deliveryId;
    private String createdAt;

    public WaybillDto(String id, int deliveryId){
        this.id = id;
        this.deliveryId = deliveryId;
    }
}