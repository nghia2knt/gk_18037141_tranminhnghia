package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantAdapter02 extends RecyclerView.Adapter<PlantAdapter02.ThingViewHolder>  {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Plant> plants;
    public PlantAdapter02(Context context, ArrayList<Plant> plants) {
        layoutInflater=LayoutInflater.from(context);
        this.context = context;
        this.plants = plants;
    }
    @NonNull
    @Override
    public PlantAdapter02.ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.from(context).inflate(R.layout.item_02,parent,false);
        return new PlantAdapter02.ThingViewHolder(view,this);

    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter02.ThingViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.tvName.setText(plant.getName());
        holder.tvPrice.setText("$" + plant.getPrice());
        holder.imgThing.setImageResource(plant.getImage());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                MainActivity.plantsChoosen.add(plants.get(position));
                Toast.makeText(view.getContext(), "ADD: " + plants.get(position).getName()+" to the list!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public class ThingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName,tvPrice;
        ImageView imgThing;
        private ItemClickListener itemClickListener;
        PlantAdapter02 plantAdapter;
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }
        public ThingViewHolder(@NonNull View itemView, PlantAdapter02 adapter) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName2);
            tvPrice=itemView.findViewById(R.id.tvPrice2);
            imgThing=itemView.findViewById(R.id.imgThing2);
            this.plantAdapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }
    }
}
