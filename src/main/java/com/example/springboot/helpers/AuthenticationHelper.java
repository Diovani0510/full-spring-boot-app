package com.example.springboot.helpers;


public class AuthenticationHelper {

    public static boolean isPasswordValid(String password) {
        // Minimo 8 caracteres, pelo menos 1 letra maiuscula, 1 minuscula e 1 caractere especial
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}
