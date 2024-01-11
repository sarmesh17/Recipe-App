package com.sharkdroid.recipes;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    Button allRecipe,lunch,dinner,breakfast,tea;

    Adapter_Recipe_Recycler adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         allRecipe = findViewById(R.id.btnAllRecipe);
         lunch = findViewById(R.id.btnLunch);
         dinner = findViewById(R.id.btnDinner);
         tea = findViewById(R.id.btnTea);
         breakfast = findViewById(R.id.btnBreakfast);


        allRecipe.setOnClickListener(this :: onButtonClick);
        lunch.setOnClickListener(this :: onButtonClick);
        dinner.setOnClickListener(this :: onButtonClick);
        tea.setOnClickListener(this :: onButtonClick);
        breakfast.setOnClickListener(this :: onButtonClick);


        ViewCompat.setBackgroundTintList(allRecipe, ContextCompat.getColorStateList(this, R.color.green));

//      ------->  RecyclerView <-------

        RecyclerView rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));



        adapter=new Adapter_Recipe_Recycler(MainActivity.this,RecipeData.getRecipeData());
        rv.setAdapter(adapter);

    }

    private void onButtonClick(View view){

        Button clickedButton=(Button) view;

        // Reset background tint for all buttons
        ViewCompat.setBackgroundTintList(allRecipe, null);
        ViewCompat.setBackgroundTintList(lunch, null);
        ViewCompat.setBackgroundTintList(dinner, null);
        ViewCompat.setBackgroundTintList(tea, null);
        ViewCompat.setBackgroundTintList(breakfast, null);


        // Set background tint for the clicked button
        ViewCompat.setBackgroundTintList(clickedButton, ContextCompat.getColorStateList(this, R.color.green));

    }



}
