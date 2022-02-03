package com.cse27.onlinestudentplatform.Controller;

import androidx.annotation.NonNull;

import com.cse27.onlinestudentplatform.Model.LoginModel;
import com.cse27.onlinestudentplatform.View.LoginViewInterface;

public class LoginController implements LoginControllerInterface{
    LoginViewInterface loginView;

    public LoginController(LoginViewInterface loginView) {
        this.loginView = loginView;
    }

    /**
     * if valid success login
     * if fails retry login
     * @param email
     * @param password
     */

    @Override
    public void onLogin(String email, String password) {
        LoginModel loginModel= new LoginModel(email, password);
        int loginCode = loginModel.isLoginValid();
        if (loginCode == 0){
            loginView.onLoginError("Please Enter Email");
        }else if (loginCode == 1){
            loginView.onLoginError("Please Enter Valid Email");
        }else if (loginCode == 2){
            loginView.onLoginError("Please Enter Password");
        }else if (loginCode == 3){
            loginView.onLoginError("Password Should Be More Than 6 Characters");
        }else {
            loginView.onLoginSuccess("Login Successful");
        }
    }
}
