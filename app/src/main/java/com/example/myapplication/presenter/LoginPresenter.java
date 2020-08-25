package com.example.myapplication.presenter;

import com.example.myapplication.contract.LoginContract;
import com.example.myapplication.response.LoginResponse;
import com.example.myapplication.response.MainService;
import com.example.myapplication.retrofit.MainInstance;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    LoginContract loginContract;

    public LoginPresenter(LoginContract loginContract) {
        this.loginContract = loginContract;
    }

    public void postLogin(String username, String password) {
        this.loginContract.postLoginStart();

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        MainService service = MainInstance.getRetrofit().create(MainService.class);
        service.postLogin(params).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<LoginResponse> call,
                                   @NotNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    loginContract.postLoginCompleted(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<LoginResponse> call,
                                  @NotNull Throwable t) {
                loginContract.postLoginFailed(t.getMessage());
            }
        });
    }
}