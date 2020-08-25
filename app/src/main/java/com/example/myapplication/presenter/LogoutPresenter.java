package com.example.myapplication.presenter;

import com.example.myapplication.contract.LogoutContract;
import com.example.myapplication.response.MainService;
import com.example.myapplication.retrofit.MainInstance;

public class LogoutPresenter {
    LogoutContract logoutContract;

    public LogoutPresenter(LogoutContract logoutContract) {
        this.logoutContract = logoutContract;
    }

    public void postLogout(){
        this.logoutContract.postLogoutStart();

        MainService service = MainInstance.getRetrofit().create(MainService.class);

    }
}