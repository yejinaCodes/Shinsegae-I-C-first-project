package dao;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;

public interface UserDao {
    void createUser(UserRequestDto request);

    UserResponseDto findById(int id);

    void updateUser(int id, UserRequestDto request);
}
