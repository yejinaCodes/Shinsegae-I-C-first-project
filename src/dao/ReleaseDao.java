package dao;

import dto.ReleaseDto;

import java.sql.SQLException;
import java.util.List;

public interface ReleaseDao {
    int stockCheck(int id);

    void createRelease(ReleaseDto releaseDto);

    void updateRelease(int id, int select) throws SQLException;

    boolean productCheck(String product_id);

    List<ReleaseDto> findAll();

    ReleaseDto findById(int id);
}
