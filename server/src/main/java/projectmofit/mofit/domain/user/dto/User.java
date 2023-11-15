package projectmofit.mofit.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class User {

    private int id;

    @NotBlank(message = "이메일을 입력하세요.")
    @Email
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,20}", message = "비밀번호는 숫자와 영어를 혼합하여 8자 이상, 20자 이하여야 합니다.")
    private String password;

    // 이름은 한글만 입력 가능
    @NotBlank(message = "이름은 입력하세요.")
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "이름은 2자 이상 10자 이하의 한글만 입력 가능합니다.")
    private String name;

    // 닉네임은 10글자 이하, 한글만 입력 가능
    @NotBlank(message = "닉네임을 입력하세요.")
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "닉네임은 2자 이상 10자 이하의 한글만 입력 가능합니다.")
    private String nickname;

    private String img;

    public User() {
    }

    public User(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

}
