package dao;

import dto.request.NoticeRequestDto;

public interface NoticeDao {
    void createNotice(NoticeRequestDto request);
}
