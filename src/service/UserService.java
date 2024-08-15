package service;

import dto.request.UserRequestDto;

public interface UserService {
    void createUser(UserRequestDto request);
}
