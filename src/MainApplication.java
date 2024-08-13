import common.ValidCheck;
import controller.AdminController;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;

public class MainApplication {
    private static boolean isQuit = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static AdminController adminController = new AdminController();
    private static Script script = new Script();
    private static String userType;
    public static void main(String[] args) {
        try {
            selectUserType();
            while (!isQuit) {
                selectMainMenu();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 서비스 이용자의 타입 받기
     * 1. 쇼핑몰 | 2. 어드민
     */
    private static void selectUserType() throws IOException {
        script.selectUserType();
        userType = br.readLine().trim();
        validCheck.validateMenuNumber1To2(userType);

        switch (userType) {
            case "1":
//                userController.selectLoginOrRegister();
            case "2":
                adminController.selectLoginOrRegister();
        }
    }

    /**
     * 서비스 이용자 타입별 메뉴 출력
     */
    private static void selectMainMenu() throws IOException {
        switch (userType) {
            case "1":
                userMainMenu();
                break;
            case "2":
                adminMainMenu();
                break;
        }
    }

    /**
     * 회원(쇼핑몰) 페이지 메뉴 선택
     * 1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리
     * 4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터
     * 7. 로그아웃
     */
    private static void userMainMenu() {
        script.userMainMenu();
    }


    /**
     * 어드민 페이지 메뉴 선택
     * 1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리
     * 5. 입고 관리 | 6. 출고 관리 | 7. 고객 센터 | 8. 로그아웃
     */
    private static void adminMainMenu() throws IOException {
        script.adminMainMenu();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To8(menu);

        switch (menu) {
            case "1":
//                1. 회원 관리
                adminController.manageMember();
                break;
            case "2":
//                2. 재무 관리
                break;
            case "3":
//                3. 창고 관리
                break;
            case "4":
//                4. 재고 관리
                break;
            case "5":
//                5. 입고 관리
                break;
            case "6":
//                6. 출고 관리
                break;
            case "7":
//                7. 고객 센터
                break;
            case "8":
//                8. 로그아웃
                break;
        }
    }
}
