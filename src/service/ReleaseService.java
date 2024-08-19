package service;

import dto.ReleaseDto;

public interface ReleaseService {
    void createRelease(ReleaseDto var1);

    void updateRelease(int var1, int var2);

    int stockCheck(int var1);
}
