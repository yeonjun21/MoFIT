package projectmofit.mofit.domain.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // TODO 이메일 인증
    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        // 닉네임 중복 확인
        if (userService.nickNameCheck(user.getNickname()) > 0) {
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
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(String email, String password) {



        return "user/loginForm";
    }
}
