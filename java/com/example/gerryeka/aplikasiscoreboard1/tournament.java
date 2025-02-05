package com.example.gerryeka.aplikasiscoreboard1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_admin;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_tourlist;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admin;
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
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class tournament extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Model_tourlist> tourlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);
        recyclerView = findViewById(R.id.tournamentlistview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tourlists = new ArrayList<Model_tourlist>();

        tournament.JsonFetch jsonFetch = new tournament.JsonFetch();
        jsonFetch.execute();

    }

    public class JsonFetch extends AsyncTask<String, String, String> {

        HttpURLConnection httpURLConnection = null;
        String mainfile;

        @Override
        protected String doInBackground(String... strings) {

            try {
//                URL url = new URL("http://192.168.0.19/loginapp/listtournament.php");
                URL url = new URL("http://192.168.43.38/loginapp/listtournament.php");
//                URL url = new URL("http://203.189.121.229:9000/loginapp/listtournament.php");

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


                    tourlists.add(new Model_tourlist(tourid, tourname));

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
            Adapter_tourlist adapter_tourlist = new Adapter_tourlist(tourlists,getApplicationContext());
            recyclerView.setAdapter(adapter_tourlist);
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
                tournament.JsonFetch jsonFetch = new tournament.JsonFetch();
                jsonFetch.execute();
            }
        };
        recyclerView.postDelayed(runnable,miliseconds);
    }
}
