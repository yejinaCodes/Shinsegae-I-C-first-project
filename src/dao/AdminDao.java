package dao;

import dto.request.AdminRequestDto;
import dto.response.AdminResponseDto;
import dto.response.AuthResponseDto;
import java.util.List;

public interface AdminDao {
    void createAdmin(AdminRequestDto request);

    AdminResponseDto findById(int id);

    List<AdminResponseDto> findAll();

    List<AdminResponseDto> findByRole(String role);

    String findAdminId(int id);

    AuthResponseDto findAuth(String userId);

    void updateAdmin(AdminRequestDto request);

    void updatePwd(String adminId, AdminRequestDto request);

    void updateRole(int targetEmployeeId, AdminRequestDto request);

    void updateAdminDeptPos(int targetEmployeeId, AdminRequestDto request);

    void deleteAdmin(int targetEmployeeId);
}
