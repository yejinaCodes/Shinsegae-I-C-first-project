package service;

import dto.WaybillDto;
import java.util.List;

public interface WaybillService {
    void createRelease(WaybillDto waybillDto);

    List<WaybillDto> getAll();

    WaybillDto getId(String id);
}
