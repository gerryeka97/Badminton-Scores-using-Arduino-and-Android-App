package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_admin;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_adminlive;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admin;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminlive;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class AdminList extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Model_admin> admins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list);
        recyclerView = findViewById(R.id.adminlistview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        admins = new ArrayList<Model_admin>();

        AdminList.JsonFetch jsonFetch = new AdminList.JsonFetch();
        jsonFetch.execute();

    }

    public class JsonFetch extends AsyncTask<String, String, String> {

        HttpURLConnection httpURLConnection = null;
        String mainfile;

        @Override
        protected String doInBackground(String... strings) {

            try {
//                URL url = new URL("http://192.168.0.19/loginapp/adminlist.php");
                URL url = new URL("http://192.168.43.38/loginapp/adminlist.php");
//                URL url = new URL("http://203.189.121.229:9000/loginapp/adminlist.php");

                admins.clear();
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);

                }
                mainfile = stringBuffer.toString();
                JSONArray parent = new JSONArray(mainfile);
                int i = 0;
                while (i <= parent.length()) {
                    JSONObject child = parent.getJSONObject(i);

                    String username = child.getString("username");
                    String password = child.getString("password");

                    admins.add(new Model_admin(username, password));

                    i++;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Adapter_admin adapter_admin = new Adapter_admin(admins,getApplicationContext());
            recyclerView.setAdapter(adapter_admin);
            refresh(5000);
        }
    }
    public void refresh(int miliseconds){
        final Handler handlerrefresh = new Handler() {
            @Override
            public void publish(LogRecord logRecord) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        };
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                AdminList.JsonFetch jsonFetch = new AdminList.JsonFetch();
                jsonFetch.execute();
            }
        };
        recyclerView.postDelayed(runnable,miliseconds);
    }

    public void addlistadmin(View v){
        Intent myIntent = new Intent(getBaseContext(), AddListAdmin.class);
        startActivity(myIntent);
    }
}
