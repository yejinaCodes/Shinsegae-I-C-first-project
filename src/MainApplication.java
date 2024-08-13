import common.Menu;
import common.ValidCheck;
import controller.AdminController;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    private static boolean isQuit = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static AdminController adminController = new AdminController();
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
        System.out.println(Menu.BOARD_SEPARATOR.getText());
        System.out.println(Menu.USER_TYPE.getText());
        System.out.print(Menu.USER_TYPE_SELECT.getText());
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
        System.out.println(Menu.BOARD_SEPARATOR.getText());
        switch (userType) {
            case "1":
                userMainMenu();
            case "2":
                adminMainMenu();

        }
    }

    /**
     * 회원(쇼핑몰) 페이지 메뉴 선택
     */
    private static void userMainMenu() {

    }


    /**
     * 어드민 페이지 메뉴 선택
     */
    private static void adminMainMenu() {

    }
}
