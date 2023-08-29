package com.qaisarabbas.springsecurity.models.requests;

/*
 * @created 27/08/2023 - 2:53 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.models.requests
 * @author Qaisar Abbas
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter valid email!")
    private String email;

    @NotBlank(message = "Password is required!")
    private String password;
}
