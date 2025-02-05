package com.example.gerryeka.aplikasiscoreboard1.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gerryeka.aplikasiscoreboard1.AdminliveDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminLive;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminlive;
import com.example.gerryeka.aplikasiscoreboard1.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class Adapter_adminlive extends RecyclerView.Adapter<AdminliveDataViewHolder> {
    ArrayList<Model_adminlive> list;
    Context context;

    public Adapter_adminlive() {
    }

    public Adapter_adminlive(ArrayList<Model_adminlive> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public AdminliveDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadminlive, parent, false);

        return new AdminliveDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdminliveDataViewHolder holder, int position) {
        Model_adminlive currentData = list.get(position);
        holder.idlive.setText(currentData.getId());
        holder.name1.setText(currentData.getNama1());
        holder.name2.setText(currentData.getNama2());
        holder.setscore.setText(currentData.getSet_score());
        holder.setscore1.setText(currentData.getSet_score1());
        holder.setscore2.setText(currentData.getSet_score2());
        holder.score1.setText(currentData.getScore1());
        holder.score2.setText(currentData.getScore2());
        holder.score1set1.setText(currentData.getScore1set1());
        holder.score2set1.setText(currentData.getScore2set1());
        holder.score1set2.setText(currentData.getScore1set2());
        holder.score2set2.setText(currentData.getScore2set2());
        holder.score1set3.setText(currentData.getScore1set3());
        holder.score2set3.setText(currentData.getScore2set3());

        holder.editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), EditAdminLive.class);

                myIntent.putExtra("id_live", holder.idlive.getText());
                myIntent.putExtra("name1", holder.name1.getText());
                myIntent.putExtra("name2", holder.name2.getText());
                myIntent.putExtra("setscore", holder.setscore.getText());
                myIntent.putExtra("setscore1", holder.setscore1.getText());
                myIntent.putExtra("setscore2", holder.setscore2.getText());
                myIntent.putExtra("score1", holder.score1.getText());
                myIntent.putExtra("score2", holder.score2.getText());
                myIntent.putExtra("score1set1", holder.score1set1.getText());
                myIntent.putExtra("score2set1", holder.score2set1.getText());
                myIntent.putExtra("score1set2", holder.score1set2.getText());
                myIntent.putExtra("score2set2", holder.score2set2.getText());
                myIntent.putExtra("score1set3", holder.score1set3.getText());
                myIntent.putExtra("score2set3", holder.score2set3.getText());


                view.getContext().startActivity(myIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}