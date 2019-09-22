package com.softwarica.drinknepal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.softwarica.drinknepal.Fragments.Drinks;
import com.softwarica.drinknepal.Fragments.Offers;
import com.softwarica.drinknepal.Fragments.Profiles;
import com.softwarica.drinknepal.Fragments.Snacks;
import com.softwarica.drinknepal.Model.User;
import com.softwarica.drinknepal.R;

public class FragmentHolder extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String token,userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        loadFragment(new Drinks());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getUser();
        SharedPreferences shared1=getSharedPreferences("APP",MODE_PRIVATE);
        token=shared1.getString("token","");
    }

    //loading different  menu fragments
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_drinks:
                fragment = new Drinks();
                break;

            case R.id.navigation_snacks:
                fragment = new Snacks();
                break;

            case R.id.navigation_offers:
                fragment = new Offers();
                break;

            case R.id.navigation_profile:
                fragment = new Profiles();
                break;
        }

        return loadFragment(fragment);
    }


    public User getUser(){
        SharedPreferences shared=getSharedPreferences("APP",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("userobj", "");
        User user = gson.fromJson(json, User.class);
        userId=user.get_id();
        return user;
    }
}
