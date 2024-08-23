package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.Data;

@Data
public class StockRequestDto {
  private int id;
  private int cellId;
  private String productId;
  private int supplierId;
  private LocalDate incomingDate;
  private LocalDate createdAt;
  private int boxQuantity;
  private char boxSize;
  private String status;
  private String remarks;
  private Optional<String> loadingInstr;
  private Optional<Integer> stockRequestId;

  public StockRequestDto() {
  }

  public StockRequestDto(String product_id, int box_quantity, char box_size,
      String incoming_date, int cell_id, int supplier_id, String remarks) {
    this.productId = product_id;
    this.boxQuantity = box_quantity;
    this.boxSize = box_size;
    this.cellId = cell_id;
    this.supplierId = supplier_id;
    this.status = "PENDING";
    this.remarks = remarks;
    setCreatedAt();
    setIncomingDate(incoming_date);
  }

  public void setIncomingDate(String date){ //오전, 오후 추가
    LocalDate time = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    this.incomingDate = time;
  }
  public void setIncomingDate(LocalDate date){
    this.incomingDate = date;
  }

  public void setCreatedAt(){
    this.createdAt = LocalDate.now();
  }

}