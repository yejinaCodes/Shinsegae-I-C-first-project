package service.serviceImpl;

import dao.NoticeDao;
import dao.daoImpl.NoticeDaoImpl;
import dto.request.NoticeRequestDto;
import service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

    private static NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public void createNotice(NoticeRequestDto request) {
        noticeDao.createNotice(request);
    }
}
