package projectmofit.mofit.domain.user.service;

import projectmofit.mofit.domain.user.dto.User;

public interface UserService {

    User findById(int id);

    User findByEmail(String email);

    boolean signUp(User user);

    int nicknameCheck(String nickname);

    int emailCheck(String email);

    User login(String email, String password);
}
