package service.serviceImpl;

import dao.daoImpl.WaybillDaoImpl;
import dto.WaybillDto;
import java.util.List;
import service.WaybillService;

public class WaybillServiceImpl implements WaybillService {
    static WaybillDaoImpl dao = new WaybillDaoImpl();

    public WaybillServiceImpl() {
    }

    public void createRelease(WaybillDto waybillDto) {
        dao.createWaybill(waybillDto);
    }

    public List<WaybillDto> getAll() {
        return dao.findByAll();
    }

    public WaybillDto getId(int id) {
        return dao.findById(id);
    }
}
