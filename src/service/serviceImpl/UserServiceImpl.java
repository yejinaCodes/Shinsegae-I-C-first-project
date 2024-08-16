package service.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import dto.request.UserApprovalRequestDto;
import dto.request.UserRequestDto;
import dto.response.UserApprovalResponseDto;
import dto.response.UserResponseDto;
import java.util.List;
import security.Encrypt;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private Encrypt encrypt = new Encrypt();
    @Override
    public void createUser(UserRequestDto request) {
//        encrypt.getEncrypt(request.getPassword());
        request.getPassword();
        userDao.createUser(request);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserResponseDto findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserApprovalResponseDto> findByApproval() {
        return userDao.findByApproval();
    }

    @Override
    public String findUserId(String bizNo) {
        return userDao.findUserId(bizNo);
    }

    @Override
    public void updateUser(int id, UserRequestDto request) {
        userDao.updateUser(id, request);
    }

    @Override
    public void updateUserPwd(int id, UserRequestDto request) {
        userDao.updateUserPwd(id, request);
    }

    @Override
    public void updateApprovalStatus(int id, UserApprovalRequestDto request) {
        userDao.updateApprovalStatus(id, request);
    }

    @Override
    public void unregister(int id, UserRequestDto request) {
        userDao.unregister(id, request);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    ;
}
