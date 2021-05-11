package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvThing;
    private PlantAdapter plantAdapter;
    private ArrayList<Plant> plants;
    public static ArrayList<Plant> plantsChoosen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_01);
        rcvThing=findViewById(R.id.rcvThing);
        plantsChoosen=new ArrayList<>();
        plants=new ArrayList<>();
        plants.add(new Plant("Shadow Plants","230 types","25",R.drawable.removebg_flower));
        plants.add(new Plant("Green Plants","250 types","30",R.drawable.removebg_plant_a));
        plants.add(new Plant("Leaf No Purple","230 types","40",R.drawable.removebg_flower));

        plantAdapter=new PlantAdapter(this,plants);
        rcvThing.setAdapter(plantAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvThing.setLayoutManager(linearLayoutManager);

        Button btnSeeTheList = findViewById(R.id.btnSeeTheList);
        Button btnSearch = findViewById(R.id.btnSearch);
       EditText textSearch = findViewById(R.id.edtSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filter = textSearch.getText().toString();
                if (filter!=null){
                    ArrayList<Plant> list=(ArrayList<Plant>) plants.stream().filter(x->x.getName().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
                    PlantAdapter adapter=(PlantAdapter) rcvThing.getAdapter();
                    adapter.setPlants(list);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btnSeeTheList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity02.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("plants",plantsChoosen);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });

    }





}