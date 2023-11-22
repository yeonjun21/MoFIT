package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.user.dto.User;

public interface UserDao {

    User findById(int id);

    User findByEmail(String email);

    int insertUser(User user);

    int nicknameCheck(String nickname);

    int emailCheck(String email);

}
