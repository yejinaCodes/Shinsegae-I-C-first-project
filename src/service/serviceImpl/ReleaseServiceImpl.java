package service.serviceImpl;

import dao.daoImpl.ReleaseDaoImpl;
import dto.ReleaseDto;
import java.util.List;
import service.ReleaseService;

public class ReleaseServiceImpl implements ReleaseService {
    static ReleaseDaoImpl releaseDao = new ReleaseDaoImpl();

    public ReleaseServiceImpl() {
    }

    public void createRelease(ReleaseDto releaseDto) {
        releaseDao.createRelease(releaseDto);
    }

    public List<ReleaseDto> getAll() {
        return releaseDao.findAll();
    }

    public void updateRelease(int id, int select) {
        releaseDao.updateRelease(id, select);
    }

    public int stockCheck(int id) {
        return releaseDao.stockCheck(id);
    }
}
