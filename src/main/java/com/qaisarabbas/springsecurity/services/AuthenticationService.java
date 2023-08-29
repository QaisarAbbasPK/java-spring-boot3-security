package com.qaisarabbas.springsecurity.services;

/*
 * @created 27/08/2023 - 8:47 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.services.impl
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.models.requests.LoginRequest;
import com.qaisarabbas.springsecurity.models.requests.RegisterRequest;
import com.qaisarabbas.springsecurity.models.response.AuthResponse;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
