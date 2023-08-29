package com.qaisarabbas.springsecurity.services.impl;

/*
 * @created 27/08/2023 - 9:00 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.services.impl
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.repositories.UserRepository;
import com.qaisarabbas.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
