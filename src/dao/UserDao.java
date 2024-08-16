package dao;

import dto.request.UserApprovalRequestDto;
import dto.request.UserRequestDto;
import dto.response.AuthResponseDto;
import dto.response.UserApprovalResponseDto;
import dto.response.UserResponseDto;
import java.util.List;

public interface UserDao {
    void createUser(UserRequestDto request);

    List<UserResponseDto> findAll();

    UserResponseDto findById(int id);

    List<UserApprovalResponseDto> findByApproval();

    String findUserId(String bizNo);

    AuthResponseDto findAuth(String userId);

    void updateUser(int id, UserRequestDto request);

    void updateUserPwd(int id, UserRequestDto request);

    void updateApprovalStatus(int id, UserApprovalRequestDto request);

    void unregister(int id, UserRequestDto request);

    void delete(int id);
}
