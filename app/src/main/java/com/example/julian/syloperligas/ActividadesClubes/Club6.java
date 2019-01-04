package com.example.julian.syloperligas.ActividadesClubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.julian.syloperligas.AnimationUtils;
import com.example.julian.syloperligas.R;

public class Club6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club6);

        ImageView united = findViewById(R.id.united);
        AnimationUtils.enterTop(united, 1000);

    }
}