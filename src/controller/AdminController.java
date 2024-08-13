package controller;

import common.Menu;
import library.Script;
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
    private static Script script = new Script();
    private static AdminService adminService = new AdminServiceImpl();
    private static Encrypt encrypt = new Encrypt();


    /**
     * 메뉴 선택
     * 1. 회원 가입 | 2. 로그인
     */
    public void selectLoginOrRegister() throws IOException {
        script.selectLoginOrRegister();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                register();
        }
    }


    /**
     * 회원 가입
     */
    private void register() throws IOException {
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

    /**
     * 회원 관리 메뉴 선택
     * 1. 조회 | 2. 수정 | 3. 권한 설정 | 4. 삭제
     */
    public void manageMember() throws IOException {
        script.manageMember();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To4(menu);

        switch (menu) {
            case "1":
                viewMember();
                break;
            case "2":
                editMember();
                break;
            case "3":
                setMemberPermission();
                break;
            case "4":
                deleteMember();
        }
    }

    /**
     * 회원 관리 > 조회 메뉴 선택
     * 1. 직원 조회 | 2. 쇼핑몰 사업자 회원 조회
     */
    private void viewMember() throws IOException{
        script.viewMember();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                viewAdmin();
                break;
            case "2":
                viewUser();
                break;
        }

    }

    /**
     * 회원 관리 > 조회 > 직원 조회 메뉴 선택
     * 1. 직원 상세 조회 | 2. 직원 전체 조회 | 3. 권한별 직원 조회
     */
    private void viewAdmin() throws IOException{
        script.viewAdmin();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To3(menu);

        switch (menu) {
            case "1":
                viewAdminDetail();
                break;
            case "2":
                viewAllAdmin();
                break;
            case "3":
                viewAdminByPermission();
                break;
        }
    }

    private void viewAdminDetail() throws IOException {
        System.out.println(Menu.BORDER_LINE.getText());
        System.out.print(Menu.ADMIN_ID.getText());
        int id = validCheck.isNumber(br.readLine());


    }

    private void viewAllAdmin() {

    }

    private void viewAdminByPermission() {

    }


    /**
     * 회원 관리 > 조회 > 쇼핑몰 사업자 회원 조회 메뉴 선택
     * 1. 쇼핑몰 회원 상세 조회 | 2. 쇼핑몰 회원 전체 조회 | 3. 승인 대기자 조회
     */
    private void viewUser() throws IOException {
        script.viewUser();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To3(menu);

        switch (menu) {
            case "1":
                viewUserDetail();
                break;
            case "2":
                viewAllUser();
                break;
            case "3":
                viewPendingApproval();
                break;
        }
    }

    private void viewUserDetail() {

    }

    private void viewAllUser() {

    }

    private void viewPendingApproval() {

    }

    /**
     * 회원 관리 > 수정 메뉴 선택
     * 1. 회원 정보 수정 | 2. 쇼핑몰 사업자 정보 수정
     */
    private void editMember() throws IOException {
        script.editMember();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                editAdmin();
                break;
            case "2":
                editUser();
                break;
        }
    }

    private void editAdmin() {

    }

    private void editUser() {

    }

    /**
     * 회원 관리 > 권한 설정 메뉴 선택
     * 1. 회원 권한 | 2. 쇼핑몰 사업자 권한 승인
     */
    private void setMemberPermission() throws IOException {
        script.setMemberPermission();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                setAdminPermission();
                break;
            case "2":
                setUserPermission();
                break;
        }
    }

    private void setAdminPermission() {

    }

    private void setUserPermission() {

    }

    /**
     * 회원 관리 > 삭제
     */
    private void deleteMember() {

    }
}
