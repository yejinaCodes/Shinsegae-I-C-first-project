package dto.request;

import common.Department;
import common.Position;
import common.Role;
import library.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminRequestDto {
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

    public AdminRequestDto(String name, String adminId, String password, String email, String phone, String zipCode, String address) {
        this.name = name;
        this.adminId = adminId;
        this.password = password;
        this.email = email;
        this.companyEmail = adminId + "@clap.co.kr";
        this.phone = phone;
        this.zipCode = zipCode;
        this.address = address;
        this.createdAt = LocalDateTime.getTime();
    }

    public AdminRequestDto(String name, String adminId, String email, String phone, String zipCode, String address) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.name = name;
        this.adminId = adminId;
        this.email = email;
        this.companyEmail = adminId + "@clap.co.kr";
        this.phone = phone;
        this.zipCode = zipCode;
        this.address = address;
        this.updatedAt = LocalDateTime.getTime();
    }

    public AdminRequestDto(String password) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.password = password;
        this.updatedAt = LocalDateTime.getTime();
    }

    public AdminRequestDto(Role role) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.role = role;
        this.updatedAt = LocalDateTime.getTime();
    }
}

