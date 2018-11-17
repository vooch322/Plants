package com.example.v.plants;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.v.plants.adapter.PlantRecyclerViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView last;
    private TextView next;
    RecyclerView mPlantRecyclerView;
    RecyclerView.Adapter mPlantRecyclerViewAdapter;
    List<Ficus> plantArray;


    Ficus f=new Ficus("Игорь",new Date(2018,5,19),new Date(2018,5,19));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ficus f=new Ficus("Игорь",new Date(2018,5,19),new Date(2018,5,19));
        SimpleDateFormat form=new SimpleDateFormat("dd.MM.yyyy");
        name=(TextView)findViewById(R.id.Name);
        last=(TextView)findViewById(R.id.Last);
        next=(TextView)findViewById(R.id.Next);
        name.setText("Имя растения "+f.getName());
        f.Watering();
//        last.setText("Последний "+form.format(f.getDateLastWatering()));
  //      next.setText("Следующий "+form.format(f.getDateNextWatering()));
        if(getIntent().getStringExtra("name")!=null){
            f=new Ficus(getIntent().getStringExtra("name"),new Date(),new Date());
            name.setText("Имя растения "+f.getName());
            last.setText("Последний "+form.format(f.getDateLastWatering()));
            f.Watering();
            next.setText("Следующий "+form.format(f.getDateNextWatering()));
        }


        createPlantArray();
        mPlantRecyclerView=findViewById(R.id.plant_recycler_view);
        mPlantRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        mPlantRecyclerView.setLayoutManager(linearLayoutManager);
        mPlantRecyclerViewAdapter=new PlantRecyclerViewAdapter(plantArray);
        mPlantRecyclerView.setAdapter(mPlantRecyclerViewAdapter);
    }
    public void Watter(View view){
        //Ficus f=new Ficus("Игорь",new Date(2018,5,19),new Date(2018,5,19));
        SimpleDateFormat form=new SimpleDateFormat("dd.MM.yyyy");
        name=(TextView)findViewById(R.id.Name);
        last=(TextView)findViewById(R.id.Last);
        next=(TextView)findViewById(R.id.Next);
        name.setText("Имя растения "+f.getName());
        f.Watering();
        last.setText("Последний "+form.format(f.getDateLastWatering()));
        next.setText("Следующий "+form.format(f.getDateNextWatering()));
    }
    public void New(View view){
        Intent in=new Intent(".NewPlant");
        startActivity(in);
    }

    private void createPlantArray(){
        plantArray=new ArrayList<>();
        plantArray.add(new Ficus("MMMM",new Date(),new Date()));
        plantArray.add(new Ficus("MM2",new Date(),new Date()));
        plantArray.add(new Ficus("MM3",new Date(),new Date()));
        plantArray.add(new Ficus("MM4",new Date(),new Date()));
        plantArray.add(new Ficus("MM5",new Date(),new Date()));
    }
}
