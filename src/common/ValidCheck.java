package common;

import exception.Exception;

public class ValidCheck {
    private static final String ID = "^[a-zA-Z0-9]{5,15}$";
    private static final String PASSWORD = "^[a-zA-Z0-9.!@#$%^]{8,20}$";
    private static final String EMAIL = "^(?=.{1,100}$)[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE = "^\\d{10,11}$";
    private static final String NUMBER = "^\\d+$";
    private static final String MENU_RANGE_1_TO_2 = "^[1-2]";
    private static final String MENU_RANGE_1_TO_3 = "^[1-3]";
    private static final String MENU_RANGE_1_TO_4 = "^[1-4]";
    private static final String MENU_RANGE_1_TO_7 = "^[1-7]";
    private static final String MENU_RANGE_1_TO_8 = "^[1-8]";

    /**
     * 공백 입력 값 검사
     * @param input
     */
    public void isNull(String input) {
        if (input.isEmpty()) {
            throw new Exception(ErrorCode.NULL_VALUE);
        }
    }

    /**
     * 숫자 유효성 검사
     * @param number
     */
    public int isNumber(String number) {
        if (!(number.matches(NUMBER))) {
            throw new Exception(ErrorCode.INVALID_NUMBER);
        }
        return Integer.parseInt(number);
    }

    /**
     * 메뉴 번호 유효성 검사
     * @param menu 메뉴 번호 (1 ~ 2)
     */
    public void validateMenuNumber1To2(String menu) {
        isNumber(menu);

        if (!(menu.matches(MENU_RANGE_1_TO_2))) {
            throw new Exception(ErrorCode.INVALID_MENU_OPTION);
        }
    }

    /**
     * 메뉴 번호 유효성 검사
     * @param menu 메뉴 번호 (1 ~ 3)
     */
    public void validateMenuNumber1To3(String menu) {
        isNumber(menu);

        if (!(menu.matches(MENU_RANGE_1_TO_3))) {
            throw new Exception(ErrorCode.INVALID_MENU_OPTION);
        }
    }

    /**
     * 메뉴 번호 유효성 검사
     * @param menu 메뉴 번호 (1 ~ 4)
     */
    public void validateMenuNumber1To4(String menu) {
        isNumber(menu);

        if (!(menu.matches(MENU_RANGE_1_TO_4))) {
            throw new Exception(ErrorCode.INVALID_MENU_OPTION);
        }
    }

    /**
     * 메뉴 번호 유효성 검사
     * @param menu 메뉴 번호 (1 ~ 7)
     */
    public void validateMenuNumber1To7(String menu) {
        isNumber(menu);

        if (!(menu.matches(MENU_RANGE_1_TO_7))) {
            throw new Exception(ErrorCode.INVALID_MENU_OPTION);
        }
    }

    /**
     * 메뉴 번호 유효성 검사
     * @param menu 메뉴 번호 (1 ~ 8)
     */
    public void validateMenuNumber1To8(String menu) {
        isNumber(menu);

        if (!(menu.matches(MENU_RANGE_1_TO_8))) {
            throw new Exception(ErrorCode.INVALID_MENU_OPTION);
        }
    }

    /**
     * 입력값 길이 유효성 검사
     * @param input 입력값 (최대 길이: 10)
     */
    public String validateStringLength10(String input) {
        isNull(input);

        if (input.length() > 10) {
            throw new Exception(ErrorCode.INVALID_LENGTH_10);
        }
        return input;
    }

    /**
     * 입력값 길이 유효성 검사
     * @param input 입력값 (최대 길이: 30)
     */
    public String validateStringLength30(String input) {
        isNull(input);

        if (input.length() > 30) {
            throw new Exception(ErrorCode.INVALID_LENGTH_30);
        }
        return input;
    }

    /**
     * 입력값 길이 유효성 검사
     * @param input 입력값 (최대 길이: 50)
     */
    public String validateStringLength50(String input) {
        isNull(input);

        if (input.length() >50) {
            throw new Exception(ErrorCode.INVALID_LENGTH_50);
        }
        return input;
    }

    /**
     * ID 유효성 검사
     * @param id 입력값
     */
    public String validateId(String id) {
        if (!(id.matches(ID))) {
            throw new Exception(ErrorCode.INVALID_ID);
        }
        return id;
    }

    /**
     * Password 유효성 검사
     * @param pw 입력값
     */
    public String validatePw(String pw) {
        if (!(pw.matches(PASSWORD))) {
            throw new Exception(ErrorCode.INVALID_PASSWORD);
        }
        return pw;
    }

    /**
     * 이메일 유효성 검사
     * @param email 입력값
     */
    public String validateEmail(String email) {
        if (!(email.matches(EMAIL))) {
            throw new Exception(ErrorCode.INVALID_EMAIL);
        }
        return email;
    }

    /**
     * 전화번호 유효성 검사
     * @param phone 입력값
     */
    public String validatePhone(String phone) {
        if (!(phone.matches(PHONE))) {
            throw new Exception(ErrorCode.INVALID_PHONE);
        }
        return phone;
    }

}
