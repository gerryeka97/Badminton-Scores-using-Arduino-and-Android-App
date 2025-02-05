package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginbutton(View v){
        Intent myIntent = new Intent(getBaseContext(), Loginscreen.class);
        startActivity(myIntent);
    }
    public void livebutton(View v){
        Intent myIntent = new Intent(getBaseContext(), LiveMatches.class);
        startActivity(myIntent);
    }
    public void historybutton(View v){
        Intent myIntent = new Intent(getBaseContext(), HistoryMatches.class);
        startActivity(myIntent);
    }

    public void tournamentbutton(View v){
        Intent myIntent = new Intent(getBaseContext(), tournament.class);
        startActivity(myIntent);
    }
}
