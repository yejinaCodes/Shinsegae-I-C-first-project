package service.serviceImpl;

import dao.daoImpl.WarehouseDaoImpl;
import dto.WarehouseDto;
import service.WarehouseService;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {
    static WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl();

    @Override
    public List<WarehouseDto> getAll() {
        return warehouseDao.findAll();
    }
}
