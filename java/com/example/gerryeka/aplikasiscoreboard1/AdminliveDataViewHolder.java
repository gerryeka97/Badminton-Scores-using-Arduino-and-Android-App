package com.example.gerryeka.aplikasiscoreboard1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class AdminliveDataViewHolder extends RecyclerView.ViewHolder{
    public TextView idlive,name1,name2,setscore,setscore1,setscore2,score1,score2,score1set1,score2set1,score1set2,score2set2,score1set3,score2set3;
    public Button editbutton, deletebutton;

    public AdminliveDataViewHolder(@NonNull View itemView) {
        super(itemView);
        idlive = itemView.findViewById(R.id.row_id);
        name1 = itemView.findViewById(R.id.row_name1);
        name2 = itemView.findViewById(R.id.row_name2);
        setscore = itemView.findViewById(R.id.row_set_score);
        setscore1 = itemView.findViewById(R.id.row_set_score1);
        setscore2 = itemView.findViewById(R.id.row_set_score2);
        score1 = itemView.findViewById(R.id.row_score1);
        score2 = itemView.findViewById(R.id.row_score2);
        score1set1 = itemView.findViewById(R.id.Score1Set1);
        score2set1 = itemView.findViewById(R.id.Score2Set1);
        score1set2 = itemView.findViewById(R.id.Score1Set2);
        score2set2 = itemView.findViewById(R.id.Score2Set2);
        score1set3 = itemView.findViewById(R.id.Score1Set3);
        score2set3 = itemView.findViewById(R.id.Score2Set3);
        editbutton = itemView.findViewById(R.id.editbutton);
        deletebutton = itemView.findViewById(R.id.deletelivebutton);
    }



}
