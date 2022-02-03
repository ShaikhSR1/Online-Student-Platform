package com.cse27.onlinestudentplatform.Model;

public interface SignUpModelInterface {
    String getFullName();
    String getEmail();
    String getPhoneNumber();
    String getPassword();
    String getConfirmPassword();
    int isSignUpValid();
}
