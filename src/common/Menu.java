package common;

public enum Menu {
    USER_TYPE("[회원 유형]\n1. 쇼핑몰 | 2. 어드민"),
    USER_TYPE_SELECT("회원 유형 번호 입력: "),
    AUTH_MENU("1. 회원 가입 | 2. 로그인"),
    ADMIN_MENU("1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리\n5. 입고 관리 | 6. 출고 관리  7. 고객 센터 | 8. 로그아웃"),
    USER_MENU("1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리\n4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터\n7. 로그아웃"),
    MENU_SELECT("메뉴 선택: "),
    BORDER_LINE("------------------------------------------------------------"),
    BOARD_SEPARATOR("############################################################");


    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getText() {
        return description;
    }
}
