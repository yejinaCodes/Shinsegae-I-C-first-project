package service;

import dto.AdminDto;
import dto.AdminResponseDto;
import java.util.List;

public interface AdminService {
    void createAdmin(AdminDto adminDto);

    AdminResponseDto findById(int id);

    List<AdminResponseDto> findAll();

    List<AdminResponseDto> findByRole(String role);
}
