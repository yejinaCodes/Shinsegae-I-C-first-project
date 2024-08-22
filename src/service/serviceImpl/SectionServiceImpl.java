package service.serviceImpl;

import dao.daoImpl.SectionDaoImpl;
import dto.SectionDto;
import service.SectionService;

import java.util.List;

public class SectionServiceImpl implements SectionService {
    static SectionDaoImpl sectionDao = new SectionDaoImpl();
    @Override
    public List<SectionDto> getAll() {
        return sectionDao.findAll();
    }

    @Override
    public SectionDto getById(int id) {
        return sectionDao.findById(id);
    }
}
