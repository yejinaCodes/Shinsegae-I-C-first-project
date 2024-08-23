package dto;

import lombok.Generated;

public class AdminDto {
    private int id;
    private String name;
    private String adminId;
    private String password;
    private String companyEmail;
    private String department = "DELIVERY";
    private String position = "ADMIN";
    private String phone;
    private String createdAt;
    private int authorizerId;
    private String updatedAt;

    public AdminDto(int id) {
        this.id = id;
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getAdminId() {
        return this.adminId;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public String getCompanyEmail() {
        return this.companyEmail;
    }

    @Generated
    public String getDepartment() {
        return this.department;
    }

    @Generated
    public String getPosition() {
        return this.position;
    }

    @Generated
    public String getPhone() {
        return this.phone;
    }

    @Generated
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Generated
    public int getAuthorizerId() {
        return this.authorizerId;
    }

    @Generated
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    @Generated
    public AdminDto() {
    }

    @Generated
    public AdminDto(int id, String name, String adminId, String password, String companyEmail, String department, String position, String phone, String createdAt, int authorizerId, String updatedAt) {
        this.id = id;
        this.name = name;
        this.adminId = adminId;
        this.password = password;
        this.companyEmail = companyEmail;
        this.department = department;
        this.position = position;
        this.phone = phone;
        this.createdAt = createdAt;
        this.authorizerId = authorizerId;
        this.updatedAt = updatedAt;
    }
}
