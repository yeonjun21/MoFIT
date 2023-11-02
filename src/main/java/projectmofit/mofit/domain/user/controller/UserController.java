package projectmofit.mofit.domain.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.user.dto.LoginForm;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute User user) {
        return "user/signUpForm";
    }

    // 회원가입
    // TODO 이메일 인증
    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        // 이메일 중복 확인
        if (userService.emailCheck(user.getEmail()) > 0) {
            bindingResult.rejectValue("email", "duplication", null, "이미 사용 중인 이메일입니다.");
        }

        // 닉네임 중복 확인
        if (userService.nicknameCheck(user.getNickname()) > 0) {
            bindingResult.rejectValue("nickname", "duplication", null, "이미 사용 중인 닉네임입니다.");
        }

        if (bindingResult.hasErrors()) {
            return "user/signUpForm";
        }

        userService.signUp(user);
        return "redirect:/";
    }

    // TODO login, logout, 프로필 사진 수정

    // Do or Not? 회원 정보 수정, 비밀번호 찾기, 탈퇴하기

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm form) {
        return "user/loginForm";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "user/loginForm";
        }

        User loginUser = userService.login(form.getEmail(), form.getPassword());

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 잘못 입력했습니다.");
            return "user/loginForm";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);

        return "redirect:/";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
