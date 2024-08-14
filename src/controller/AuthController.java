package controller;

import common.ErrorCode;
import common.Member;
import common.ValidCheck;
import dto.AdminDto;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;
import security.Encrypt;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

public class AuthController {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static Script script = new Script();
    private static AdminService adminService = new AdminServiceImpl();
    private static Encrypt encrypt = new Encrypt();

    /**
     * [유저]
     * 메뉴 선택
     * 1. 회원 가입 | 2. 로그인
     * @param userType (1. 쇼핑몰, 2. 어드민)
     */
    public void handleAuth(String userType) throws IOException {
        try {
            script.selectLoginOrRegister();
            String menu = br.readLine().trim();
            validCheck.validateMenuNumber1To2(menu);

            switch (userType) {
                case "1":
                    switch (menu) {
                        case "1":
    //                        registerUser();
                            break;
                        case "2":
                            break;
                    }
                    break;
                case "2":
                    switch (menu) {
                        case "1":
                            registerAdmin();
                            break;
                        case "2":
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            handleAuth(userType);
        }
    }


    /**
     * 유저 회원 가입
     */
    /*private void registerUser() throws IOException {
        try {

        } catch (NullPointerException e) {
            System.out.println(ErrorCode.NULL_VALUE.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/


    /**
     * 어드민 회원 가입
     */
    private void registerAdmin() {
        try {

            AdminDto admin = new AdminDto(getNameInput(), getIdInput(), getPwdInput(), getEmailInput(), getPhoneInput(), getZipCodeInput(), getAddressInput());

            adminService.createAdmin(admin);
        } catch (IOException e) {
            System.out.println(ErrorCode.INVALID_VALUE.getMessage());
        }
    }

    private String getNameInput() throws IOException {
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

    private String getIdInput() throws IOException {
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

    private String getPwdInput() throws IOException {
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

    private String getEmailInput() throws IOException {
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

    private String getPhoneInput() throws IOException {
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

    private String getZipCodeInput() throws IOException {
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

    private String getAddressInput() throws IOException {
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