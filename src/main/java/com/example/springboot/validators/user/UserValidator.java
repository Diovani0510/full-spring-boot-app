package com.example.springboot.validators.user;

import com.example.springboot.common.UserRole;
import com.example.springboot.dtos.authentication.UserRegisterRecordDto;
import com.example.springboot.helpers.AuthenticationHelper;
import com.example.springboot.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserValidator {
    @Autowired
    private UserRepository userRepository;

    public boolean isUserRegisterValid(UserRegisterRecordDto userRegisterRecordDto) {
        boolean userExists = this.userRepository.findByName(userRegisterRecordDto.name()) != null;
        boolean isRoleValid = Arrays.stream(UserRole.values()).anyMatch(userRole -> userRole.getRole().equals(userRole.getRole()));
        boolean isPasswordValid = AuthenticationHelper.isPasswordValid(userRegisterRecordDto.password());

        return !userExists && isRoleValid && isPasswordValid;
    }
}
