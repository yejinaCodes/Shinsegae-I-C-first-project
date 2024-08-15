package dao;

import dto.request.UserRequestDto;

public interface UserDao {
    void createUser(UserRequestDto request);
}
