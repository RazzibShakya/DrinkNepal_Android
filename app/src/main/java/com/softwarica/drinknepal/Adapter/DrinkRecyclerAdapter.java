package com.softwarica.drinknepal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwarica.drinknepal.Activities.DrinkDetail;
import com.softwarica.drinknepal.Model.Connection;
import com.softwarica.drinknepal.Model.Drink;
import com.softwarica.drinknepal.R;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class DrinkRecyclerAdapter extends RecyclerView.Adapter<DrinkRecyclerAdapter.DrinkViewHolder> {
    List<Drink> drinkList;
    Context context;

    public DrinkRecyclerAdapter(List<Drink> drinkList,Context context){
        this.drinkList=drinkList;
        this.context=context;
    }
    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drinksample, viewGroup, false);
        return new DrinkViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder drinkviewholder, int i) {
        Connection conn=new Connection();
        final Drink drink=drinkList.get(i);
        String imgpath = conn.drinkurl+ drink.getProduct_photo();
        System.out.println(imgpath);
        conn.StrictMode();
        try {
            URL ur = new URL(imgpath);
            drinkviewholder.drinkimage.setImageBitmap(BitmapFactory.decodeStream((InputStream) ur.getContent()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        drinkviewholder.drink_name.setText(drink.getProduct_name());
        drinkviewholder.drink_price.setText("Price: $"+drink.getProduct_price());
        drinkviewholder.drink_quantity.setText("Quantity: "+drink.getProduct_quantity()+"items");
        drinkviewholder.drink_description.setText("Descriptions: "+drink.getProduct_description());
        drinkviewholder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context, DrinkDetail.class);
        intent.putExtra("drink_name",drink.getProduct_name());
        intent.putExtra("drink_price",drink.getProduct_price());
        intent.putExtra("drink_quantity",drink.getProduct_quantity());
        intent.putExtra("drink_description",drink.getProduct_description());
        intent.putExtra("drink_image",drink.getProduct_photo());
        context.startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder {
        TextView drink_name,drink_price,drink_quantity,drink_description;
        ImageView drinkimage;
        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            drink_name=itemView.findViewById(R.id.drinkname);
            drink_price=itemView.findViewById(R.id.drink_price);
            drink_quantity=itemView.findViewById(R.id.drinkquantity);
            drink_description=itemView.findViewById(R.id.drinkdescription);
            drinkimage=itemView.findViewById(R.id.drink_image);

        }
    }
}
