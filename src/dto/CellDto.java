package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CellDto {
    private int id;
    private int section_id;
    private int total_capacity;
    private double size;
    private int available_capacity;
}
