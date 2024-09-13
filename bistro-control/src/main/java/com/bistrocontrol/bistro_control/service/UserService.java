package com.bistrocontrol.bistro_control.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bistrocontrol.bistro_control.model.RegisterUserForm;
import com.bistrocontrol.bistro_control.model.User;
import com.bistrocontrol.bistro_control.model.UserRole;
import com.bistrocontrol.bistro_control.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterUserForm data) {
        User user = new User();
        if (data.role().equals("admin")) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.USER);
        }
        user.setName(data.name());
        user.setEmail(data.email());

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        user.setPassword(encryptedPassword);
    
        return this.userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
