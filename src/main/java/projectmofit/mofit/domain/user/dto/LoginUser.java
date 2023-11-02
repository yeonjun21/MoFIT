package projectmofit.mofit.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUser {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
