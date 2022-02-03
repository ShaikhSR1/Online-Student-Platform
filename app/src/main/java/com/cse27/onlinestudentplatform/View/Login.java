package com.cse27.onlinestudentplatform.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cse27.onlinestudentplatform.Controller.LoginController;
import com.cse27.onlinestudentplatform.Controller.LoginControllerInterface;
import com.cse27.onlinestudentplatform.MainActivity;
import com.cse27.onlinestudentplatform.R;

public class Login extends AppCompatActivity implements LoginViewInterface {

    EditText inputLoginEmail,inputLoginPassword;
    TextView toSignUp;
    Button loginButton;

    LoginControllerInterface loginController;

    /**
     * takes values from user and send then to controller
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginController = new LoginController(this);
        toSignUp = (TextView) findViewById(R.id.toSignUp);
        inputLoginEmail = (EditText) findViewById(R.id.inputLoginEmail);
        inputLoginPassword = (EditText) findViewById(R.id.inputLoginPassword);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.onLogin(inputLoginEmail.getText().toString().trim(),inputLoginPassword.getText().toString().trim());

            }
        });

        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

    }

    /**
     * shows login success message
     * @param message
     */

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * shows login fail message
     * @param message
     */

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}