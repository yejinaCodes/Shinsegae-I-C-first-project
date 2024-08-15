package controller;

import common.ErrorCode;
import dto.request.UserRequestDto;
import handler.MemberInputHandler;
import common.ValidCheck;
import dto.request.AdminRequestDto;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;
import service.AdminService;
import service.UserService;
import service.serviceImpl.AdminServiceImpl;
import service.serviceImpl.UserServiceImpl;

public class AuthController {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static Script script = new Script();
    private static MemberInputHandler memberInputHandler = new MemberInputHandler();
    private static AdminService adminService = new AdminServiceImpl();
    private static UserService userService = new UserServiceImpl();

    /**
     * 메뉴 선택 1. 회원 가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기
     *
     * @param userType (1. 쇼핑몰, 2. 어드민)
     */
    public void handleAuth(String userType) throws IOException {
        try {
            script.selectLoginOrRegister();
            String menu = br.readLine().trim();
            validCheck.validateMenuNumber1To4(menu);

            switch (userType) {
                case "1":
                    switch (menu) {
                        case "1":
                            registerUser();
                            break;
                        case "2":
                            break;
                        case "3":
//                          findUserId();
                            break;
                        case "4":
//                            findUserPwd();
                            break;
                    }
                    break;
                case "2":
                    switch (menu) {
                        case "1":
                            registerAdmin();
                            break;
                        case "2":
                            break;
                        case "3":
//                          findAdminId();
                            break;
                        case "4":
//                            findAdminPwd();
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            handleAuth(userType);
        }
    }

    /**
     * 유저 회원 가입
     */
    private void registerUser() throws IOException {
        try {

            UserRequestDto user = memberInputHandler.createUser();

            userService.createUser(user);
        } catch (IOException e) {
            System.out.println(ErrorCode.INVALID_VALUE.getMessage());
        }
    }

    /**
     * 쇼핑몰 사업자 회원 아이디 찾기
     */
    private void findUserId() {

    }

    /**
     * 쇼핑몰 사업자 회원 비밀번호 찾기
     */
    private void findUserPwd() {

    }


    /**
     * 어드민 회원 가입
     */
    private void registerAdmin() {
        try {

            AdminRequestDto admin = memberInputHandler.createAdmin();

            adminService.createAdmin(admin);
        } catch (IOException e) {
            System.out.println(ErrorCode.INVALID_VALUE.getMessage());
        }
    }

    /**
     * 어드민 아이디 찾기
     */
    private void findAdminId() {

    }

    /**
     * 어드민 비밀번호 찾기
     */
    private void findAdminPwd() {

    }


}