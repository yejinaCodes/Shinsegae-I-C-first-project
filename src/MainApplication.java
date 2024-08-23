import common.ErrorCode;
import common.ValidCheck;
import controller.*;
import dto.response.AuthResponseDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import library.Script;

public class MainApplication {

    private static boolean isQuit = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static AuthController authController = new AuthController();
    private static AdminController adminController = new AdminController();
    private static UserController userController = new UserController();
    private static StockRequestController poc = new StockRequestController();
    private static SupportController supportController = new SupportController();
    private static ReleaseController releaseController = new ReleaseController();
    private static Script script = new Script();
    private static AuthResponseDto auth = null;
    private static String userType;

    public static void main(String[] args) {
        try {
            selectUserType();
            while (!isQuit) {
                System.out.println(auth.getId());
                System.out.println(auth.getDepartment());
                System.out.println(auth.getRole());
                selectMainMenu();
            }
        } catch (IOException | SQLException e) {
            System.out.println(ErrorCode.INVALID_VALUE.getMessage());
        }
    }

    /**
     * 서비스 이용자의 타입 받기 1. 쇼핑몰 | 2. 어드민
     */
    private static void selectUserType() throws IOException {
        try {
            script.selectUserType();
            userType = br.readLine().trim();
            validCheck.validateMenuNumber1To2(userType);

            auth = authController.handleAuth(userType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            selectUserType();
        }
    }

    /**
     * 서비스 이용자 타입별 메뉴 출력
     */
    private static void selectMainMenu() throws IOException, SQLException {
        switch (userType) {
            case "1" -> userMainMenu();
            case "2" -> adminMainMenu();
        }
    }

    /**
     * 회원(쇼핑몰) 페이지 메뉴 선택 1. 회원 관리 | 2. 창고 관리 | 3. 재고 관리 4. 입고 관리 | 5. 출고 관리 | 6. 고객 센터 7. 로그아웃
     */
    private static void userMainMenu() throws IOException, SQLException {
        script.userMainMenu();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To7(menu);

        switch (menu) {
            case "1" -> userController.manageUser(); // 1. 회원 관리
//            case "2" ->  // 2. 창고 관리
//            case "3" ->  // 3. 재고 관리
            case "4" -> poc.menu(); //  4. 입고 관리
            case "5" -> releaseController.releaseEmployeeMenu();
            case "6" -> supportController.handleUserSupportMenu(auth); // 6. 고객 센터
//            case "7" -> // 7. 로그아웃
        }
    }


    /**
     * 어드민 페이지 메뉴 선택 1. 회원 관리 | 2. 재무 관리 | 3. 창고 관리 | 4. 재고 관리 5. 입고 관리 | 6. 출고 관리 | 7. 고객 센터 | 8.
     * 로그아웃
     */
    private static void adminMainMenu() throws IOException, SQLException {
        script.adminMainMenu();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To8(menu);

        switch (menu) {
            case "1" -> adminController.manageMember(); // 1. 회원 관리
//            case "2" -> // 2. 재무 관리
//            case "3" -> //3. 창고 관리
//            case "4" -> //4. 재고 관리
            case "5" -> poc.menu(); // 5. 입고 관리
            case "6" -> releaseController.releaseAdminMenu();
            case "7" -> supportController.handleSupportMenu(auth); // 7. 고객 센터
//            case "8" -> // 8. 로그아웃
        }
    }
}
