package com.example.root.databindingexample.ViewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.root.databindingexample.Interface.LoginResultCallbacks;
import com.example.root.databindingexample.model.User;

public class LoginViewModel {

    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel( LoginResultCallbacks loginResultCallbacks) {
        this.user = new User();
        this.loginResultCallbacks = loginResultCallbacks;
    }

    public TextWatcher getEmailTextWatcher(){


        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){


        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){

        if(user.isValidData())
            loginResultCallbacks.onSuccess("Login Success");
        else
            loginResultCallbacks.onError("Login error");
    }
}
