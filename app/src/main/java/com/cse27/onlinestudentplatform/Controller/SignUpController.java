package com.cse27.onlinestudentplatform.Controller;

import androidx.annotation.NonNull;

import com.cse27.onlinestudentplatform.Model.SignUpModel;
import com.cse27.onlinestudentplatform.View.SignUpViewInterface;


public class SignUpController implements SignUpControllerInterface{
    SignUpViewInterface signUpView;



    public SignUpController(SignUpViewInterface signUpView) {
        this.signUpView = signUpView;
    }

    /**
     * passes the data to model
     * connects firebase
     * checks validity
     * @param fullName
     * @param email
     * @param phoneNumber
     * @param password
     * @param confirmPassword
     */

    @Override
    public void onSignUp(String fullName, String email, String phoneNumber, String password, String confirmPassword) {
        SignUpModel signUpModel = new SignUpModel(fullName, email, phoneNumber, password, confirmPassword);

        int signUpCode = signUpModel.isSignUpValid();
        if (signUpCode == 0) {
            signUpView.onSignUpError("Please Enter Full Name");

        } else if (signUpCode == 1) {
            signUpView.onSignUpError("Please Enter Email");

        } else if (signUpCode == 2) {
            signUpView.onSignUpError("Please Enter Valid Email");

        } else if (signUpCode == 3) {
            signUpView.onSignUpError("Please Enter Phone Number");

        } else if (signUpCode == 4) {
            signUpView.onSignUpError("Please Enter Valid Phone Number");

        } else if (signUpCode == 5) {
            signUpView.onSignUpError("Please Enter Password");

        } else if (signUpCode == 6) {
            signUpView.onSignUpError("Please Should Be 6 Or More Character");

        } else if (signUpCode == 7) {
            signUpView.onSignUpError("Passwords Do Not Match");

        } else {

            signUpView.onSignUpSuccess("SignUp Successful");
        }


    }
}
