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

public class AddAdminLive extends AppCompatActivity {

    private EditText textnama1;
    private EditText textnama2;
    private EditText textsetscore;
    private EditText textsetscore1;
    private EditText textsetscore2;
    private EditText textscore1;
    private EditText textscore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin_live);

        textnama1 = (EditText) findViewById(R.id.addnama1);
        textnama2 = (EditText) findViewById(R.id.addnama2);
        textsetscore = (EditText) findViewById(R.id.addsetscore);
        textsetscore1 = (EditText) findViewById(R.id.addsetscore1);
        textsetscore2 = (EditText) findViewById(R.id.addsetscore2);
        textscore1 = (EditText) findViewById(R.id.addscore1);
        textscore2 = (EditText) findViewById(R.id.addscore2);

        Button addadminlive = (Button) findViewById(R.id.addmatchbutton);
        addadminlive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLive();
            }
        });

    }
    public void addLive(){

//        String url_final = "http://192.168.0.19/loginapp/addadminlive.php";
        String url_final = "http://192.168.43.38/loginapp/addadminlive.php";
//        String url_final = "http://203.189.121.229:9000/loginapp/addadminlive.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(AddAdminLive.this, jsonObject.getString("semualive"),
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
                params.put("name1", textnama1.getText().toString());
                params.put("name2", textnama2.getText().toString());
                params.put("setscore", textsetscore.getText().toString());
                params.put("setscore1", textsetscore1.getText().toString());
                params.put("setscore2", textsetscore2.getText().toString());
                params.put("score1", textscore1.getText().toString());
                params.put("score2", textscore2.getText().toString());
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
