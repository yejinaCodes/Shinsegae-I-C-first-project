package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Data;

@Data
public class PurchaseOrderDto {
  private int purchaseOrderNo = 0;
  private int cellId;
  private int productId;
  private int productQuantity;
  private String deliverDate;
  private String createdAt;
  private String approvalStatus;

  public void setCreatedAt(){
    this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
  }
  public void setPurchaseOrderNo(){
    this.purchaseOrderNo = this.purchaseOrderNo + 1;
  }
}
