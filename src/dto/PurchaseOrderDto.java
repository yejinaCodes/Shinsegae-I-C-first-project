package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Data;

// 1차 주문 요청서는 유저가 create만 하는 기능을 가짐. Dummy로 주문 요청서 많이 넣어놓기
@Data
public class PurchaseOrderDto {
  private int purchaseOrderNo = 0;
  private int cellId;
  private int productId;
  private int productQuantity;
  //private char box_size;
  private String deliverDate;
  private String createdAt;
  private String approvalStatus;
//  public void setDeliver_date(){
//    this.deliver_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//  }
  public void setCreatedAt(){
    this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
  }
  public void setPurchaseOrderNo(){
    this.purchaseOrderNo = this.purchaseOrderNo + 1;
  }
}
