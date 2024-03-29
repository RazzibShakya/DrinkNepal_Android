package com.softwarica.drinknepal.BusinessLogic;

import android.widget.Toast;

import com.softwarica.drinknepal.Model.Connection;
import com.softwarica.drinknepal.Model.Drink;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ProductLogic {
    Drink drink;

    public Drink getAllDrink(){
        Connection connection=new Connection();
        Call<List<Drink>> listdrink= connection.createInstanceofRetrofitwithoutauth().getAllDrink();
        try {
            Response<List<Drink>> drinklist=listdrink.execute();
        if(drinklist.isSuccessful()){
           drink= (Drink) drinklist.body();
        }else{
            drink=null;
        }

        }catch (Exception e){
            e.printStackTrace();
        }
        return drink;
    }
}
