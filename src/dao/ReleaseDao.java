package dao;

import dto.ReleaseDto;

public interface ReleaseDao {
    int stockCheck(int var1);

    void createRelease(ReleaseDto var1);

    void updateRelease(int var1, int var2);
}
