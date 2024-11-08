package com.bistrocontrol.bistro_control.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bistrocontrol.bistro_control.model.MyUserPrincipal;
import com.bistrocontrol.bistro_control.model.User;
import com.bistrocontrol.bistro_control.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
         () -> {throw new UsernameNotFoundException("User not found");}
        );
        return new MyUserPrincipal(user);
    }
    
}
