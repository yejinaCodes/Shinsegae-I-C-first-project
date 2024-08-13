package dto;

import common.Department;
import common.Position;
import common.Role;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private int id;
    private String name;
    private String adminId;
    private String password;
    private String email;
    private String companyEmail;
    private Department department;
    private Position position;
    private Role role;
    private String phone;
    private String zipCode;
    private String address;
    private String createdAt;
    private int authorizerId;
    private String updatedAt;

    public AdminDto(String name, String adminId, String password, String email, String phone, String zipCode, String address) {
        this.name = name;
        this.adminId = adminId;
        this.password = password;
        this.email = email;
        this.companyEmail = adminId + "@clap.co.kr";
        this.phone = phone;
        this.zipCode = zipCode;
        this.address = address;
        this.createdAt = getTime();
    }

    private String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}

