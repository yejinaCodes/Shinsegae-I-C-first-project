package dao;

import dto.WaybillDto;
import java.util.List;

public interface WaybillDao {
    void createWaybill(WaybillDto var1);

    List<WaybillDto> findByAll();

    WaybillDto findById(int var1);
}