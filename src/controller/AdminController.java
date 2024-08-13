package controller;

import common.Menu;
import security.Encrypt;
import common.ErrorCode;
import common.Register;
import common.ValidCheck;
import dto.AdminDto;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

public class AdminController {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static AdminService adminService = new AdminServiceImpl();
    private static Encrypt encrypt = new Encrypt();


    /**
     * 메뉴 선택
     * 1. 회원 가입 | 2. 로그인
     */
    public void selectLoginOrRegister() throws IOException {
        System.out.println(Menu.BORDER_LINE.getText());
        System.out.println(Menu.AUTH_MENU.getText());
        System.out.print(Menu.MENU_SELECT.getText());
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                createAdmin();
        }
    }


    /**
     * 회원 가입
     */
    private void createAdmin() throws IOException {
        try {
            System.out.print(Register.NAME.getText());
            String name = validCheck.validateStringLength30(br.readLine());
            System.out.print(Register.ID.getText());
            String id = validCheck.validateId(br.readLine());
            System.out.print(Register.PW.getText());
            String pw = validCheck.validatePw(br.readLine());
            pw = encrypt.getEncrypt(pw);
            System.out.print(Register.EMAIL.getText());
            String email = validCheck.validateEmail(br.readLine());
            System.out.print(Register.PHONE.getText());
            String phone = validCheck.validatePhone(br.readLine());
            System.out.print(Register.ZIP_CODE.getText());
            String zipCode = validCheck.validateStringLength10(br.readLine());
            System.out.print(Register.ADDRESS.getText());
            String address = br.readLine();

            AdminDto admin = new AdminDto(name, id, pw, email, phone, zipCode, address);

            adminService.createAdmin(admin);
        } catch (NullPointerException e) {
            System.out.println(ErrorCode.NULL_VALUE.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
