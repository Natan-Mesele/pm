package com.example.project.pmsb.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
