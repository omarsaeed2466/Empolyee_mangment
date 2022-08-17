package com.example.empolyee_mangment.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResetPassword implements Serializable {
    private String emailId;
    private String password;
    private String password2;

}
