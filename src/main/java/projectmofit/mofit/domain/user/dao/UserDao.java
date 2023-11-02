package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.dto.UserImg;

public interface UserDao {

    User findById(int id);

    User findByEmail(String email);

    int insertUser(User user);

    // int updateImg(UserImg userImg);
}
