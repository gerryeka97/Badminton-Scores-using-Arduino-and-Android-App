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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Loginscreen extends AppCompatActivity {

    Button btn_login;
    EditText et_username,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        btn_login = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    public void login() {
//        StringRequest request = new StringRequest(Request.Method.POST,"http://203.189.121.229:9000/loginapp/login.php",
//        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.0.19/loginapp/login.php",
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.43.38/loginapp/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.contains("1")) {
                            startActivity(new Intent(getApplicationContext(), adminpage.class));
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Wrong username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("username",et_username.getText().toString());
                params.put("password", et_password.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }
}
