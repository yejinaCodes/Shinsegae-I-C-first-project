package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInstructionDto {
    private int id;
    private int releaseId;
    private int deliveryId;
    private String createdAt;
}