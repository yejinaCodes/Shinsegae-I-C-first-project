package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import dto.AdminDto;
import dto.AdminResponseDto;
import java.util.List;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    private static AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void createAdmin(AdminDto admin) {
        adminDao.createAdmin(admin);
    }

    @Override
    public AdminResponseDto findById(int id) {
        return adminDao.findById(id);
    }

    @Override
    public List<AdminResponseDto> findAll() {
        return adminDao.findAll();
    }

    @Override
    public List<AdminResponseDto> findByRole(String role) {
        return adminDao.findByRole(role);
    }
}
