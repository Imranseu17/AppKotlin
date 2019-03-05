package com.example.root.databindingexample.ViewModel;

import com.example.root.databindingexample.Interface.LoginResultCallbacks;

public class LoginViewModelFactory {

    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModelFactory(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
    }


}
