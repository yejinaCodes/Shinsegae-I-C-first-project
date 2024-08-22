package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDto {
    private int id;
    private String name;
    private String city;
    private String number;
    private double size;
}
