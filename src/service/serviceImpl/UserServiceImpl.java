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
    };
}
