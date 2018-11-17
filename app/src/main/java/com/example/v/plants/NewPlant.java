package com.example.v.plants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class NewPlant extends AppCompatActivity {
    private EditText et;
    Ficus f;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);
    }
    public void Add(View view){

        et=(EditText)findViewById(R.id.editText2);
        et.getText();
        f=new Ficus(et.getText().toString(),new Date(),new Date());
        //TextView tw=(TextView)findViewById(R.id.textView);
        //tw.setText(f.getName()+" "+f.getDateLastWatering().toString());
        Intent n=new Intent(this,MainActivity.class);
        n.putExtra("name",f.getName());
        n.putExtra("last",f.getDateLastWatering());
        n.putExtra("next",f.getDateNextWatering());
        startActivity(n);
    }
}
