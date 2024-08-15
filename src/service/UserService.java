package service;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;

public interface UserService {
    void createUser(UserRequestDto request);

    UserResponseDto findById(int id);

    void updateUser(int id, UserRequestDto request);

    void updateUserPwd(int id, UserRequestDto request);

    void delete(int id, UserRequestDto request);
}
