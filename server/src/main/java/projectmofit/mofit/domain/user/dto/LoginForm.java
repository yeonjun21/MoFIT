package projectmofit.mofit.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank(message = "이메일을 입력하세요.")
    @Email
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;
}
