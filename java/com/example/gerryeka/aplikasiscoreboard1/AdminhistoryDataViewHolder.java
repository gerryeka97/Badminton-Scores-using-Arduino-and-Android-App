package com.example.gerryeka.aplikasiscoreboard1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 11/7/2019.
 */

public class AdminhistoryDataViewHolder extends RecyclerView.ViewHolder{

    public TextView idhistory,name1,name2,setscore,setscore1,setscore2,score1,score2,score1set1,score2set1,score1set2,score2set2,score1set3,score2set3;
    public Button editbutton, deletebutton;

    public AdminhistoryDataViewHolder(@NonNull View itemView) {
        super(itemView);
        idhistory = itemView.findViewById(R.id.row1_id);
        name1 = itemView.findViewById(R.id.row1_name1);
        name2 = itemView.findViewById(R.id.row1_name2);
        setscore = itemView.findViewById(R.id.row1_set_score);
        setscore1 = itemView.findViewById(R.id.row1_set_score1);
        setscore2 = itemView.findViewById(R.id.row1_set_score2);
        score1set1 = itemView.findViewById(R.id.row1_Score1Set1);
        score2set1 = itemView.findViewById(R.id.row1_Score2Set1);
        score1set2 = itemView.findViewById(R.id.row1_Score1Set2);
        score2set2 = itemView.findViewById(R.id.row1_Score2Set2);
        score1set3 = itemView.findViewById(R.id.row1_Score1Set3);
        score2set3 = itemView.findViewById(R.id.row1_Score2Set3);
        editbutton = itemView.findViewById(R.id.editbutton1);
        deletebutton = itemView.findViewById(R.id.deletehistorybutton);

    }
}
