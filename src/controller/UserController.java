package controller;

import common.ValidCheck;
import dto.response.UserResponseDto;
import handler.MemberInputHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import library.Script;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

public class UserController {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static MemberInputHandler memberInputHandler = new MemberInputHandler();
    private static ValidCheck validCheck = new ValidCheck();
    private static Script script = new Script();
    private static UserService userService = new UserServiceImpl();
    private static int id = 1;// 🚨 로그인 유저 id로 변경 예정

    /**
     * '회원 관리' 메뉴 선택
     * 1. 정보 조회 | 2. 정보 수정 | 3. 비밀번호 변경 | 4. 탈퇴
     */
    public void manageUser() throws IOException {
        script.manageUser();
        String menu = br.readLine().trim();
        validCheck.validateMenuNumber1To4(menu);

        switch (menu) {
            case "1":
                viewInfo();
                break;
            case "2":
                editUser();
                break;
            case "3":
//                editPwd();
                break;
            case "4":
//                unregister();
                break;
        }
    }

    /**
     * '회원 관리 > 정보 조회'
     */
    private void viewInfo() {
        UserResponseDto response = userService.findById(id);
        script.userInfo(response);
    }

    /**
     * '회원 관리 > 정보 수정'
     */
    private void editUser() throws IOException {
        userService.updateUser(id, memberInputHandler.updateUser());
    }
}
