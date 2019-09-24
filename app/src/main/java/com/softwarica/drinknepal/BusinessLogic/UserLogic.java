package com.softwarica.drinknepal.BusinessLogic;

import com.softwarica.drinknepal.Model.Connection;
import com.softwarica.drinknepal.Model.LoginResponse;
import com.softwarica.drinknepal.Model.User;
import com.softwarica.drinknepal.Model.API;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class UserLogic {
    public static String token;
    public static User user;

    public boolean LoginUser(String username, String password){
        boolean isSuccess=false;
        Connection con=new Connection();
        API api= con.createInstanceofRetrofitwithoutauth();
        Call<LoginResponse> usercall=api.checkUser(username,password);
        try{
            Response<LoginResponse> loginresponse=usercall.execute();
            if (!loginresponse.body().getToken().isEmpty()){
                token=loginresponse.body().getToken();
                user=loginresponse.body().getUser();
                isSuccess=true;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    //this is the main logic for registering the user
    public boolean RegisterUser(String name,String email,String phone,String address,String dob,String password) {
        boolean register = false;
        Connection conn=new Connection();
        User user=new User(name,phone,email,address,dob,password);
        Call<Void>addUser= conn.createInstanceofRetrofitwithoutauth().addNewUser(user);
        try{
            Response<Void>adduser=addUser.execute();
            if (adduser.isSuccessful()){
                register=true;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return register;
    }

}
