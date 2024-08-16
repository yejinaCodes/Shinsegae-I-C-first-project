package service.serviceImpl;

import common.ErrorCode;
import dao.AdminDao;
import dao.UserDao;
import dao.daoImpl.AdminDaoImpl;
import dao.daoImpl.UserDaoImpl;
import dto.request.AuthRequestDto;
import dto.response.AuthResponseDto;
import javax.naming.AuthenticationException;
import security.Encrypt;
import service.AuthService;

public class AuthServiceImpl implements AuthService {

    private Encrypt encrypt = new Encrypt();
    private AdminDao adminDao = new AdminDaoImpl();
    private UserDao userDao = new UserDaoImpl();


    @Override
    public AuthResponseDto loginUser(AuthRequestDto user) throws AuthenticationException {
        String userId = user.getId();
        AuthResponseDto auth = userDao.findAuth(userId);

            if (auth == null) {
                throw new AuthenticationException(ErrorCode.USER_NOT_FOUND.getMessage());
            }

            String inputPwd = encrypt.getEncrypt(user.getPassword(), auth.getSalt());
            if (!inputPwd.equals(auth.getPassword())) {
                throw new AuthenticationException(ErrorCode.PASSWORD_NOT_FOUND.getMessage());
            }

        return auth;
    }

    @Override
    public AuthResponseDto loginAdmin(AuthRequestDto user) throws AuthenticationException {
        String adminId = user.getId();
        AuthResponseDto auth = adminDao.findAuth(adminId);

            if (auth == null) {
                throw new AuthenticationException(ErrorCode.USER_NOT_FOUND.getMessage());
            }

            String inputPwd = encrypt.getEncrypt(user.getPassword(), auth.getSalt());
            if (!inputPwd.equals(auth.getPassword())) {
                throw new AuthenticationException(ErrorCode.PASSWORD_NOT_FOUND.getMessage());
            }
        return auth;
    }
}
