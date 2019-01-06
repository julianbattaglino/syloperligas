package com.example.julian.syloperligas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.julian.syloperligas.ViewPagerFragments.Fragmento1;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento2;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento3;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento4;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento5;
import com.example.julian.syloperligas.ViewPagerFragments.Fragmento6;

/**
 * Created by Santiago Battaglino.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragmento1();
            case 1:
                return new Fragmento2();
            case 2:
                return new Fragmento3();
            case 3:
                return new Fragmento4();
            case 4:
                return new Fragmento5();
            case 5:
                return new Fragmento6();

            default:
                return new Fragmento1();
        }


    }

    @Override
    public int getCount() {
        return 6;
    }
}


