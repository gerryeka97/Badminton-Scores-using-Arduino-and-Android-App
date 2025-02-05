package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.AdmintourmatchDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminLive;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminMatch;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admintourmatch;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourmatch;
import com.example.gerryeka.aplikasiscoreboard1.R;
import com.example.gerryeka.aplikasiscoreboard1.TourmatchDataViewHolder;

import java.util.ArrayList;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class Adapter_admintourmatch extends RecyclerView.Adapter<AdmintourmatchDataViewHolder> {

    ArrayList<Model_admintourmatch> list;
    Context context;

    public Adapter_admintourmatch() {
    }

    public Adapter_admintourmatch(ArrayList<Model_admintourmatch> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public AdmintourmatchDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadmintournamentmatch,parent,false);
        return new AdmintourmatchDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdmintourmatchDataViewHolder holder, int position) {
        Model_admintourmatch currentData = list.get(position);
        holder.adminmatchid.setText(currentData.getMatchid());
        holder.admintournamentid.setText(currentData.getTournament_id());
        holder.admintname1.setText(currentData.getName1());
        holder.admintname2.setText(currentData.getName2());
        holder.admintset_score1.setText(currentData.getSet_score1());
        holder.admintset_score2.setText(currentData.getSet_score2());
        holder.adminround.setText(currentData.getRound());
       holder.admineditmatchbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(view.getContext(), EditAdminMatch.class);

               myIntent.putExtra("match_id", holder.adminmatchid.getText());
               myIntent.putExtra("id_tournament", holder.admintournamentid.getText());
               myIntent.putExtra("tname1", holder.admintname1.getText());
               myIntent.putExtra("tname2", holder.admintname2.getText());
               myIntent.putExtra("tsetscore1", holder.admintset_score1.getText());
               myIntent.putExtra("tsetscore2", holder.admintset_score2.getText());
               myIntent.putExtra("tround", holder.adminround.getText());

               view.getContext().startActivity(myIntent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
