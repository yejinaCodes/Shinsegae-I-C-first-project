package common;

public enum Member {
    ADMIN_ID("사번: "),
    USER_ID("회원 번호: "),
    NAME("이름: "),
    BUSINESS_NUMBER("사업자 번호: "),
    COMPANY_NAME("상호명: "),
    REPRESENTATIVE("사업자 대표명: "),
    ID("아이디: "),
    PW("비밀번호: "),
    EMAIL("이메일: "),
    ADMIN_COMPANY_EMAIL("회사 이메일: "),
    USER_COMPANY_EMAIL("사업장 이메일: "),
    DEPARTMENT("부서: "),
    POSITION("직급: "),
    ROLE("권한: "),
    PHONE("전화번호: "),
    COMPANY_PHONE("사업장 전화번호: "),
    FAX("팩스 번호: "),
    ZIP_CODE("우편 번호: "),
    COMPANY_ZIP_CODE("사업장 우편 번호: "),
    ADDRESS("주소: "),
    COMPANY_ADDRESS("사업장 주소: "),
    IS_UNREGISTER("탈퇴 여부"),
    CREATED_AT("최초 등록 시각: "),
    AUTHORIZER_ID("최종 수정자 ID: "),
    UPDATED_AT("최종 수정 시각: "),
    UPDATED_ADMIN_ID("최종 수정자(직원) ID: "),
    UPDATED_ADMIN_AT("최종 수정(직원) 시각: "),
    UNREGISTERED_AT("탈퇴 시각: ");


    private final String description;

    Member(String description) {
        this.description = description;
    }

    public String getText() {
        return description;
    }
}
