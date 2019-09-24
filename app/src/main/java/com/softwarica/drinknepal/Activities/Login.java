package com.softwarica.drinknepal.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.softwarica.drinknepal.BusinessLogic.UserLogic;
import com.softwarica.drinknepal.Model.User;
import com.softwarica.drinknepal.R;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtusername, pwpass;
    Button btnlogin;
    TextView btnregister;
    private SharedPreferences.Editor editor;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        initiate();
        preferences = getSharedPreferences("APP", MODE_PRIVATE);
        editor=preferences.edit();

    }

    public void initiate() {
        txtusername = findViewById(R.id.txtuser);
        pwpass = findViewById(R.id.txtpass);
        btnlogin = findViewById(R.id.btnLogin);
        btnregister = findViewById(R.id.btnregister);

        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);
    }

    public boolean checkUser(){
        if(txtusername.getText().toString().isEmpty()){
            txtusername.setError("Enter Username");
            txtusername.requestFocus();
            return false;
        }
        else if(pwpass.getText().toString().isEmpty()){
            pwpass.setError("Enter Password");
            pwpass.requestFocus();
            return false;
        }
        else if(pwpass.getText().toString().isEmpty()&&pwpass.getText().toString().isEmpty()){
            txtusername.setError("Enter Password");
            pwpass.setError("Enter Password");
            txtusername.requestFocus();
            return false;
        }else{
            return true;

        }
    }

    public void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btnLogin:

           if(checkUser()==true){
               UserLogic ul=new UserLogic();
               StrictMode();
               if(ul.LoginUser(txtusername.getText().toString(),pwpass.getText().toString())){
                   Toast.makeText(Login.this,"Your have successfully signed in"+ UserLogic.token,Toast.LENGTH_SHORT).show();
                   editor.putString("token", UserLogic.token);
                   Gson gson = new Gson();
                   String json = gson.toJson(UserLogic.user);
                   editor.putString("userobj", json);
                   editor.commit();
                   Intent intent=new Intent(Login.this,FragmentHolder.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(Login.this,"Your password and username does not match",Toast.LENGTH_SHORT).show();
               }
        }
               break;

           case R.id.btnregister:
               Intent intent=new Intent(Login.this,Register.class);
               startActivity(intent);
               break;
       }
    }
}
