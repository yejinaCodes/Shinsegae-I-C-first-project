package dao;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;
import java.util.List;

public interface UserDao {
    void createUser(UserRequestDto request);

    List<UserResponseDto> findAll();

    UserResponseDto findById(int id);

    void updateUser(int id, UserRequestDto request);

    void updateUserPwd(int id, UserRequestDto request);

    void delete(int id, UserRequestDto request);
}
