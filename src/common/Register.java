package common;

public enum Register {
    NAME("이름 *: "),
    ID("아이디 *: "),
    PW("비밀번호 *: "),
    EMAIL("이메일 *: "),
    PHONE("전화번호 *: "),
    ZIP_CODE("우편 번호 *: "),
    ADDRESS("주소 *: ");


    private final String description;

    Register(String description) {
        this.description = description;
    }

    public String getText() {
        return description;
    }
}
