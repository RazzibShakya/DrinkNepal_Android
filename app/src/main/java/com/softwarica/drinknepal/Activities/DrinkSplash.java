package com.softwarica.drinknepal.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.softwarica.drinknepal.R;

public class DrinkSplash extends AppCompatActivity {
    SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_splash);
        getSupportActionBar().hide();
        preferences = getSharedPreferences("APP", MODE_PRIVATE);
        editor=preferences.edit();
        String val=preferences.getString("token", "");
        if(!val.isEmpty()){
//            final Intent intent1=new Intent(this,ViewProduct.class);
//            startActivity(intent1);
        }else{
            final Intent intent = new Intent(DrinkSplash.this, Login.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                }
            },5000);
        }
    }
}
