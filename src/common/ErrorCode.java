package common;

public enum ErrorCode {
    NULL_VALUE(404, "입력값이 비어 있습니다. 공백이 아닌 실제 값을 입력해 주세요."),
    INVALID_MENU_OPTION(404, "유효하지 않은 메뉴 번호입니다. 올바른 번호를 입력해 주세요"),
    INVALID_NUMBER(404, "숫자를 입력해 주세요."),
    INVALID_LENGTH_10(404, "입력 길이는 10자 이하이어야 합니다."),
    INVALID_LENGTH_30(404, "입력 길이는 30자 이하이어야 합니다."),
    INVALID_ID(404, "유효하지 않은 ID입니다.\nID는 5자 이상 15자 이하의 영문과 숫자로만 이루어져야 합니다."),
    INVALID_PASSWORD(404, "유효하지 않은 비밀번호입니다.\n비밀번호는 8자 이상 20자 이하로 영문자, 숫자, 특수문자(.!@#$%^)만 포함되어야 합니다."),
    INVALID_EMAIL(404, "유효하지 않은 이메일 주소입니다. 올바른 형식으로 입력해 주세요."),
    INVALID_PHONE(404, "유효하지 않은 전화번호입니다. 올바른 형식으로 입력해 주세요.\n 예시> 01012345678");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
