package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.AdminhistoryDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminHistory;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminLive;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminhistory;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminlive;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.ArrayList;

/**
 * Created by gerry eka on 11/7/2019.
 */

public class Adapter_adminhistory extends RecyclerView.Adapter<AdminhistoryDataViewHolder> {
    ArrayList<Model_adminhistory> list;
    Context context;

    public Adapter_adminhistory(ArrayList<Model_adminhistory> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public Adapter_adminhistory() {
    }

    @Override
    public AdminhistoryDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadminhistory, parent, false);

        return new AdminhistoryDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdminhistoryDataViewHolder holder, int position) {
        Model_adminhistory currentData = list.get(position);
        holder.idhistory.setText(currentData.getId());
        holder.name1.setText(currentData.getNama1());
        holder.name2.setText(currentData.getNama2());
        holder.setscore.setText(currentData.getSet_score());
        holder.setscore1.setText(currentData.getSet_score1());
        holder.setscore2.setText(currentData.getSet_score2());
        holder.score1set1.setText(currentData.getScore1set1());
        holder.score2set1.setText(currentData.getScore2set1());
        holder.score1set2.setText(currentData.getScore1set2());
        holder.score2set2.setText(currentData.getScore2set2());
        holder.score1set3.setText(currentData.getScore1set3());
        holder.score2set3.setText(currentData.getScore2set3());;

        holder.editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), EditAdminHistory.class);

                myIntent.putExtra("id_history", holder.idhistory.getText());
                myIntent.putExtra("name1", holder.name1.getText());
                myIntent.putExtra("name2", holder.name2.getText());
                myIntent.putExtra("setscore", holder.setscore.getText());
                myIntent.putExtra("setscore1", holder.setscore1.getText());
                myIntent.putExtra("setscore2", holder.setscore2.getText());
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


