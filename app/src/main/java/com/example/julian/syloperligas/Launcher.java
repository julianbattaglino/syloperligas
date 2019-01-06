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
import android.widget.TextView;

public class Launcher extends AppCompatActivity {

    boolean isLigaSelected = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);


        TextView poweredby = findViewById(R.id.powered);
        TextView dharma = findViewById(R.id.dharma);


        ImageView syloperlogo = findViewById(R.id.syloperlogo);
        CardView cardviewspinner = findViewById(R.id.cardviewspinner);
        Spinner spinner = findViewById(R.id.spinner);

        AnimationUtils.enterTop(syloperlogo, 1000);
        AnimationUtils.landMe(syloperlogo, 2000);

        AnimationUtils.enterLeft(cardviewspinner, 1500);

        AnimationUtils.enterLeft(poweredby, 2200);
        AnimationUtils.enterLeft(dharma, 2000);
        AnimationUtils.rotateX(dharma, 2200);


        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinner_divisiones)));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                if (isLigaSelected) {
                    openMainActivity(pos);
                }
                isLigaSelected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }

    private void openMainActivity(int pos) {
        //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Launcher.this, MainActivity.class);
        i.putExtra("division", pos);
        startActivity(i);
    }
}

