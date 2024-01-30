package iegcode.validation.service;

import iegcode.validation.constraint.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2
    )

    public void register(@NotBlank(message = "username can not blank")String username,
                         @NotBlank(message = "password can not blank")String password,
                         @NotBlank(message = "retypePassword can not blank")String retypePassword){
        // TODO register
    }
}
