package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddAdminMatch extends AppCompatActivity {

    private EditText textnamam1;
    private EditText textnamam2;
    private EditText textscorem1;
    private EditText textscorem2;
    private EditText textround;
    String adminid_tournament;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin_match);

        adminid_tournament = getIntent().getStringExtra("id_tournament");

        textnamam1 = (EditText) findViewById(R.id.taddnama1);
        textnamam2 = (EditText) findViewById(R.id.taddnama2);
        textscorem1 = (EditText) findViewById(R.id.taddsetscore1);
        textscorem2 = (EditText) findViewById(R.id.taddsetscore2);
        textround = (EditText) findViewById(R.id.taddround);

        Button addtourmatch = (Button) findViewById(R.id.addmatchbutton);
        addtourmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addmatch();
            }
        });


    }

    public void addmatch(){
//        String url_final = "http://192.168.0.19/loginapp/addtourmatch.php";
        String url_final = "http://192.168.43.38/loginapp/addtourmatch.php";
//        String url_final = "http://203.189.121.229:9000/loginapp/addtourmatch.php";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(AddAdminMatch.this, jsonObject.getString("semualive"),
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
                params.put("tname1", textnamam1.getText().toString());
                params.put("tname2", textnamam2.getText().toString());
                params.put("tsetscore1", textscorem1.getText().toString());
                params.put("tsetscore2", textscorem2.getText().toString());
                params.put("round", textround.getText().toString());

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
}
