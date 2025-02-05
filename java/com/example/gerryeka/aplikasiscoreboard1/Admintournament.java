package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_admintourlist;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_tourlist;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admintourlist;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourlist;

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

public class Admintournament extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Model_admintourlist> tourlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admintournament);

        recyclerView = findViewById(R.id.admintournamentlistview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tourlists = new ArrayList<Model_admintourlist>();

        Admintournament.JsonFetch jsonFetch = new Admintournament.JsonFetch();
        jsonFetch.execute();
    }
    public class JsonFetch extends AsyncTask<String, String, String> {

        HttpURLConnection httpURLConnection = null;
        String mainfile;

        @Override
        protected String doInBackground(String... strings) {

            try {
//                URL url = new URL("http://192.168.0.19/loginapp/adminlisttournament.php");
                URL url = new URL("http://192.168.43.38/loginapp/adminlisttournament.php");
//                URL url = new URL("http://203.189.121.229:9000/loginapp/adminlisttournament.php");

                tourlists.clear();
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
                    String tourid = child.getString("id_tournament");
                    String tourname = child.getString("tournament_name");


                    tourlists.add(new Model_admintourlist(tourid, tourname));

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
            Adapter_admintourlist adapter_admintourlist = new Adapter_admintourlist(tourlists,getApplicationContext());
            recyclerView.setAdapter(adapter_admintourlist);

        }

    }

    public void addtourbutton(View v){
        Intent myIntent = new Intent(getBaseContext(), AddAdmintournament.class);
        startActivity(myIntent);
    }
}
