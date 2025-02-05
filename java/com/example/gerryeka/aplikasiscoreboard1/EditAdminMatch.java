package com.example.gerryeka.aplikasiscoreboard1;

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

public class EditAdminMatch extends AppCompatActivity {

    private EditText textmatchid;
    private EditText texttourid;
    private EditText texttournama1;
    private EditText texttournama2;
    private EditText texttoursetscore1;
    private EditText texttoursetscore2;
    private EditText texttourround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin_match);

        textmatchid = (EditText) findViewById(R.id.editmatchid);
        texttourid = (EditText) findViewById(R.id.edittourid);
        texttournama1 = (EditText) findViewById(R.id.edittournama1);
        texttournama2 = (EditText) findViewById(R.id.edittournama2);
        texttoursetscore1 = (EditText) findViewById(R.id.edittourscore1);
        texttoursetscore2 = (EditText) findViewById(R.id.edittourscore2);
        texttourround = (EditText) findViewById(R.id.editround);

        textmatchid.setText(getIntent().getExtras().getString("match_id",""));
        texttourid.setText(getIntent().getExtras().getString("id_tournament",""));
        texttournama1.setText(getIntent().getExtras().getString("tname1",""));
        texttournama2.setText(getIntent().getExtras().getString("tname2",""));
        texttoursetscore1.setText(getIntent().getExtras().getString("tsetscore1",""));
        texttoursetscore2.setText(getIntent().getExtras().getString("tsetscore2",""));
        texttourround.setText(getIntent().getExtras().getString("tround",""));

        Button editadminmatch = (Button) findViewById(R.id.edittourmatchbutton);
        editadminmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editMatch();
            }
        });
        Button deleteadminmatch = (Button) findViewById(R.id.deletetourmatchbutton);
        deleteadminmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMatch();
            }
        });

    }

    public void editMatch(){
//        String url_final = "http://203.189.121.229:9000/loginapp/editadminmatch.php";
//        String url_final = "http://192.168.0.19/loginapp/editadminmatch.php";
        String url_final = "http://192.168.43.38/loginapp/editadminmatch.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(EditAdminMatch.this, jsonObject.getString("semualive"),
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
                params.put("match_id",textmatchid.getText().toString());
                params.put("id_tournament", texttourid.getText().toString());
                params.put("tname1", texttournama1.getText().toString());
                params.put("tname2", texttournama2.getText().toString());
                params.put("tsetscore1", texttoursetscore1.getText().toString());
                params.put("tsetscore2", texttoursetscore2.getText().toString());
                params.put("tround", texttourround.getText().toString());
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


    public void deleteMatch(){
//        String url_final = "http://203.189.121.229:9000/loginapp/deleteadminmatch.php";
//        String url_final = "http://192.168.0.19/loginapp/deleteadminmatch.php";
        String url_final = "http://192.168.43.38/loginapp/deleteadminmatch.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(EditAdminMatch.this, jsonObject.getString("semualive"),
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
                params.put("match_id",textmatchid.getText().toString());
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
