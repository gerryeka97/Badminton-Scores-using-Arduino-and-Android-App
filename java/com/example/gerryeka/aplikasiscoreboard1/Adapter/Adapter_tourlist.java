package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.LiveDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_live;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourlist;
import com.example.gerryeka.aplikasiscoreboard1.R;
import com.example.gerryeka.aplikasiscoreboard1.TourlistDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Tourtab1;
import com.example.gerryeka.aplikasiscoreboard1.tournament_match;

import java.util.ArrayList;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class Adapter_tourlist extends RecyclerView.Adapter<TourlistDataViewHolder>{

    ArrayList<Model_tourlist> list;
    Context context;

    public Adapter_tourlist() {
    }

    public Adapter_tourlist(ArrayList<Model_tourlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TourlistDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listtournament,parent,false);
        return new TourlistDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TourlistDataViewHolder holder, int position) {
        Model_tourlist currentData = list.get(position);
        holder.tournamentid.setText(currentData.getIdtour());
        holder.tournamentname.setText(currentData.getNametour());
        holder.viewbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), tournament_match.class);

                myIntent.putExtra("id_tournament", holder.tournamentid.getText());

                view.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
