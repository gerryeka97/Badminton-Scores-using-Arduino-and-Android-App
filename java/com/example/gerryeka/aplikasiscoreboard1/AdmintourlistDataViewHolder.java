package com.example.gerryeka.aplikasiscoreboard1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class AdmintourlistDataViewHolder extends RecyclerView.ViewHolder {
    public TextView admintournamentname, admintournamentid;
    public Button adminviewbutton;

    public AdmintourlistDataViewHolder(View itemView) {
        super(itemView);
        admintournamentname = itemView.findViewById(R.id.admintournament_name);
        admintournamentid = itemView.findViewById(R.id.admintournament_id);
        adminviewbutton = itemView.findViewById(R.id.adminviewtourbutton);
    }
}
