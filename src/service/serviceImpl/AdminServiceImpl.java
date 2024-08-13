package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import dto.AdminDto;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    private static AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void createAdmin(AdminDto admin) {
        adminDao.createAdmin(admin);
    }
}
