package com.example.myapplication.contract;

import com.example.myapplication.response.LoginResponse;

public interface LoginContract {
    public void postLoginStart();
    public void postLoginCompleted(LoginResponse loginResponse);
    public void postLoginFailed(String message);
}