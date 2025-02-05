package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class adminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);
    }

    public void livebutton(View v){
        Intent myIntent = new Intent(getBaseContext(), Admin_Live.class);
        startActivity(myIntent);
    }
    public void historybutton(View v){
        Intent myIntent = new Intent(getBaseContext(), Admin_History.class);
        startActivity(myIntent);
    }

    public void adminlist(View v){
        Intent myIntent = new Intent(getBaseContext(), AdminList.class);
        startActivity(myIntent);
    }

    public void admintournament(View v){
        Intent myIntent = new Intent(getBaseContext(), Admintournament.class);
        startActivity(myIntent);
    }
}
