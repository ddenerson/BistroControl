package com.bistrocontrol.bistro_control.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.bistrocontrol.bistro_control.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);    
}
