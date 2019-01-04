package com.example.julian.syloperligas;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class Launcher extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);


        Spinner spinner;
        spinner = findViewById(R.id.spinner);
        ImageView syloperlogo = findViewById(R.id.syloperlogo);
        CardView cardviewspinner = findViewById(R.id.cardviewspinner);
        CardView cardviewseleccionar = findViewById(R.id.seleccionar);


        AnimationUtils.enterTop(syloperlogo, 900);

        AnimationUtils.enterRight(cardviewseleccionar, 1000);

        AnimationUtils.enterLeft(cardviewspinner, 1100);




        ArrayAdapter<String> adapter = new ArrayAdapter<>(Launcher.this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.spinner_ligas));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                Toast.makeText(adapterView.getContext(),
                        (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });

        CardView Seleccionar = findViewById(R.id.seleccionar);
        Seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Launcher.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

