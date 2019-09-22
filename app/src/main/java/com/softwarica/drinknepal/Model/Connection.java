package com.softwarica.drinknepal.Model;

import android.os.StrictMode;

import com.softwarica.drinknepal.Activities.FragmentHolder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {
    private API API,APInoAuth;
    public static String url="http://172.26.0.115:3000/DrinkNepal/"; //ipaddress
    public static String drinkurl="http://172.26.0.115:3000/drink/";


    //this is for authentication
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String token= FragmentHolder.token;
            Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    public API createInstanceofRetrofitnoauth(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APInoAuth = retrofit.create(API.class);
        return API;
    }
    //this is for creating instance of retrofit with Authentication
    public API createInstanceofRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API = retrofit.create(API.class);
        return API;
    }
    public void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}
