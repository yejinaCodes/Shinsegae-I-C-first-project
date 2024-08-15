package common;

public enum Menu {
    USER_TYPE("1. 쇼핑몰 | 2. 어드민\n"),
    USER_TYPE_SELECT("회원 유형 번호 입력 > "),

    MENU_SELECT("메뉴 선택 > "),
    ROLE_SELECT("권한 선택 > "),

    AUTH_MENU("1. 회원 가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기\n"),
    ADMIN_MENU("[메뉴]\n1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리\n5. 입고 관리 | 6. 출고 관리 | 7. 고객 센터 | 8. 로그아웃\n"),
    ADMIN_MEMBER_MENU("[회원 관리]\n1. 조회 | 2. 수정 | 3. 권한 설정 | 4. 삭제\n"),
    ADMIN_MEMBER_VIEW_MENU("[회원 관리 > 조회]\n1. 직원 조회 | 2. 쇼핑몰 사업자 회원 조회\n"),
    ADMIN_MEMBER_VIEW_ADMIN_MENU("[회원 관리 > 조회 > 직원 조회]\n1. 직원 상세 조회 | 2. 직원 전체 조회 | 3. 권한별 직원 조회\n"),
    ADMIN_ROLE_MENU("[직원 권한]\n1. 총 관리자 | 2. 창고 관리자 | 3. 일반\n"),
    ADMIN_MEMBER_VIEW_USER_MENU("[회원 관리 > 조회 > 쇼핑몰 사업자 회원 조회]\n1. 쇼핑몰 회원 상세 조회 | 2. 쇼핑몰 회원 전체 조회 | 3. 승인 대기자 조회\n"),
    ADMIN_MEMBER_EDIT_MENU("[회원 관리 > 수정]\n1. 회원 정보 수정 | 2. 비밀번호 수정\n"),
    ADMIN_MEMBER_PERMISSION_MENU("[회원 관리 > 권한 설정]\n1. 직원 권한 | 2. 쇼핑몰 사업자 권한 승인\n"),
    ADMIN_DELETE_MENU("[회원 관리 > 삭제]\n1. 직원 삭제 | 2. 쇼핑몰 사업자 회원 삭제\n"),
    USER_MENU("[메뉴]\n1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리\n4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터\n7. 로그아웃\n"),
    USER_MEMBER_MENU("[회원 관리]\n1. 정보 조회 | 2. 정보 수정 | 3. 비밀번호 변경 | 4. 탈퇴\n"),

    ADMIN_ID_INPUT ("사번을 입력해 주세요 > "),
    USER_ID_INPUT ("회원 번호를 입력해 주세요 > "),
    CONFIRM("계속 진행하시겠습니까?\n1. 예 | 2. 아니요"),

    BORDER_LINE("------------------------------------------------------------\n"),
    BOARD_SEPARATOR("############################################################\n");


    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
