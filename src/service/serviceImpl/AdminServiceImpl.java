package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import dto.AdminRequestDto;
import dto.AdminResponseDto;
import java.util.List;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    private static AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void createAdmin(AdminRequestDto request) {
        adminDao.createAdmin(request);
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

    @Override
    public void updateAdmin(AdminRequestDto request) {
        adminDao.updateAdmin(request);
    }

    @Override
    public void updatePwd(AdminRequestDto request) {
        adminDao.updatePwd(request);
    }

    @Override
    public void updateRole(int targetEmployeeId, AdminRequestDto request) {
        adminDao.updateRole(targetEmployeeId, request);

    }

    @Override
    public void delete(int targetEmployeeId) {
        adminDao.delete(targetEmployeeId);
    }
}
