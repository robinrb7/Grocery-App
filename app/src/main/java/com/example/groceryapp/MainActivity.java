package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    List<Item> itemList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        Item item1 = new Item("Fruits","Fresh fruits from the Garden",R.drawable.img_1);
        Item item2 = new Item("Vegetables","Fresh vegetables",R.drawable.img_2);
        Item item3 = new Item("Bakery","Bread,Wheat and Buns",R.drawable.img_3);
        Item item4 = new Item("Beverage","Tea,Coffee,Soda,Juice",R.drawable.img_4);
        Item item5 = new Item("Milk","Milk,Shakes and Yogurt",R.drawable.img_5);
        Item item6 = new Item("Snacks","Popcorn,Donuts and Drinks",R.drawable.img_6);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter= new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setItemClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You chose : "+ itemList.get(pos).itemName, Toast.LENGTH_SHORT).show();
    }
}