package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gerryeka.aplikasiscoreboard1.Admintourtab1;
import com.example.gerryeka.aplikasiscoreboard1.Admintourtab2;
import com.example.gerryeka.aplikasiscoreboard1.Admintourtab3;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab1;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab2;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab3;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class AdapterAdminPager extends FragmentStatePagerAdapter {

    int NoOfTabs;

    public AdapterAdminPager(FragmentManager fm,int Numberoftabs) {
        super(fm);
        this.NoOfTabs = Numberoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Admintourtab1 admintourtab1 = new Admintourtab1();
                return admintourtab1;
            case 1:
                Admintourtab2 admintourtab2 = new Admintourtab2();
                return admintourtab2;
            case 2:
                Admintourtab3 admintourtab3 = new Admintourtab3();
                return admintourtab3;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
