package com.cse27.onlinestudentplatform.Model;

import androidx.core.util.PatternsCompat;

public class SignUpModel implements SignUpModelInterface {


    private String fullName, email, phoneNumber, passowrd, confirmPassword;

    public SignUpModel() {

    }


    /**
     * Constructor
     *
     * @param fullName
     * @param email
     * @param phoneNumber
     * @param password
     * @param confirmPassword
     */

    public SignUpModel(String fullName, String email, String phoneNumber, String password, String confirmPassword) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passowrd = password;
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return fullname[String]
     */

    @Override
    public String getFullName() {
        return fullName;
    }

    /**
     * @return email[String]
     */

    @Override
    public String getEmail() {
        return email;
    }

    /**
     * @return phoneNumber[String]
     */

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return password[String]
     */

    @Override
    public String getPassword() {
        return passowrd;
    }

    /**
     * @return confirmPassword[String]
     */
    @Override
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * checks validity
     *
     * @return validationCode[String]
     */

    @Override
    public int isSignUpValid() {
        if (getFullName() == "") {
            return 0;
        } else if (getEmail() == "") {
            return 1;
        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 2;
        } else if (getPhoneNumber() == "") {
            return 3;
        } else if (getPhoneNumber().length() != 11) {
            return 4;
        } else if (getPassword() == "") {
            return 5;
        } else if (getPassword().length() < 6) {
            return 6;
        } else if (!getPassword().equals(getConfirmPassword())) {
            return 7;
        } else {
            return 9;
        }

    }
}