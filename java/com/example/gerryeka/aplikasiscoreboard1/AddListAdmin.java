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

public class AddListAdmin extends AppCompatActivity {
    private EditText textuser;
    private EditText textpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list_admin);

        textuser = (EditText) findViewById(R.id.adduser);
        textpass = (EditText) findViewById(R.id.addpass);

        Button addlistadmin = (Button) findViewById(R.id.addadminbutton);
        addlistadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListadmin();
            }
        });
    }

    public void addListadmin(){
//        String url_final = "http://192.168.0.19/loginapp/addlistadmin.php";
        String url_final = "http://192.168.43.38/loginapp/addlistadmin.php";
//        String url_final = "http://203.189.121.229:9000/loginapp/addlistadmin.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(AddListAdmin.this, jsonObject.getString("semualive"),
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
                params.put("username", textuser.getText().toString());
                params.put("password", textpass.getText().toString());
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
