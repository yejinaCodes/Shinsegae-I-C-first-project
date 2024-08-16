package service;

import dto.request.AdminRequestDto;
import dto.response.AdminResponseDto;
import java.util.List;

public interface AdminService {
    void createAdmin(AdminRequestDto request);

    AdminResponseDto findById(int id);

    List<AdminResponseDto> findAll();

    List<AdminResponseDto> findByRole(String role);

    void updateAdmin(AdminRequestDto request);

    void updatePwd(AdminRequestDto request);

    void updateRole(int targetEmployeeId, AdminRequestDto request);
    void updateAdminDeptPos(int targetEmployeeId, AdminRequestDto request);

    void deleteAdmin(int targetEmployeeId);
}
