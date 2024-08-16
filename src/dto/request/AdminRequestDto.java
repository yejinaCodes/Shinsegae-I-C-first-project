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
    private String salt;
    private String companyEmail;
    private Department department;
    private Position position;
    private Role role;
    private String phone;
    private String createdAt;
    private int authorizerId;
    private String updatedAt;

    /**
     * 회원 가입
     */
    public AdminRequestDto(String name, String adminId, String salt, String password, String phone) {
        this.name = name;
        this.adminId = adminId;
        this.salt = salt;
        this.password = password;
        this.companyEmail = adminId + "@clap.co.kr";
        this.phone = phone;
        this.createdAt = LocalDateTime.getTime();
    }

    /**
     * 정보 수정
     */
    public AdminRequestDto(String name, String adminId, String phone) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.name = name;
        this.adminId = adminId;
        this.companyEmail = adminId + "@clap.co.kr";
        this.phone = phone;
        this.updatedAt = LocalDateTime.getTime();
    }

    /**
     * 비밀번호 수정
     */
    public AdminRequestDto(String salt, String password) {
        this.salt = salt;
        this.password = password;
        this.updatedAt = LocalDateTime.getTime();
    }

    /**
     * 권한 수정
     */
    public AdminRequestDto(Role role) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.role = role;
        this.updatedAt = LocalDateTime.getTime();
    }

    /**
     * 부서 및 직급 수정
     */
    public AdminRequestDto(Department department, Position position) {
        // 🚨 로그인 유저 id로 변경 예정
        this.id = 1;
        this.department = department;
        this.position = position;
        this.updatedAt = LocalDateTime.getTime();
    }
}

