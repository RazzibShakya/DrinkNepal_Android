package com.softwarica.drinknepal.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    //for registering user
    @POST("createuser")
    Call<Void>addNewUser(@Body User user);

    @FormUrlEncoded
    @POST("login")  //this is a post method for login
    Call<LoginResponse> checkUser(@Field("phone")String phone, @Field("password")String password);

    @GET("drinks")  //this is a get method for getting all the treks
    Call<List<Drink>> getAllDrink();
}
