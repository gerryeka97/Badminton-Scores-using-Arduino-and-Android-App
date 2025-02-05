package com.example.gerryeka.aplikasiscoreboard1.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.LiveDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_live;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.ArrayList;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class Adapter_live extends RecyclerView.Adapter<LiveDataViewHolder>{

    ArrayList<Model_live> list;
    Context context;

    public Adapter_live() {
    }

    public Adapter_live(ArrayList<Model_live> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public LiveDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listlivematch,parent,false);


        return new LiveDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LiveDataViewHolder holder, int position) {
        Model_live currentData = list.get(position);
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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
