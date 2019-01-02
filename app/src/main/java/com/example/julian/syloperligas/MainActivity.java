package com.example.julian.syloperligas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import com.example.julian.syloperligas.ViewPagerFragments.Fragmento1;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento2;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento3;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento4;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento5;

public class MainActivity extends AppCompatActivity implements
        Fragmento1.OnFragmentInteractionListener,
        Fragmento2.OnFragmentInteractionListener,
        Fragmento3.OnFragmentInteractionListener,
        Fragmento4.OnFragmentInteractionListener,
        Fragmento5.OnFragmentInteractionListener {


    Spinner spinner2;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWPAGER Y ADAPTERS DEL VIEWPAGER / CON SECYIONADAPTER DE 5 PAGINAS SWITCHEABLES

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.idDelViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        //SPINNER QUE SE VISUALIZARIA EN EL FRAGMENT 2 DEL VIEWPAGER, COM STRING ARRAYS DE 15 ITEMS DE LAS FECHAS


        //AGREGAR ACCIONES A LOS 5 BOTONES DE LA NAVIGATION BOTTOM BAR
        BottomNavigationView BottomNavigationView = findViewById(R.id.navigationView);

        BottomNavigationView.setSelectedItemId(R.id.navigation1);


        //FLOATING ACTION BUTTON BACK, PARA VOLVER AL LAUNCHER

        FloatingActionButton back = findViewById(R.id.fab_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Launcher.class);
                startActivity(i);
            }


        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}















