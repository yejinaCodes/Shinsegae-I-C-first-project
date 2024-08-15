package dto.request;

import library.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    private int id;
    private String name;
    private String businessNumber;
    private String companyName;
    private String userId;
    private String password;
    private String email;
    private String phone;
    private String zipCode;
    private String address;
    private int isUnregister;
    private String createdAt;
    private String updatedAt;
    private int updatedAdminId;
    private String updatedAdminAt;
    private String unregisteredAt;

    /**
     * 회원 가입
     */
    public UserRequestDto(String name, String businessNumber, String companyName,
        String userId, String password, String email, String phone, String zipCode,
        String address) {
        this.name = name;
        this.businessNumber = businessNumber;
        this.companyName = companyName;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.address = address;
        this.createdAt = LocalDateTime.getTime();
    }
}