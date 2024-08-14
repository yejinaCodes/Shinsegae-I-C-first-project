package dao;

import dto.AdminDto;
import dto.AdminResponseDto;
import java.util.List;

public interface AdminDao {
    void createAdmin(AdminDto admin);

    AdminResponseDto findById(int id);

    List<AdminResponseDto> findAll();

    List<AdminResponseDto> findByRole(String role);
}
