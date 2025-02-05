package com.example.gerryeka.aplikasiscoreboard1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class TourmatchDataViewHolder extends RecyclerView.ViewHolder{
    public TextView matchid, tournamentid, tname1, tname2, tset_score1, tset_score2, round;

    public TourmatchDataViewHolder(View itemView) {
        super(itemView);
        matchid = itemView.findViewById(R.id.match_id);
        tournamentid = itemView.findViewById(R.id.idtournament);
        tname1 = itemView.findViewById(R.id.tname1);
        tname2 = itemView.findViewById(R.id.tname2);
        tset_score1 = itemView.findViewById(R.id.tscore1);
        tset_score2 = itemView.findViewById(R.id.tscore2);
        round = itemView.findViewById(R.id.round);
    }
}
