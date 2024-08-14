package common;

public enum Menu {
    USER_TYPE("1. 쇼핑몰 | 2. 어드민\n"),
    USER_TYPE_SELECT("회원 유형 번호 입력 > "),

    MENU_SELECT("메뉴 선택 > "),
    ROLE_SELECT("권한 선택 > "),

    AUTH_MENU("1. 회원 가입 | 2. 로그인\n"),
    ADMIN_MENU("1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리\n5. 입고 관리 | 6. 출고 관리 | 7. 고객 센터 | 8. 로그아웃\n"),
    ADMIN_MEMBER_MENU("1. 조회 | 2. 수정 | 3. 권한 설정 | 4. 삭제\n"),
    ADMIN_MEMBER_VIEW_MENU("1. 직원 조회 | 2. 쇼핑몰 사업자 회원 조회\n"),
    ADMIN_MEMBER_VIEW_ADMIN_MENU("1. 직원 상세 조회 | 2. 직원 전체 조회 | 3. 권한별 직원 조회\n"),
    ADMIN_ROLE_MENU("1. 총 관리자 | 2. 창고 관리자 | 3. 일반\n"),
    ADMIN_MEMBER_VIEW_USER_MENU("1. 쇼핑몰 회원 상세 조회 | 2. 쇼핑몰 회원 전체 조회 | 3. 승인 대기자 조회\n"),
    ADMIN_MEMBER_EDIT_MENU("1. 회원 정보 수정 | 2. 쇼핑몰 사업자 정보 수정\n"),
    ADMIN_MEMBER_PERMISSION_MENU("1. 회원 권한 | 2. 쇼핑몰 사업자 권한 승인\n"),

    USER_MENU("1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리\n4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터\n7. 로그아웃\n"),

    ADMIN_ID ("사번을 입력해 주세요> "),

    BORDER_LINE("------------------------------------------------------------\n"),
    BOARD_SEPARATOR("############################################################\n");


    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getText() {
        return description;
    }
}
