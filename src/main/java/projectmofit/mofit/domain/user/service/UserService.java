package projectmofit.mofit.domain.user.service;

import projectmofit.mofit.domain.user.dto.User;

public interface UserService {

    User findById(int id);

    User findByEmail(String email);

    boolean signUp(User user);

    int nickNameCheck(String nickname);

    boolean login(String email, String password);
}
