package com.example.springboot.controllers.authentication;

import com.example.springboot.dtos.authentication.AuthenticationRecordDto;
import com.example.springboot.dtos.authentication.UserLoginResponseRecordDto;
import com.example.springboot.dtos.authentication.UserRegisterRecordDto;
import com.example.springboot.infra.security.TokenService;
import com.example.springboot.models.user.UserModel;
import com.example.springboot.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody @Valid AuthenticationRecordDto authenticationDto) {
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authenticationDto.name(), authenticationDto.password());
        Authentication auth = authenticationManager.authenticate(userAuth);

        UserModel user = (UserModel) auth.getPrincipal();
        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new UserLoginResponseRecordDto(token));
    }

    @PostMapping("/register")
    private ResponseEntity register(@RequestBody @Valid UserRegisterRecordDto userRegisterRecordDto) {
        try {
            this.userService.registerUser(userRegisterRecordDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
