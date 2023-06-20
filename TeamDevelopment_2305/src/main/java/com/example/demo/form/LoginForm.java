package com.example.demo.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

    @NotBlank
    private String email;

    @NotBlank
    private String password;



	
}