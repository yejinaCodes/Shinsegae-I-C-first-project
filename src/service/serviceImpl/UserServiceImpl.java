package service.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import dto.request.UserRequestDto;
import dto.response.UserResponseDto;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void createUser(UserRequestDto request) {
        userDao.createUser(request);
    }

    @Override
    public UserResponseDto findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(int id, UserRequestDto request) {
        userDao.updateUser(id, request);
    }

    @Override
    public void updateUserPwd(int id, UserRequestDto request) {
        userDao.updateUserPwd(id, request);
    }

    ;
}
