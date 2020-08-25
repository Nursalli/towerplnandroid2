package com.example.myapplication.response;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;

import static com.example.myapplication.helper.URL.login;
import static com.example.myapplication.helper.URL.logout;

public interface MainService {

    //login
    @POST(login)
    @FormUrlEncoded
    Call<LoginResponse> postLogin(@FieldMap Map<String, String> params);

    //logout
    @POST(logout)
    @FormUrlEncoded
    Call<LogoutResponse> postLogout();

    //etc

    //etc

    //etc
}