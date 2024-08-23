package service;

import dto.ReleaseDto;

import java.sql.SQLException;
import java.util.List;

public interface ReleaseService {
    void createRelease(ReleaseDto var1);

    void updateRelease(int var1, int var2) throws SQLException;

    int stockCheck(int var1);

    List<ReleaseDto> getAll();

    ReleaseDto getId(int id);
}
