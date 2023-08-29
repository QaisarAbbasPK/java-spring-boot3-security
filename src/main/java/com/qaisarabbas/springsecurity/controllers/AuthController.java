package com.qaisarabbas.springsecurity.controllers;

/*
 * @created 27/08/2023 - 2:41 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.controllers
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.models.requests.LoginRequest;
import com.qaisarabbas.springsecurity.models.requests.RegisterRequest;
import com.qaisarabbas.springsecurity.models.response.ApiResponse;
import com.qaisarabbas.springsecurity.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ApiResponse register(@RequestBody @Valid RegisterRequest request){
        return new ApiResponse(authenticationService.register(request));
    }

    @PostMapping("login")
    public ApiResponse login(@RequestBody @Valid LoginRequest request){
        return new ApiResponse(authenticationService.login(request));
    }
}
