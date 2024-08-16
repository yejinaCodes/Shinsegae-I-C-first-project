package library;

import common.Member;
import common.Menu;
import dto.response.AdminResponseDto;
import dto.response.UserApprovalResponseDto;
import dto.response.UserResponseDto;

public class Script {

    private static StringBuilder script = new StringBuilder();

    private void print() {
        System.out.println(script);
        script.delete(0, script.length());
    }

    /**
     * 서비스 이용자의 타입 받기
     * 1. 쇼핑몰 | 2. 어드민
     */
    public void selectUserType() {
        script.append(Menu.BOARD_SEPARATOR.getDescription())
            .append(Menu.USER_TYPE.getDescription())
            .append(Menu.USER_TYPE_SELECT.getDescription());
        print();
    }

    /**
     * 메뉴 선택
     * 1. 회원 가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기
     */
    public void selectLoginOrRegister() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.AUTH_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * 회원(쇼핑몰) 페이지 메뉴 선택
     * 1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리
     * 4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터
     * 7. 로그아웃
     */
    public void userMainMenu() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.USER_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * 어드민 페이지 메뉴 선택
     * 1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리
     * 5. 입고 관리 | 6. 출고 관리 | 7. 고객 센터 | 8. 로그아웃
     */
    public void adminMainMenu() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리' 메뉴 선택
     * 1. 조회 | 2. 수정 | 3. 권한 설정 | 4. 삭제
     */
    public void manageMember() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 조회' 메뉴 선택
     * 1. 직원 조회 | 2. 쇼핑몰 사업자 회원 조회
     */
    public void viewMember() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_VIEW_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 조회 > 직원 조회' 메뉴 선택
     * 1. 직원 상세 조회 | 2. 직원 전체 조회 | 3. 권한별 직원 조회
     */
    public void viewAdmin() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_VIEW_ADMIN_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 조회 > 직원 조회 > 3. 권한별 직원 조회'
     */
    public void viewMemberRole() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_ROLE_MENU.getDescription())
            .append(Menu.ROLE_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 조회 > 쇼핑몰 사업자 회원 조회' 메뉴 선택
     * 1. 쇼핑몰 회원 상세 조회 | 2. 쇼핑몰 회원 전체 조회 | 3. 승인 대기자 조회
     */
    public void viewUser() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_VIEW_USER_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 수정' 메뉴 선택
     * 1. 회원 정보 수정 | 2. 비밀번호 수정
     */
    public void editMember() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_EDIT_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 권한 설정' 메뉴 선택
     * 1. 직원 권한 | 2. 직원 부서 및 직급 | 3. 쇼핑몰 사업자 권한 승인
     */
    public void setMemberPermission() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_MEMBER_PERMISSION_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리 > 삭제' 메뉴 선택
     * 1. 직원 삭제 | 2. 쇼핑몰 사업자 회원 삭제
     */
    public void deleteMember() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_DELETE_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * '회원 관리' 메뉴 선택
     * 1. 정보 조회 | 2. 정보 수정 | 3. 비밀번호 변경 | 4. 탈퇴
     */
    public void manageUser() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.USER_MEMBER_MENU.getDescription())
            .append(Menu.MENU_SELECT.getDescription());
        print();
    }

    /**
     * 진행 확인
     */
    public void confirm() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.CONFIRM.getDescription());
        print();
    }

    /**
     * 사원 번호 입력 받기
     */
    public void getAdminId() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_ID_INPUT.getDescription());
        print();
    }

    /**
     * 회원 ID 입력 받기
     */
    public void getUserId() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.USER_ID_INPUT.getDescription());
        print();
    }

    /**
     * 사업자 번호 입력 받기
     */
    public void getBizNo() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.BIZ_NO_INPUT.getDescription());
        print();
    }

    /**
     * 부서 입력 받기
     */
    public void getDepartment() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_DEPARTMENT_MENU.getDescription())
            .append(Menu.ROLE_SELECT.getDescription());
        print();
    }

    /**
     * 직급 입력 받기
     */
    public void getPosition() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_POSITION_MENU.getDescription())
            .append(Menu.ROLE_SELECT.getDescription());
        print();
    }

    /**
     * 권한 입력 받기
     */
    public void getRole() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.ADMIN_ROLE_MENU.getDescription())
            .append(Menu.ROLE_SELECT.getDescription());
        print();
    }

    /**
     * 승인 상태 입력 받기
     */
    public void getStatus() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.STATUS_MENU.getDescription())
            .append(Menu.STATUS_SELECT.getDescription());
        print();
    }

    /**
     * 승인 거절 이유 입력 받기
     */
    public void getRejectionReason() {
        script.append(Menu.BORDER_LINE.getDescription())
            .append(Menu.REJECTION_REASON_INPUT.getDescription());
        print();
    }

    /**
     * 직원 상세 내역 조회
     */
    public void adminInfo(AdminResponseDto response) {
        script.append(Menu.BORDER_LINE.getDescription()).append("\n")
            .append(Member.ADMIN_ID.getText()).append(response.getId()).append("\n")
            .append(Member.NAME.getText()).append(response.getName()).append("\n")
            .append(Member.ID.getText()).append(response.getAdminId()).append("\n")
            .append(Member.ADMIN_COMPANY_EMAIL.getText()).append(response.getCompanyEmail()).append("\n")
            .append(Member.DEPARTMENT.getText()).append(response.getDepartment()).append("\n")
            .append(Member.POSITION.getText()).append(response.getPosition()).append("\n")
            .append(Member.ROLE.getText()).append(response.getRole()).append("\n")
            .append(Member.PHONE.getText()).append(response.getPhone()).append("\n")
            .append(Member.CREATED_AT.getText()).append(response.getCreatedAt()).append("\n")
            .append(Member.AUTHORIZER_ID.getText()).append(response.getAuthorizerId()).append("\n")
            .append(Member.UPDATED_AT.getText()).append(response.getUpdatedAt()).append("\n");
        print();
    }

    /**
     * 쇼핑몰 유저 상세 내역 조회
     */
    public void userInfo(UserResponseDto response) {
        script.append(Menu.BORDER_LINE.getDescription()).append("\n")
            .append(Member.USER_ID.getText()).append(response.getId()).append("\n")
            .append(Member.NAME.getText()).append(response.getName()).append("\n")
            .append(Member.BUSINESS_NUMBER.getText()).append(response.getBusinessNumber()).append("\n")
            .append(Member.COMPANY_NAME.getText()).append(response.getCompanyName()).append("\n")
            .append(Member.ID.getText()).append(response.getUserId()).append("\n")
            .append(Member.EMAIL.getText()).append(response.getEmail()).append("\n")
            .append(Member.PHONE.getText()).append(response.getPhone()).append("\n")
            .append(Member.ZIP_CODE.getText()).append(response.getZipCode()).append("\n")
            .append(Member.ADDRESS.getText()).append(response.getAddress()).append("\n")
            .append(Member.IS_UNREGISTER.getText()).append(response.getIsUnregister()).append("\n")
            .append(Member.CREATED_AT.getText()).append(response.getCreatedAt()).append("\n")
            .append(Member.UPDATED_AT.getText()).append(response.getUpdatedAt()).append("\n")
            .append(Member.UPDATED_ADMIN_ID.getText()).append(response.getUpdatedAdminId()).append("\n")
            .append(Member.UPDATED_ADMIN_AT.getText()).append(response.getUpdatedAdminAt()).append("\n")
            .append(Member.UNREGISTERED_AT.getText()).append(response.getUnregisteredAt()).append("\n");
        print();
    }

    /**
     * 쇼핑몰 유저 상세 내역 조회
     */
    public void approvalUser(UserApprovalResponseDto response) {
        script.append(Menu.BORDER_LINE.getDescription()).append("\n")
            .append(Member.USER_ID.getText()).append(response.getUserId()).append("\n")
            .append(Member.BUSINESS_NUMBER.getText()).append(response.getBusinessNumber()).append("\n")
            .append(Member.COMPANY_NAME.getText()).append(response.getCompanyName()).append("\n")
            .append(Member.CREATED_AT.getText()).append(response.getCreatedAt()).append("\n")
            .append(Member.APPROVAL_STATUS.getText()).append(response.getApprovalStatus()).append("\n");
        print();
    }

    /**
     * 쇼핑몰 유저 아이디 찾기 조회
     */
    public void userId(String response) {
        script.append(Menu.BORDER_LINE.getDescription()).append("\n")
            .append(Member.ID.getText()).append(response).append("\n");
        print();
    }
}
