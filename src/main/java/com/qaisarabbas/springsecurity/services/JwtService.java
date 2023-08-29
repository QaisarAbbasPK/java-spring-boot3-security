package com.qaisarabbas.springsecurity.services;

/*
 * @created 27/08/2023 - 8:51 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.services
 * @author Qaisar Abbas
 */

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
}
