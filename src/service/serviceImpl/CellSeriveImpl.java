package service.serviceImpl;

import dao.daoImpl.CellDaoImpl;
import dto.CellDto;
import service.CellService;

import java.util.List;

public class CellSeriveImpl implements CellService {
    static CellDaoImpl cellDao = new CellDaoImpl();

    @Override
    public List<CellDto> getAll() {
        return cellDao.findAll();
    }

    @Override
    public CellDto getById(int id) {
        return cellDao.findById(id);
    }
}
