package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourlist;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourmatch;
import com.example.gerryeka.aplikasiscoreboard1.R;
import com.example.gerryeka.aplikasiscoreboard1.TourlistDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.TourmatchDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.tournament_match;

import java.util.ArrayList;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class Adapter_tourmatch extends RecyclerView.Adapter<TourmatchDataViewHolder>{

    ArrayList<Model_tourmatch> list;
    Context context;

    public Adapter_tourmatch() {
    }

    public Adapter_tourmatch(ArrayList<Model_tourmatch> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TourmatchDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listtournamentmatch,parent,false);
        return new TourmatchDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TourmatchDataViewHolder holder, int position) {
        Model_tourmatch currentData = list.get(position);
        holder.matchid.setText(currentData.getMatchid());
        holder.tournamentid.setText(currentData.getTournament_id());
        holder.tname1.setText(currentData.getName1());
        holder.tname2.setText(currentData.getName2());
        holder.tset_score1.setText(currentData.getSet_score1());
        holder.tset_score2.setText(currentData.getSet_score2());
        holder.round.setText(currentData.getRound());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
