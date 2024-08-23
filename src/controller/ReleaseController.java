package controller;

import common.Status;
import dao.daoImpl.DeliveryImplDao;
import dto.DeliveryDto;
import dto.ReleaseDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import dto.ShippingInstructionDto;
import dto.WaybillDto;
import service.serviceImpl.DeliveryServiceImpl;
import service.serviceImpl.ReleaseServiceImpl;
import service.serviceImpl.ShippingInstructionServiceImpl;
import service.serviceImpl.WaybillServiceImpl;

public class ReleaseController {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final ReleaseServiceImpl releaseService = new ReleaseServiceImpl();
    private final DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();
    private final WaybillServiceImpl waybillService = new WaybillServiceImpl();
    private final ShippingInstructionServiceImpl shippingInstructionService = new ShippingInstructionServiceImpl();
    private final StringBuilder waybill = new StringBuilder();
    private int id = 0;

    public void releaseEmployeeMenu() throws IOException{
        boolean loop = true;
        while (loop) {
            System.out.println("1. 출고 요청서 작성 2. 출고 조회 3. 출고 취소 4. 나가기");
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    createRelease();
                    break;
                case 2:
                    System.out.println("1. 전체 조회 2. 요청 승인 조회 3. 요청 거절 조회 4.나가기");
                    switch (Integer.parseInt(br.readLine())) {
                        case 1:
                            readReleaseAll();
                            break;
                        case 2:
                            readReleaseApproval();
                            break;
                        case 3:
                            readReleaseReject();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("다시 입력하세요.");
                            break;
                    }
                    break;
                case 3:
                    updateReleaseCancel();
                    System.out.println("취소 완료");
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("다시 입력하세요.");
                    break;
            }
        }
    }

    public void releaseAdminMenu() throws IOException {
        //deliveryService.schedulerOn();
        boolean loop = true;
        while (loop) {
            System.out.println("1. 출고 관리 2. 배송 관리 3. 운송장 관리 4. 나가기");
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    System.out.println("1. 전체 조회 2. 요청 승인 조회 3. 요청 거절 조회 4. 출고 승인 5. 출고 거절 6. 출고 지시서 조회 7. 뒤로");
                    switch (Integer.parseInt(br.readLine())) {
                        case 1:
                            readReleaseAll();
                            break;
                        case 2:
                            readReleaseApproval();
                            break;
                        case 3:
                            readReleaseReject();
                            break;
                        case 4:
                            updateReleaseApproval();
                            break;
                        case 5:
                            updateReleaseReject();
                            break;
                        case 6:
                            readAllShip();
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("다시 입력하세요.");
                            break;
                    }
                    break;
                case 2://배송
                    System.out.println("1. 배차 등록 2. 배차 취소 3. 배차 조회 4. 배차 취소 조회 5. 대기 중인 배송기사 조회 6. 나가기");
                    switch (Integer.parseInt(br.readLine())) {
                        case 1:
                            createDelivery();
                            break;
                        case 2:
                            cancelDelivery();
                            break;
                        case 3:
                            readDeliveryAll();
                            break;
                        case 4://1분을 1일로 바꿔라
                            readDeliveryCancel();
                            break;
                        case 5:
                            readDeliveryMan();
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("다시 입력하세요.");
                            break;
                    }
                    break;
                case 3://운송장
                    System.out.println("1. 운송장 등록 2. 운송장 조회 3. 운송장 전체 조회 4. 나가기");
                    switch (Integer.parseInt(br.readLine())) {
                        case 1:
                            createWaybill();
                            break;
                        case 2:
                            readWaybillId();
                            break;
                        case 3:
                            readWaybillAll();
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("다시 입력하세요.");
                    break;
            }
        }
    }

    public void createRelease() throws IOException {
        System.out.printf("수령인 이름 : ");
        String customer_name = br.readLine();

        System.out.printf("수령인 주소 : ");
        String customer_address = br.readLine();

        System.out.printf("출고할 상품 코드 : ");
        String product_id = br.readLine();

        System.out.printf("출고 수량 : ");
        int amount = Integer.parseInt(br.readLine());

        System.out.printf("요청 사항 : ");
        String remarks = br.readLine();

        ReleaseDto releaseDto = new ReleaseDto(
                customer_name,
                customer_address,
                amount,
                product_id,
                remarks);

        releaseService.createRelease(releaseDto); //service로 전달
    }

    public void updateReleaseCancel() throws IOException{
        System.out.println("출고 취소할 아이디 입력 (뒤로 가기 : 0) : ");
        id = Integer.parseInt(br.readLine());
        if (id != 0)
            releaseService.updateRelease(id, 3);
    }

    public void updateReleaseApproval() throws IOException{
        System.out.println("출고 승인할 아이디 입력 (뒤로 가기 : 0) : ");
        id = Integer.parseInt(br.readLine());
        if (id != 0) {
            int cal = releaseService.stockCheck(id);
            if (cal >= 0) {
                System.out.printf("출고하면 창고에 %d개 남는다. 정말 할건가요?\n", cal);
                System.out.println("1. 예 2. 아니오");
                int select = Integer.parseInt(br.readLine());
                if (select == 1) {
                    releaseService.updateRelease(id, select);
                    System.out.println("승인 완료");
                } else
                    System.out.println("승인 실패");
            } else if (cal == -1)
                System.out.println("재고부족으로 출고 승인 불가");
            else
                System.out.println("출고가 이미 결정되었습니다.");
        }
    }

    public void updateReleaseReject() throws IOException{
        System.out.println("출고 거절할 아이디 입력 (뒤로 가기 : 0) : ");
        id = Integer.parseInt(br.readLine());
        if (id != 0) {
            releaseService.updateRelease(id, 2);
            System.out.println("거절 완료");
        }
    }

    public void readAllShip() {
        List<ShippingInstructionDto> findAll = shippingInstructionService.getAll();
        System.out.println("출고 지시서 아이디 | 배송 아이디 | 출고 아이디 | 등록 날짜 |");
        for (ShippingInstructionDto dto : findAll) {
            System.out.printf("\t%d\t|\t%d\t|\t%d\t|\t%s\t|\n",
                    dto.getId(),
                    dto.getDeliveryId(),
                    dto.getReleaseId(),
                    dto.getCreatedAt());
        }
    }

    public void createDelivery() throws IOException {
        System.out.println("출고 아이디 입력(0 : 나가기) :");
        id = Integer.parseInt(br.readLine());
        if (id != 0) {
            System.out.println("요청 사항을 입력해주세요.");
            String remark = br.readLine();
            System.out.println("배차를 등록하시겠습니까?");
            System.out.println("1.네 2. 아니요");
            if (Integer.parseInt(br.readLine()) == 1) {
                DeliveryDto deliveryDto = new DeliveryDto(id, remark);
                //shippingInstructionService.createShippingInstruction();
                deliveryService.createDelivery(deliveryDto);
            }
        }
    }

    public void cancelDelivery() throws IOException {
        System.out.println("취소할 배차 아이디 입력(0 : 나가기) :");
        id = Integer.parseInt(br.readLine());
        if (id != 0) {
            System.out.println("배차를 취소하시겠습니까?");
            System.out.println("1.네 2. 아니요");
            if (Integer.parseInt(br.readLine()) == 1) {
                deliveryService.updateDelivery(id);
                System.out.println("배차 취소가 완료되었습니다.");
            }
        }
    }

    public void readDeliveryAll() {
        List<DeliveryDto> deliveryAll = deliveryService.getAll();

        if (deliveryAll.isEmpty())
            System.out.println("배차 리스트가 비어있습니다.");
        else {
            System.out.println("배차 아이디 | 출고 아이디 | 배송 기사 아이디 | 창고 아이디 | 쇼핑몰 아이디 | 배차 등록 날짜 | 배차 수정 날짜 | 배송 출발 날짜 | 배송 완료 예정 날짜 | 요청 사항 | 배송 상태");
            for (DeliveryDto dto : deliveryAll) {
                String updated_at = Optional.ofNullable(dto.getUpdatedAt()).orElse("");
                System.out.printf("\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\n",
                        dto.getId(),
                        dto.getReleaseId(),
                        dto.getAdminId(),
                        dto.getWarehouseId(),
                        dto.getUserId(),
                        dto.getCreatedAt(),
                        updated_at,
                        dto.getStartDate(),
                        dto.getEndDate(),
                        dto.getRemarks(),
                        dto.getDeliveryStatus().toString());
            }
        }
    }

    public void readDeliveryCancel() {
        List<DeliveryDto> deliveryCancel = deliveryService.getAll();

        if (deliveryCancel.isEmpty())
            System.out.println("배차 취소 리스트가 비어있습니다.");
        else {
            System.out.println("배차 아이디 | 출고 아이디 | 배송 기사 아이디 | 창고 아이디 | 쇼핑몰 아이디 | 배차 등록 날짜 | 배차 수정 날짜 | 배송 출발 날짜 | 배송 완료 예정 날짜 | 요청 사항 | 배송 상태");
            for (DeliveryDto dto : deliveryCancel) {
                if (dto.getDeliveryStatus().toString().equals("CANCEL")) {
                    String updated_at = Optional.ofNullable(dto.getUpdatedAt()).orElse("");
                    System.out.printf("\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\n",
                            dto.getId(),
                            dto.getReleaseId(),
                            dto.getAdminId(),
                            dto.getWarehouseId(),
                            dto.getUserId(),
                            dto.getCreatedAt(),
                            updated_at,
                            dto.getStartDate(),
                            dto.getEndDate(),
                            dto.getRemarks(),
                            dto.getDeliveryStatus().toString());
                }
            }
        }
    }

    public void readDeliveryMan() {
        DeliveryImplDao deliveryImplDao = new DeliveryImplDao();
        System.out.printf("배송 가능 인원 : %d명 입니다.\n", deliveryImplDao.waitDeliveryMan().size());
    }

    public void createWaybill() throws IOException {
        System.out.println("배차 아이디 입력 (나가기 : 0) : ");
        int delivery_id = Integer.parseInt(br.readLine());
        if (delivery_id != 0) {
            Random random = new Random();
            int randomNumber1 = random.nextInt(9000) + 1000;
            int randomNumber2 = random.nextInt(9000) + 1000;
            int randomNumber3 = random.nextInt(9000) + 1000;
            waybill.append(randomNumber1).append('-')
                    .append(randomNumber2).append('-')
                    .append(randomNumber3);
            System.out.println(waybill.toString());
            WaybillDto waybilldto = new WaybillDto(waybill.toString(), delivery_id);
            waybillService.createRelease(waybilldto);
        }
    }

    public void readWaybillId() throws IOException {
        System.out.println("운송장 번호 입력 (나가기 : 0) : ");
        String waybill_id = br.readLine();
        if (!waybill_id.equals("0")) {
            WaybillDto findId = waybillService.getId(waybill_id);
            DeliveryDto deliveryDto = deliveryService.getId(findId.getDeliveryId());
            System.out.println("운송장 아이디 | 운송장 번호 | 배송 아이디 | 출고 아이디 | 등록 날짜 ㅣ 운송장 수정 날짜");
            System.out.printf("|\t%s\t|\t%d\t|\t%d\t|\t%s\t|\n",
                    findId.getId(),
                    findId.getDeliveryId(),
                    deliveryDto.getReleaseId(),
                    findId.getCreatedAt());
        }
    }

    public void readWaybillAll() {
        List<WaybillDto> findAll = waybillService.getAll();
        System.out.println("운송장 아이디 | 운송장 번호 | 배송 아이디 | 등록 날짜 |");
        for (WaybillDto waybillDto : findAll) {
            System.out.printf("|\t%s\t|\t%d\t|\t%s\t|\n",
                    waybillDto.getId(),
                    waybillDto.getDeliveryId(),
                    waybillDto.getCreatedAt());
        }
    }

    public void readReleaseReject() {
        List<ReleaseDto> releaseReject = releaseService.getAll();
        boolean exist = false;
        System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 ㅣ 출고 거절 날짜");
        for (ReleaseDto dto : releaseReject) {
            if (dto.getReleaseStatus() == Status.REJECTED) {
                exist = true;
                System.out.printf("\t\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|\t %s \t|\t %s \t|\t %s \t\n",
                        dto.getId(),
                        dto.getProductId(),
                        dto.getCustomerName(),
                        dto.getCustomerAddress(),
                        dto.getAmount(),
                        dto.getReleaseStatus(),
                        dto.getRemarks(),
                        dto.getUpdatedAt());
            }
        }
        if (!exist)
            System.out.println("거절 리스트가 비어있습니다.");
    }

    public void readReleaseApproval() {
        List<ReleaseDto> releaseApproval = releaseService.getAll();
        System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 | 출고 승인 날짜");

        boolean exist = false;
        for (ReleaseDto dto : releaseApproval) {
            if (dto.getReleaseStatus() == Status.APPROVED) {
                exist = true;
                System.out.printf("\t\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|%s|\t %s \t|\t %s \t|\t %s \t|\n",
                        dto.getId(),
                        dto.getProductId(),
                        dto.getCustomerName(),
                        dto.getCustomerAddress(),
                        dto.getAmount(),
                        dto.getReleaseStatus(),
                        dto.getRemarks(),
                        dto.getCreatedAt(),
                        dto.getUpdatedAt());
            }
        }
        if (!exist)
            System.out.println("승인 리스트가 비어있습니다.");
    }

    public void readReleaseAll() {
        List<ReleaseDto> releaseAll = releaseService.getAll();

        if (releaseAll.isEmpty())
            System.out.println("출고 리스트가 비어있습니다.");
        else {
            System.out.println("출고 아이디 | 상품 코드 | 수령인 이름 | 수령인 주소 | 출고 개수 | 출고 상태 | 요청 사항 | 출고 요청 날짜 | 출고 승인 및 미승인 날짜");
            for (ReleaseDto dto : releaseAll) {
                String Approval_date = Optional.ofNullable(dto.getUpdatedAt()).orElse("");
                System.out.printf("\t%d \t|\t %s \t|\t %s \t|\t %s \t|\t %d \t|\t %s \t|\t %s \t|\t %s \t|\t %s \t|\n",
                        dto.getId(),
                        dto.getProductId(),
                        dto.getCustomerName(),
                        dto.getCustomerAddress(),
                        dto.getAmount(),
                        dto.getReleaseStatus().toString(),
                        dto.getRemarks(),
                        dto.getCreatedAt(),
                        Approval_date);
            }
        }
    }
}