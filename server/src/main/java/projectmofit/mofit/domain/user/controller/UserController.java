package projectmofit.mofit.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginForm form) {
        User loginUser = userService.login(form.getEmail(), form.getPassword());

        if (loginUser != null) {
            return new ResponseEntity<User>(loginUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(loginUser, HttpStatus.NOT_FOUND);
        }
    }

}
