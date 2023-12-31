package projectmofit.mofit.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.user.dao.UserDao;
import projectmofit.mofit.domain.user.dto.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean signUp(User user) {
        return userDao.insertUser(user) > 0;
    }

    @Override
    public int nicknameCheck(String nickname) {
        return userDao.nicknameCheck(nickname);
    }

    @Override
    public int emailCheck(String email) {
        return userDao.emailCheck(email);
    }

    @Override
    public User login(String email, String password) {
        User loginUser = userDao.findByEmail(email);

        if (loginUser != null && loginUser.getPassword().equals(password)) {
            return loginUser;
        } else {
            return null;
        }
    }
}
