package controller;

import dto.CellDto;
import dto.SectionDto;
import dto.WarehouseDto;
import service.serviceImpl.CellSeriveImpl;
import service.serviceImpl.SectionServiceImpl;
import service.serviceImpl.WarehouseServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WarehouseController {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static WarehouseServiceImpl warehouseService = new WarehouseServiceImpl();
    static SectionServiceImpl sectionService = new SectionServiceImpl();
    static CellSeriveImpl cellSerive = new CellSeriveImpl();

    public static void main(String[] args) throws IOException {
        boolean loop = true;
        while(loop) {
                System.out.println("1. 창고 조회 2. section 전체 조회 3. cell 전체 조회 4. section 조회 5. cell 조회  6. 나가기");
                switch (Integer.parseInt(br.readLine())){
                    case 1:
                        List<WarehouseDto> warehouseAll = warehouseService.getAll();
                        System.out.println("창고 아이디 | 창고 이름 | 창고 위치 | 창고 전화번호 | 창고 사이즈(m^2)");
                        for (WarehouseDto warehouseDto : warehouseAll) {
                            System.out.printf("|\t%d\t|\t%s\t|\t%s\t|\t%s\t|\t%.1f\n",
                            warehouseDto.getId(),
                            warehouseDto.getName(),
                            warehouseDto.getCity(),
                            warehouseDto.getNumber(),
                            warehouseDto.getSize());
                        }
                        break;
                    case 2:
                        List<SectionDto> sectionAll = sectionService.getAll();
                        System.out.println("section 번호 | 창고 아이디 | section 사이즈(m^2) |");
                        for (SectionDto sectionDto : sectionAll) {
                            System.out.printf("|\t%d\t|\t%d\t|\t%.1f\t|\n",
                                    sectionDto.getId(),
                                    sectionDto.getWarehouse_id(),
                                    sectionDto.getSize());
                        }
                        break;
                    case 3:
                        List<CellDto> cellAll = cellSerive.getAll();
                        System.out.println("cell 번호 | section 번호 | cell 사이즈(m^2) | 총량 | 남은 수량 |");
                        for (CellDto cellDto : cellAll) {
                            System.out.printf("|\t%d\t|\t%d\t|\t%.1f\t|\t%d\t|\t%d\t|\n",
                                    cellDto.getId(),
                                    cellDto.getSection_id(),
                                    cellDto.getSize(),
                                    cellDto.getTotal_capacity(),
                                    cellDto.getAvailable_capacity());
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("다시 입력하세요.");
                        break;
                }
        }
    }
}

