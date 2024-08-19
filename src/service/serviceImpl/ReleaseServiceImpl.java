package service.serviceImpl;

import dao.daoImpl.ReleaseImplDao;
import dto.ReleaseDto;
import service.ReleaseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReleaseServiceImpl implements ReleaseService {
    static ReleaseImplDao releaseDao = new ReleaseImplDao();

    public void createRelease(ReleaseDto releaseDto){
        releaseDao.createRelease(releaseDto);//dao로 전달
    }

    public List<ReleaseDto> getAll(){
        return releaseDao.findAll();
    }

    public void updateRelease(int id, int select) throws SQLException {
        releaseDao.updateRelease(id,select);
    }

    public int stockCheck(int id){
        return releaseDao.stockCheck(id);
    }

    public ReleaseDto getId(int id){
        return releaseDao.findById(id);
    }
}