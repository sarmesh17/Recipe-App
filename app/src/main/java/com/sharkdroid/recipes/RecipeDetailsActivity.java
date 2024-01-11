package com.sharkdroid.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recipedetail);

        TextView head=findViewById(R.id.head);
        ImageView recipeImg=findViewById(R.id.recipeView);
        TextView des=findViewById(R.id.desView);


        Intent intent=getIntent();
        String title=intent.getStringExtra("recipeName");
        int img=intent.getIntExtra("recipeImageResource",R.drawable.biryani);
        String description=intent.getStringExtra("recipeDescription");


        //Display recipe detail

        head.setText(title);
        recipeImg.setImageResource(img);
        des.setText(description);






    }
}
