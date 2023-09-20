package com.example.springboot.repositories.user;

import com.example.springboot.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    public UserDetails findByName(String userName);
}
