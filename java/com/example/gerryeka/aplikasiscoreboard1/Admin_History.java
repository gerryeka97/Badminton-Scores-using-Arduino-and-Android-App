package com.example.gerryeka.aplikasiscoreboard1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_adminhistory;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminhistory;

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

public class Admin_History extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Model_adminhistory> adminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__history);
        recyclerView = findViewById(R.id.adminhistoryview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adminList = new ArrayList<Model_adminhistory>();

        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();
    }
    public class JsonFetch extends AsyncTask<String,String,String> {

        HttpURLConnection httpURLConnection = null;
        String mainfile;
        @Override
        protected String doInBackground(String... strings) {

            try {
//                URL url = new URL("http://203.189.121.229:9000/loginapp/adminhistory.php");
//                URL url = new URL("http://192.168.0.19/loginapp/adminhistory.php");
                URL url = new URL("http://192.168.43.38/loginapp/adminhistory.php");
                adminList.clear();
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);

                }
                mainfile = stringBuffer.toString();
                JSONArray parent = new JSONArray(mainfile);
                int i = 0;
                while(i <= parent.length()){
                    JSONObject child = parent.getJSONObject(i);

                    String id = child.getString("id_history");
                    String name1 = child.getString("name1");
                    String name2 = child.getString("name2");
                    String setscore = child.getString("set_score");
                    String setscore1 = child.getString("set_score1");
                    String setscore2 = child.getString("set_score2");
                    String score1set1 = child.getString("score1set1");
                    String score2set1 = child.getString("score2set1");
                    String score1set2 = child.getString("score1set2");
                    String score2set2 = child.getString("score2set2");
                    String score1set3 = child.getString("score1set3");
                    String score2set3 = child.getString("score2set3");


                    adminList.add(new Model_adminhistory(id,name1,name2,setscore,setscore1,setscore2,score1set1,score2set1,score1set2,score2set2,score1set3,score2set3));

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
            Adapter_adminhistory adapter_adminhistory = new Adapter_adminhistory(adminList,getApplicationContext());
            recyclerView.setAdapter(adapter_adminhistory);
            refresh(10000);
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
                    Admin_History.JsonFetch jsonFetch = new Admin_History.JsonFetch();
                    jsonFetch.execute();
                }
            };
            recyclerView.postDelayed(runnable,miliseconds);
        }


    }
}
