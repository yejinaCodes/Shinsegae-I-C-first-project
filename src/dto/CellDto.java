package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CellDto {
    private int id;
    private int sectionId;
    private int totalCapacity;
    private double size;
    private int availableCapacity;
}
