package handler;

import common.Member;
import common.Role;
import common.ValidCheck;
import dto.request.AdminRequestDto;
import dto.request.UserRequestDto;
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
        AdminRequestDto admin = new AdminRequestDto(getNameInput(), getIdInput(), getPwdInput(), getPhoneInput());
        return admin;
    }

    public AdminRequestDto updateAdmin() throws IOException {
        AdminRequestDto admin = new AdminRequestDto(getNameInput(), getIdInput(), getPhoneInput());
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

    public UserRequestDto createUser() throws IOException {
        UserRequestDto user = new UserRequestDto(getNameInput(), getBusinessNumberInput(), getCompanyNameInput(),
            getIdInput(), getPwdInput(), getEmailInput(), getPhoneInput(), getZipCodeInput(), getAddressInput());
        return user;
    }

    public UserRequestDto updateUser() throws IOException {
        UserRequestDto user = new UserRequestDto(getNameInput(), getBusinessNumberInput(), getCompanyNameInput(),
            getIdInput(), getEmailInput(), getPhoneInput(), getZipCodeInput(), getAddressInput());
        return user;
    }

    public UserRequestDto updateUserPwd() throws IOException {
        UserRequestDto user = new UserRequestDto(getPwdInput());
        return user;
    }

    public int getUserIdInput() throws IOException {
        try {
            script.viewAdminDetail();
            return validCheck.isNumber(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getUserIdInput();
        }
    }

    public String getNameInput() throws IOException {
        try {
            System.out.print(Member.NAME.getText());
            return validCheck.validateStringLength30(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getNameInput();
        }
    }

    public String getBusinessNumberInput() throws IOException {
        try {
            System.out.print(Member.BUSINESS_NUMBER.getText());
            return validCheck.validateStringLength30(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getBusinessNumberInput();
        }
    }

    public String getCompanyNameInput() throws IOException {
        try {
            System.out.print(Member.COMPANY_NAME.getText());
            return validCheck.validateStringLength50(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCompanyNameInput();
        }
    }

    public String getIdInput() throws IOException {
        try {
            System.out.print(Member.ID.getText());
            return validCheck.validateId(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getIdInput();
        }
    }

    public String getPwdInput() throws IOException {
        try {
            System.out.print(Member.PW.getText());
            return encrypt.getEncrypt(validCheck.validatePw(br.readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPwdInput();
        }
    }

    public String getEmailInput() throws IOException {
        try {
            System.out.print(Member.EMAIL.getText());
            return validCheck.validateEmail(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getEmailInput();
        }
    }

    public Role getRoleInput() throws IOException {
        try {
            Role role = null;

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
            return role;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRoleInput();
        }
    }

    public String getPhoneInput() throws IOException {
        try {
            System.out.print(Member.PHONE.getText());
            return validCheck.validatePhone(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPhoneInput();
        }
    }

    public String getZipCodeInput() throws IOException {
        try {
            System.out.print(Member.ZIP_CODE.getText());
            return validCheck.validateStringLength10(br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getZipCodeInput();
        }
    }

    public String getAddressInput() throws IOException {
        try {
            System.out.print(Member.ADDRESS.getText());
            return br.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getAddressInput();
        }
    }
}
