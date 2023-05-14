package com.venkatesh.springSecurity.securityConfig;


import com.venkatesh.springSecurity.model.User;
import com.venkatesh.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetail implements UserDetailsService {


    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByname(username);
        return user.map(UserInfo::new).orElseThrow(() -> new UsernameNotFoundException("User is Not Exist"));
    }
}
