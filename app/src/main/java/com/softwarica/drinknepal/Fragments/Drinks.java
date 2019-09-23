package com.softwarica.drinknepal.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarica.drinknepal.Activities.FragmentHolder;
import com.softwarica.drinknepal.Adapter.DrinkRecyclerAdapter;
import com.softwarica.drinknepal.BusinessLogic.ProductLogic;
import com.softwarica.drinknepal.Model.Drink;
import com.softwarica.drinknepal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Drinks extends Fragment {
    RecyclerView drinkrv;
    List<Drink> drinklist=new ArrayList<>();

    public Drinks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drinks, container, false);
        ((FragmentHolder) (getContext())).getSupportActionBar()
                .hide();
        drinkrv=view.findViewById(R.id.recyclerDrink);
        ProductLogic pl=new ProductLogic();
        List<Drink>drinkList= (List<Drink>) pl.getAllDrink();
        DrinkRecyclerAdapter treadapter=new DrinkRecyclerAdapter(drinkList,getContext());
        drinkrv.setLayoutManager(new LinearLayoutManager(getContext()));
        drinkrv.setAdapter(treadapter);
        return view;
    }

}
