package controller;

import dto.AdminRequestDto;
import handler.MemberInputHandler;
import common.Role;
import dto.AdminResponseDto;
import java.util.List;
import library.Script;
import security.Encrypt;
import common.ValidCheck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

public class AdminController {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static MemberInputHandler memberInputHandler = new MemberInputHandler();
    private static ValidCheck validCheck = new ValidCheck();
    private static Script script = new Script();
    private static AdminService adminService = new AdminServiceImpl();
    private static Encrypt encrypt = new Encrypt();


    /**
     * '회원 관리' 메뉴 선택
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
                setMemberRole();
                break;
            case "4":
                deleteMember();
        }
    }

    /**
     * '회원 관리 > 조회' 메뉴 선택
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
     * '회원 관리 > 조회 > 직원 조회' 메뉴 선택
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
                viewAdminByRole();
                break;
        }
    }

    /**
     * '회원 관리 > 조회 > 직원 조회 > 직원 상세 조회'
     */
    private void viewAdminDetail() throws IOException {
        script.viewAdminDetail();
        int id = validCheck.isNumber(br.readLine());
        AdminResponseDto response = adminService.findById(id);
        script.adminInfo(response);
    }

    /**
     * '회원 관리 > 조회 > 직원 조회 > 직원 전체 조회'
     */
    private void viewAllAdmin() {
        List<AdminResponseDto> list = adminService.findAll();
        list.forEach(l -> script.adminInfo(l));
    }

    /**
     * '회원 관리 > 조회 > 직원 조회 > 권한별 직원 조회' 메뉴 선택
     * 1. 총 관리자 | 2. 창고 관리자 | 3. 일반
     */
    private void viewAdminByRole() throws IOException {
        script.viewMemberRole();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To3(menu);
        String role = "";

        switch (menu) {
            case "1":
                role = Role.SUPER_ADMIN.toString();
                break;
            case "2":
                role = Role.ADMIN.toString();
                break;
            case "3":
                role = Role.EMPLOYEE.toString();
                break;
        }

        List<AdminResponseDto> list = adminService.findByRole(role);
        list.forEach(l -> script.adminInfo(l));
    }


    /**
     * '회원 관리 > 조회 > 쇼핑몰 사업자 회원 조회' 메뉴 선택
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
     * '회원 관리 > 수정' 메뉴 선택
     * 1. 회원 정보 수정 | 2. 비밀번호 수정  3. 쇼핑몰 사업자 정보 수정
     */
    private void editMember() throws IOException {
        script.editMember();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To3(menu);

        switch (menu) {
            case "1":
                editAdmin();
                break;
            case "2":
                editPwd();
                break;
            case "3":
                editUser();
                break;
        }
    }

    /**
     * '회원 관리 > 수정 > 회원 정보 수정'
     */
    private void editAdmin() throws IOException {
        adminService.updateAdmin(memberInputHandler.updateAdmin());
    }

    /**
     * '회원 관리 > 수정 > 비밀번호 수정'
     */
    private void editPwd() throws IOException {
        adminService.updatePwd(memberInputHandler.updateAdminPwd());
    }

    /**
     * '회원 관리 > 수정 > 쇼핑몰 사업자 정보 수정'
     */
    private void editUser() {

    }

    /**
     * '회원 관리 > 권한 설정' 메뉴 선택
     * 1. 회원 권한 | 2. 쇼핑몰 사업자 권한 승인
     */
    private void setMemberRole() throws IOException {
        script.setMemberPermission();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To2(menu);

        switch (menu) {
            case "1":
                setAdminRole();
                break;
            case "2":
                setUserRole();
                break;
        }
    }

    /**
     * '회원 관리 > 권한 설정' 권한 선택
     * 입력값: 사원 번호, 권한
     * 1. 총 관리자 | 2. 창고 관리자 | 3. 일반
     */
    private void setAdminRole() throws IOException {
        int targetEmployeeId = memberInputHandler.getUserIdInput();
        adminService.updateRole(targetEmployeeId, memberInputHandler.updateAdminRole());
    }

    private void setUserRole() {

    }

    /**
     * '회원 관리 > 삭제'
     */
    private void deleteMember() throws IOException {
        int targetEmployeeId = memberInputHandler.getUserIdInput();
        adminService.delete(targetEmployeeId);
    }
}
