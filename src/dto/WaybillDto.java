package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaybillDto {
    private String id;
    private int delivery_id;
    private String created_at;

    public WaybillDto(String id, int delivery_id){
        this.id = id;
        this.delivery_id = delivery_id;
    }
}