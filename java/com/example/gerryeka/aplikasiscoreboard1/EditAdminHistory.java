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

public class EditAdminHistory extends AppCompatActivity {

    private EditText textid;
    private EditText textnama1;
    private EditText textnama2;
    private EditText textsetscore;
    private EditText textsetscore1;
    private EditText textsetscore2;
    private EditText textscore1set1;
    private EditText textscore2set1;
    private EditText textscore1set2;
    private EditText textscore2set2;
    private EditText textscore1set3;
    private EditText textscore2set3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin_history);

        textid = (EditText) findViewById(R.id.editidhistory);
        textnama1 = (EditText) findViewById(R.id.edithistorynama1);
        textnama2 = (EditText) findViewById(R.id.edithistorynama2);
        textsetscore = (EditText) findViewById(R.id.edithistorysetscore);
        textsetscore1 = (EditText) findViewById(R.id.edithistorysetscore1);
        textsetscore2 = (EditText) findViewById(R.id.edithistorysetscore2);
        textscore1set1 = (EditText) findViewById(R.id.edithistoryscore1set1);
        textscore2set1 = (EditText) findViewById(R.id.edithistoryscore2set1);
        textscore1set2 = (EditText) findViewById(R.id.edithistoryscore1set2);
        textscore2set2 = (EditText) findViewById(R.id.edithistoryscore2set2);
        textscore1set3 = (EditText) findViewById(R.id.edithistoryscore1set3);
        textscore2set3 = (EditText) findViewById(R.id.edithistoryscore2set3);

        textid.setText(getIntent().getExtras().getString("id_history",""));
        textnama1.setText(getIntent().getExtras().getString("name1",""));
        textnama2.setText(getIntent().getExtras().getString("name2",""));
        textsetscore.setText(getIntent().getExtras().getString("setscore",""));
        textsetscore1.setText(getIntent().getExtras().getString("setscore1",""));
        textsetscore2.setText(getIntent().getExtras().getString("setscore2",""));
        textscore1set1.setText(getIntent().getExtras().getString("score1set1",""));
        textscore2set1.setText(getIntent().getExtras().getString("score2set1",""));
        textscore1set2.setText(getIntent().getExtras().getString("score1set2",""));
        textscore2set2.setText(getIntent().getExtras().getString("score2set2",""));
        textscore1set3.setText(getIntent().getExtras().getString("score1set3",""));
        textscore2set3.setText(getIntent().getExtras().getString("score2set3",""));

        Button editadminhistory = (Button) findViewById(R.id.edithistorybutton);
        editadminhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editHistory();
            }
        });
        Button deleteadminhistory = (Button) findViewById(R.id.deletehistorybutton);
        deleteadminhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteHistory();
            }
        });
    }
    public void editHistory(){
//        String url_final = "http://203.189.121.229:9000/loginapp/editadminhistory.php";
//        String url_final = "http://192.168.0.19/loginapp/editadminhistory.php";
        String url_final = "http://192.168.43.38/loginapp/editadminhistory.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(EditAdminHistory.this, jsonObject.getString("semualive"),
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
                params.put("id_history",textid.getText().toString());
                params.put("name1", textnama1.getText().toString());
                params.put("name2", textnama2.getText().toString());
                params.put("setscore", textsetscore.getText().toString());
                params.put("setscore1", textsetscore1.getText().toString());
                params.put("setscore2", textsetscore2.getText().toString());
                params.put("score1set1", textscore1set1.getText().toString());
                params.put("score2set1", textscore2set1.getText().toString());
                params.put("score1set2", textscore1set2.getText().toString());
                params.put("score2set2", textscore2set2.getText().toString());
                params.put("score1set3", textscore1set3.getText().toString());
                params.put("score2set3", textscore2set3.getText().toString());
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

    public void deleteHistory(){
//        String url_final = "http://203.189.121.229:9000/loginapp/deleteadminhistory.php";
//        String url_final = "http://192.168.0.19/loginapp/deleteadminhistory.php";
        String url_final = "http://192.168.43.38/loginapp/deleteadminhistory.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url_final, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(EditAdminHistory.this, jsonObject.getString("semualive"),
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
                params.put("id_history",textid.getText().toString());
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
