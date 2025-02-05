package com.example.gerryeka.aplikasiscoreboard1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class AdmintourmatchDataViewHolder extends RecyclerView.ViewHolder{
    public TextView adminmatchid, admintournamentid, admintname1, admintname2, admintset_score1, admintset_score2, adminround;
    public Button admineditmatchbutton;

    public AdmintourmatchDataViewHolder(View itemView) {
        super(itemView);
        adminmatchid = itemView.findViewById(R.id.adminmatch_id);
        admintournamentid = itemView.findViewById(R.id.adminidtournament);
        admintname1 = itemView.findViewById(R.id.admintname1);
        admintname2 = itemView.findViewById(R.id.admintname2);
        admintset_score1 = itemView.findViewById(R.id.admintscore1);
        admintset_score2 = itemView.findViewById(R.id.admintscore2);
        adminround = itemView.findViewById(R.id.adminround);
        admineditmatchbutton = itemView.findViewById(R.id.edittourmatchbutton);
    }
}
