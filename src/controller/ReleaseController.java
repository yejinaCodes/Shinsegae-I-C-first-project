package controller;

import common.ReleaseStatus;
import dto.ReleaseDto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import service.serviceImpl.DeliveryServiceImpl;
import service.serviceImpl.ReleaseServiceImpl;
import service.serviceImpl.ShippingInstructionServiceImpl;
import service.serviceImpl.WaybillServiceImpl;

public class ReleaseController {
    static BufferedReader br;
    static ReleaseServiceImpl releaseService;
    static DeliveryServiceImpl deliveryService;
    static WaybillServiceImpl waybillService;
    static ShippingInstructionServiceImpl shippingInstructionService;
    static StringBuilder waybill;
    static int id;

    public ReleaseController() {
    }

    public static void main(String[] var0) {
        // $FF: Couldn't be decompiled
    }

    static void releaseReject() {
        List<ReleaseDto> releaseReject = releaseService.getAll();
        boolean exist = false;
        System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 ㅣ 출고 거절 날짜");
        Iterator var2 = releaseReject.iterator();

        while(var2.hasNext()) {
            ReleaseDto dto = (ReleaseDto)var2.next();
            if (dto.getReleaseStatus() == ReleaseStatus.REJECTED) {
                exist = true;
                System.out.printf("\t\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|\t %s \t|\t %s \t|\t %s \t\n", dto.getId(), dto.getProduct_id(), dto.getCustomer_name(), dto.getCustomer_address(), dto.getAmount(), dto.getReleaseStatus(), dto.getRemarks(), dto.getUpdate_date());
            }
        }

        if (!exist) {
            System.out.println("거절 리스트가 비어있습니다.");
        }

    }

    static void releaseApproval() {
        List<ReleaseDto> releaseApproval = releaseService.getAll();
        System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 | 출고 승인 날짜");
        boolean exist = false;
        Iterator var2 = releaseApproval.iterator();

        while(var2.hasNext()) {
            ReleaseDto dto = (ReleaseDto)var2.next();
            if (dto.getReleaseStatus() == ReleaseStatus.APPROVED) {
                exist = true;
                System.out.printf("\t\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|%s|\t %s \t|\t %s \t|\t %s \t|\n", dto.getId(), dto.getProduct_id(), dto.getCustomer_name(), dto.getCustomer_address(), dto.getAmount(), dto.getReleaseStatus(), dto.getRemarks(), dto.getRequest_date(), dto.getUpdate_date());
            }
        }

        if (!exist) {
            System.out.println("승인 리스트가 비어있습니다.");
        }

    }

    static void releaseAll() {
        List<ReleaseDto> releaseAll = releaseService.getAll();
        if (releaseAll.isEmpty()) {
            System.out.println("출고 리스트가 비어있습니다.");
        } else {
            System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 | 출고 승인 날짜");
            Iterator var1 = releaseAll.iterator();

            while(var1.hasNext()) {
                ReleaseDto dto = (ReleaseDto)var1.next();
                String Approval_date = (String)Optional.ofNullable(dto.getUpdate_date()).orElse("");
                System.out.printf("\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|\t %s \t|\t %s \t|\t %s \t|\t %s \t|\n", dto.getId(), dto.getProduct_id(), dto.getCustomer_name(), dto.getCustomer_address(), dto.getAmount(), dto.getReleaseStatus().toString(), dto.getRemarks(), dto.getRequest_date(), Approval_date);
            }
        }

    }

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        releaseService = new ReleaseServiceImpl();
        deliveryService = new DeliveryServiceImpl();
        waybillService = new WaybillServiceImpl();
        shippingInstructionService = new ShippingInstructionServiceImpl();
        waybill = new StringBuilder();
        id = 0;
    }
}
