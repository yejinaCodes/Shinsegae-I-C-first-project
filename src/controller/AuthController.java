package controller;

import common.ErrorCode;
import handler.MemberInputHandler;
import common.ValidCheck;
import dto.AdminRequestDto;
import exception.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

public class AuthController {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ValidCheck validCheck = new ValidCheck();
    private static Script script = new Script();
    private static MemberInputHandler memberInputHandler = new MemberInputHandler();
    private static AdminService adminService = new AdminServiceImpl();

    /**
     * [유저] 메뉴 선택 1. 회원 가입 | 2. 로그인
     *
     * @param userType (1. 쇼핑몰, 2. 어드민)
     */
    public void handleAuth(String userType) throws IOException {
        try {
            script.selectLoginOrRegister();
            String menu = br.readLine().trim();
            validCheck.validateMenuNumber1To2(menu);

            switch (userType) {
                case "1":
                    switch (menu) {
                        case "1":
//                          registerUser();
                            break;
                        case "2":
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
    /*private void registerUser() throws IOException {
        try {

        } catch (NullPointerException e) {
            System.out.println(ErrorCode.NULL_VALUE.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/


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


}