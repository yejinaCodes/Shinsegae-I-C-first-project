package controller;

import dto.PurchaseOrderDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import service.serviceImpl.PurchaseOrderServiceImpl;

public class PurchaseOrderController {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public void insert_order() throws IOException {
    PurchaseOrderServiceImpl poService = new PurchaseOrderServiceImpl();

    while(true){
      try{
        PurchaseOrderDto order = new PurchaseOrderDto();

        System.out.println("------------------------------------------------------");
        System.out.println("PurchaseOrder (주문서 작성)");
        order.setPurchaseOrderNo();
        System.out.print("Product id 입력: ");
        int product = Integer.parseInt(br.readLine());
        order.setProductId(product);
        System.out.print("Product quantity (상품 수량): ");
        int quantity = Integer.parseInt(br.readLine());
        order.setProductQuantity(quantity);
        System.out.print("Select cell (창고 셀 선택하기): ");
        //db에서 선택 가능한 Cell 가지고 오기!!!


        int cell = Integer.parseInt(br.readLine());
        order.setCellId(cell);
        System.out.print("Desired delivery date (납입날짜) YYYYMMdd 포맷으로 입력: ");
        String deliverDate = br.readLine();
        order.setDeliverDate(deliverDate);
        order.setCreatedAt();
        order.setApprovalStatus("PENDING"); //default로 pending 저장

        poService.create(order);

        break;
      }catch (IOException e){
        System.out.println("유저 주문서 입력중 에러 발생");
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }

    }
  }
}
