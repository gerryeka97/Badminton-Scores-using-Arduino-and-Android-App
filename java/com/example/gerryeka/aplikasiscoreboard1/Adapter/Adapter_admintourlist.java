package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.AdmintourlistDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Admintournamentmatch;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admintourlist;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourlist;
import com.example.gerryeka.aplikasiscoreboard1.R;
import com.example.gerryeka.aplikasiscoreboard1.TourlistDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.tournament_match;

import java.util.ArrayList;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class Adapter_admintourlist extends RecyclerView.Adapter<AdmintourlistDataViewHolder> {
    ArrayList<Model_admintourlist> list;
    Context context;

    public Adapter_admintourlist() {
    }

    public Adapter_admintourlist(ArrayList<Model_admintourlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public AdmintourlistDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadmintournament,parent,false);
        return new AdmintourlistDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdmintourlistDataViewHolder holder, int position) {
        Model_admintourlist currentData = list.get(position);
        holder.admintournamentid.setText(currentData.getIdtour());
        holder.admintournamentname.setText(currentData.getNametour());
        holder.adminviewbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Admintournamentmatch.class);

                myIntent.putExtra("id_tournament", holder.admintournamentid.getText());

                view.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
