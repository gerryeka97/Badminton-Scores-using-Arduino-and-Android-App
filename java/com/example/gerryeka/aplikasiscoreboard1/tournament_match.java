package com.example.gerryeka.aplikasiscoreboard1;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.AdapterPager;

public class tournament_match extends AppCompatActivity implements Tourtab1.OnFragmentInteractionListener, Tourtab2.OnFragmentInteractionListener, Tourtab3.OnFragmentInteractionListener{

    String id_tournament,tourname1, tourname2, tourround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_match);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Quarter"));
        tabLayout.addTab(tabLayout.newTab().setText("Semi"));
        tabLayout.addTab(tabLayout.newTab().setText("Final"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final AdapterPager adapterPager = new AdapterPager(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapterPager);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        id_tournament = getIntent().getStringExtra("id_tournament");
//        tourname1 = getIntent().getStringExtra("tname1");
//        tourname2 = getIntent().getStringExtra("tname2");
//        tourround = getIntent().getStringExtra("round");


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public String getidtournament(){


        return id_tournament;

    }

//    public String gettourname1(){
//
//
//        return tourname1;
//
//    }
//    public String gettourname2(){
//
//
//        return tourname2;
//
//    }
//    public String gettourround(){
//
//
//        return tourround;
//
//    }

}
