package com.softwarica.drinknepal.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @POST("createuser")
    Call<Void>registerUser(@Body User user);

    @FormUrlEncoded
    @POST("login")  //this is a post method for login
    Call<LoginResponse> checkUser(@Field("username")String username, @Field("password")String password);
}
