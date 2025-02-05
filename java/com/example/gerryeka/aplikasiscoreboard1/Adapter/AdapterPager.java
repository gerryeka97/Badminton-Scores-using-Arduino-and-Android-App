package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gerryeka.aplikasiscoreboard1.Tourtab1;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab2;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab3;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class AdapterPager extends FragmentStatePagerAdapter {

    int NoOfTabs;

    public AdapterPager(FragmentManager fm, int Numberoftabs) {
        super(fm);
        this.NoOfTabs = Numberoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tourtab1 tourtab1 = new Tourtab1();
                return tourtab1;
            case 1:
                Tourtab2 tourtab2 = new Tourtab2();
                return tourtab2;
            case 2:
                Tourtab3 tourtab3 = new Tourtab3();
                return tourtab3;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
