package service;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;

public interface UserService {
    void createUser(UserRequestDto request);

    UserResponseDto findById(int id);
}
