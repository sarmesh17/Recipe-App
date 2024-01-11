package com.sharkdroid.recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Recipe_Recycler extends RecyclerView.Adapter<Adapter_Recipe_Recycler.viewHolder> {

Context context;
ArrayList<DataStructure> arrData;

public Adapter_Recipe_Recycler(Context context, ArrayList<DataStructure> arrData){

    this.context=context;
    this.arrData=arrData;

}



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View v= LayoutInflater.from(context).inflate(R.layout.recipe_model,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    holder.img.setImageResource(arrData.get(position).img);
   holder.header.setText(arrData.get(position).header);
    holder.sub_header.setText(arrData.get(position).sub_header);

   int updatedPosition=holder.getLayoutPosition();

   holder.recipeCard.setOnClickListener(v -> {

       String recipeName=arrData.get(updatedPosition).header;
       int img=arrData.get(updatedPosition).img;
       String des=arrData.get(updatedPosition).description;

       Intent intent=new Intent(context, RecipeDetailsActivity.class);
       intent.putExtra("recipeName",recipeName);
       intent.putExtra("recipeImageResource",img);
       intent.putExtra("recipeDescription", des);

       context.startActivity(intent);

   });




    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView header,sub_header;
        LinearLayout recipeCard;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.foodImg);
            header=itemView.findViewById(R.id.foodTitle);
            sub_header=itemView.findViewById(R.id.foodSubTitle);
            recipeCard=itemView.findViewById(R.id.recipeCard);

        }
    }

}
