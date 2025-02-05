package com.example.gerryeka.aplikasiscoreboard1.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gerryeka.aplikasiscoreboard1.HistoryDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_history;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.ArrayList;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class Adapter_history extends RecyclerView.Adapter<HistoryDataViewHolder>{

    ArrayList<Model_history> list;
    Context context;

    public Adapter_history() {
    }

    public Adapter_history(ArrayList<Model_history> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public HistoryDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listhistorymatch,parent,false);


        return new HistoryDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryDataViewHolder holder, int position) {
        Model_history currentData = list.get(position);
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
        holder.score2set3.setText(currentData.getScore2set3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
