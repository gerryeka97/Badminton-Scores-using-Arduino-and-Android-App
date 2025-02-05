package com.example.gerryeka.aplikasiscoreboard1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gerry eka on 11/10/2019.
 */

public class AdminListDataViewHolder extends RecyclerView.ViewHolder  {
    public TextView username,password;
    public Button editbutton, deletebutton;

    public AdminListDataViewHolder(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.row_user);
        password = itemView.findViewById(R.id.row_pass);

    }
}
