package com.example.myapplication.contract;

import com.example.myapplication.response.LogoutResponse;

public interface LogoutContract {
     void postLogoutStart();
     void postLogoutCompleted(LogoutResponse loginResponse);
     void postLogoutFailed(String message);
}