package com.example.v.plants.adapter;

import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.v.plants.Ficus;
import com.example.v.plants.MainActivity;
import com.example.v.plants.R;

import java.util.List;

public class PlantRecyclerViewAdapter extends RecyclerView.Adapter<PlantRecyclerViewAdapter.PlantViewHolder> {
    public static class PlantViewHolder extends RecyclerView.ViewHolder{
        MaterialCardView plantCardView;
        //CardView plantCardView;
        ImageView plantImageView;
        TextView plantName;
        TextView plantLast;
        TextView plantNext;
        PlantViewHolder(View itemView){
            super(itemView);
            plantCardView=itemView.findViewById(R.id.plant_card_view);
            plantImageView=itemView.findViewById(R.id.plant_img);
            plantName=itemView.findViewById(R.id.plant_name);
            plantLast=itemView.findViewById(R.id.plant_last);
            plantNext=itemView.findViewById(R.id.plant_next);


        }
    }

    List<Ficus> plantArray;

    public PlantRecyclerViewAdapter(List<Ficus> plantArray){
        this.plantArray=plantArray;
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder,int position){
        holder.plantName.setText(plantArray.get(position).getName());
        holder.plantLast.setText(plantArray.get(position).getDateLastWatering().toString());
        holder.plantNext.setText(plantArray.get(position).getDateNextWatering().toString());
    }

    @NonNull @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_card,parent,false);
        PlantViewHolder plantViewHolder=new PlantViewHolder(view);
        return plantViewHolder;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public int getItemCount(){
        return plantArray.size();
    }


}
