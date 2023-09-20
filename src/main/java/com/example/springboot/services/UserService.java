package com.example.springboot.services;

import com.example.springboot.common.UserRole;
import com.example.springboot.dtos.authentication.UserRegisterRecordDto;
import com.example.springboot.models.user.UserModel;
import com.example.springboot.repositories.user.UserRepository;
import com.example.springboot.validators.user.UserValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    public void registerUser(UserRegisterRecordDto userRegisterRecordDto) {
        boolean isUserRegistrationValid = this.userValidator.isUserRegisterValid(userRegisterRecordDto);

        if (!isUserRegistrationValid) {
            throw new RuntimeException("Invalid User Data");
        }

        UserModel userModel = convertUserRecordToUserModel(userRegisterRecordDto);
        this.userRepository.save(userModel);
    }

    private UserModel convertUserRecordToUserModel(UserRegisterRecordDto userRegisterRecordDto) {
        UserRole userRole = UserRole.valueOf(userRegisterRecordDto.role().toUpperCase());
        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterRecordDto.password());

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegisterRecordDto, userModel);

        userModel.setPassword(encryptedPassword);
        userModel.setRole(userRole);

        return userModel;
    }
}
