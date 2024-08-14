package handler;

import common.Member;
import common.Role;
import common.ValidCheck;
import dto.AdminRequestDto;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;
import security.Encrypt;

public class MemberInputHandler {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Script script = new Script();
    private static ValidCheck validCheck = new ValidCheck();
    private static Encrypt encrypt = new Encrypt();

    public AdminRequestDto createAdmin() throws IOException {
        AdminRequestDto admin = new AdminRequestDto(getNameInput(), getIdInput(),
            getPwdInput(), getEmailInput(),
            getPhoneInput(), getZipCodeInput(),
            getAddressInput());
        return admin;
    }

    public AdminRequestDto updateAdmin() throws IOException {
        AdminRequestDto admin = new AdminRequestDto(getNameInput(), getIdInput(),
            getEmailInput(), getPhoneInput(), getZipCodeInput(), getAddressInput());
        return admin;
    }

    public AdminRequestDto updateAdminPwd() throws IOException {
        AdminRequestDto admin = new AdminRequestDto(getPwdInput());
        return admin;
    }

    public AdminRequestDto updateAdminRole() throws IOException {
        AdminRequestDto admin = new AdminRequestDto(getRoleInput());
        return admin;
    }

    public int getUserIdInput() throws IOException {
        int id = 0;
        try {
            script.viewAdminDetail();
            id = validCheck.isNumber(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getNameInput();
        }
        return id;
    }

    public String getNameInput() throws IOException {
        String name = "";
        try {
            System.out.print(Member.NAME.getText());
            name = validCheck.validateStringLength30(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getNameInput();
        }
        return name;
    }

    public String getIdInput() throws IOException {
        String id = "";
        try {
            System.out.print(Member.ID.getText());
            id = validCheck.validateId(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getIdInput();
        }
        return id;
    }

    public String getPwdInput() throws IOException {
        String pw = "";
        try {
            System.out.print(Member.PW.getText());
            pw = validCheck.validatePw(br.readLine());
            pw = encrypt.getEncrypt(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getPwdInput();
        }
        return pw;
    }

    public String getEmailInput() throws IOException {
        String email = "";
        try {
            System.out.print(Member.EMAIL.getText());
            email = validCheck.validateEmail(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getEmailInput();
        }
        return email;
    }

    public Role getRoleInput() throws IOException {
        Role role = null;
        try {
            script.getRole();
            String menu = br.readLine().trim();
            validCheck.validateMenuNumber1To3(menu);

            switch (menu) {
                case "1":
                    role = Role.valueOf("SUPER_ADMIN");
                    break;
                case "2":
                    role = Role.valueOf("ADMIN");
                    break;
                case "3":
                    role = Role.valueOf("EMPLOYEE");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getPhoneInput();
        }
        return role;
    }

    public String getPhoneInput() throws IOException {
        String phone = "";
        try {
            System.out.print(Member.PHONE.getText());
            phone = validCheck.validatePhone(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getPhoneInput();
        }
        return phone;
    }

    public String getZipCodeInput() throws IOException {
        String zipCode = "";
        try {
            System.out.print(Member.ZIP_CODE.getText());
            zipCode = validCheck.validateStringLength10(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getZipCodeInput();
        }
        return zipCode;
    }

    public String getAddressInput() throws IOException {
        String address = "";
        try {
            System.out.print(Member.ADDRESS.getText());
            address = br.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getAddressInput();
        }
        return address;
    }
}
