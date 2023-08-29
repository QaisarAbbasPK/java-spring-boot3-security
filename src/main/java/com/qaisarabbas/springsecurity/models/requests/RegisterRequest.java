package com.qaisarabbas.springsecurity.models.requests;

/*
 * @created 27/08/2023 - 2:39 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.models.requests
 * @author Qaisar Abbas
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Your good name is required!")
    private String fullName;

    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter valid email!")
    private String email;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Confirm password is required!")
    private String confirmPassword;
}
