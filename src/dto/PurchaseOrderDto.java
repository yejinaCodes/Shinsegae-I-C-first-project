package dto;

import java.time.LocalDate;
import lombok.Data;

// 1차 주문 요청서는 유저가 create만 하는 기능을 가짐. Dummy로 주문 요청서 많이 넣어놓기
@Data
public class PurchaseOrderDto {
  private int purchaseOrderNo;
  private int cell_id;
  private int product_id; //product_id String으로 바꾸기?
  private int product_quantity;
  //private char box_size;
  private String deliver_date;
  private LocalDate created_at;
  private String approval_status;
//  public void setDeliver_date(){
//    this.deliver_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//  }
  public void setCreated_at(){
    //this.created_at = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    this.created_at = LocalDate.now();
  }

//  public void setPurchaseOrderNo(){
//    this.purchaseOrderNo = this.purchaseOrderNo + 1;
//    this.purchaseOrderNo++;
//  }
}
