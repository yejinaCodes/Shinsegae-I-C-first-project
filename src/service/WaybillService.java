package service;

import dto.WaybillDto;
import java.util.List;

public interface WaybillService {
    void createRelease(WaybillDto var1);

    List<WaybillDto> getAll();

    WaybillDto getId(int var1);
}
