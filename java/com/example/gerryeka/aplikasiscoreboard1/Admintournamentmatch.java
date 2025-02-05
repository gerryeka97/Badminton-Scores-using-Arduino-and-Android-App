package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.AdapterAdminPager;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.AdapterPager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Admintournamentmatch extends AppCompatActivity implements Admintourtab1.OnFragmentInteractionListener, Admintourtab2.OnFragmentInteractionListener, Admintourtab3.OnFragmentInteractionListener {

    String adminid_tournament;
    Button deleteadmintour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admintournamentmatch);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.adtablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Quarter"));
        tabLayout.addTab(tabLayout.newTab().setText("Semi"));
        tabLayout.addTab(tabLayout.newTab().setText("Final"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.adpager);
        final AdapterAdminPager adapterAdminPager = new AdapterAdminPager(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapterAdminPager);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        adminid_tournament = getIntent().getStringExtra("id_tournament");


        deleteadmintour = (Button) findViewById(R.id.deletetourbutton);
        deleteadmintour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTour();
            }
        });


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

        return adminid_tournament;

    }
    public void deleteTour(){
//        String url_final = "http://203.189.121.229:9000/loginapp/deleteadmintour.php";
//        String url_final = "http://192.168.0.19/loginapp/deleteadmintour.php";
        String url_final = "http://192.168.43.38/loginapp/deleteadmintour.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(Admintournamentmatch.this, jsonObject.getString("semualive"),
                            Toast.LENGTH_LONG).show();
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id_tournament",adminid_tournament);
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded,charset=utf-8";
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(postRequest);
        finish();
    }

    public void addtourmatch(View v){
        Intent myIntent = new Intent(getBaseContext(), AddAdminMatch.class);
        myIntent.putExtra("id_tournament", adminid_tournament);
        startActivity(myIntent);
    }
}
