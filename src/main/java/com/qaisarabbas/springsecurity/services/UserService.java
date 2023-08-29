package com.qaisarabbas.springsecurity.services;

/*
 * @created 27/08/2023 - 8:52 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.services
 * @author Qaisar Abbas
 */

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
