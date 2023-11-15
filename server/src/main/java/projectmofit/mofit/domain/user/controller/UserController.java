package projectmofit.mofit.domain.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.user.dto.LoginForm;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // TODO 회원가입에 이메일 인증 추가
    // TODO 로그인, 로그아웃 후 원래 있던 페이지로 리다이렉트
    // TODO 프로필 이미지 수정
    // TODO 회원 정보 수정(닉네임, 비밀번호), 회원 탈퇴

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute User user) {
        return "user/signUpForm";
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody User user, BindingResult bindingResult) {
        // 이메일 중복 확인
        if (userService.emailCheck(user.getEmail()) > 0) {
            bindingResult.rejectValue("email", "duplication", null, "이미 사용 중인 이메일입니다.");
        }

        // 닉네임 중복 확인
        if (userService.nicknameCheck(user.getNickname()) > 0) {
            bindingResult.rejectValue("nickname", "duplication", null, "이미 사용 중인 닉네임입니다.");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.signUp(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 이메일 중복 확인
    @GetMapping("/signup/emailCheck")
    public ResponseEntity<Void> emailCheck(@RequestParam String email) {
        if (userService.emailCheck(email) > 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 닉네임 중복 확인
    @GetMapping("/signup/nicknameCheck")
    public ResponseEntity<Void> nicknameCheck(@RequestParam String nickname) {
        if (userService.nicknameCheck(nickname) > 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/login")
//    public String loginForm(@ModelAttribute LoginForm form) {
//        return "user/loginForm";
//    }

    // 로그인
//    @PostMapping("/login")
//    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
//        if (bindingResult.hasErrors()) {
//            return "user/loginForm";
//        }
//
//        User loginUser = userService.login(form.getEmail(), form.getPassword());
//
//        if (loginUser == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 잘못 입력했습니다.");
//            return "user/loginForm";
//        }
//
//        // 로그인 성공 처리
//        HttpSession session = request.getSession();
//        session.setAttribute("loginUser", loginUser);
//
//        return "redirect:/";
//    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginForm form) {
        User loginUser = userService.login(form.getEmail(), form.getPassword());

        if (loginUser != null) {
            return new ResponseEntity<User>(loginUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(loginUser, HttpStatus.NOT_FOUND);
        }
    }

    // 로그아웃
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/";
//    }
}
