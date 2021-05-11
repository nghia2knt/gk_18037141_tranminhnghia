package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity02 extends AppCompatActivity {
    private RecyclerView rcvThing;
    private PlantAdapter02 plantAdapter;
    private ArrayList<Plant> plants;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_02);
        rcvThing=findViewById(R.id.rcvThing02);
      //  plants=MainActivity.plantsChoosen;
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            ArrayList<Plant> plants= (ArrayList<Plant>)  bundle.getSerializable("plants");
            this.plants=plants;
        }
        plantAdapter=new PlantAdapter02(this,plants);
        rcvThing.setAdapter(plantAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvThing.setLayoutManager(linearLayoutManager);
    }
}
