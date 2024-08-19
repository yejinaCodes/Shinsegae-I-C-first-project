package common;

public enum ResponseMessage{

    LOGIN_SUCCESS("\n로그인 성공 🙂\n"),
    LOGIN_FAILURE("\n🚨로그인 실패🚨\n"),
    LOGOUT("\n로그아웃 되었습니다. 👋\n");


    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
