package com.example.gerryeka.aplikasiscoreboard1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class TourlistDataViewHolder extends RecyclerView.ViewHolder {
    public TextView tournamentname, tournamentid;
    public Button viewbutton;

    public TourlistDataViewHolder(View itemView) {
        super(itemView);
        tournamentname = itemView.findViewById(R.id.tournament_name);
        tournamentid = itemView.findViewById(R.id.tournament_id);
        viewbutton = itemView.findViewById(R.id.viewtourbutton);
    }
}
