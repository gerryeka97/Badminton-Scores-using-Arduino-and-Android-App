package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.AdminListDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.AdminhistoryDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admin;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminhistory;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.ArrayList;

/**
 * Created by gerry eka on 11/10/2019.
 */

public class Adapter_admin extends RecyclerView.Adapter<AdminListDataViewHolder>{

    ArrayList<Model_admin> list;
    Context context;

    public Adapter_admin(ArrayList<Model_admin> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public Adapter_admin() {
    }

    @Override
    public AdminListDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadmin, parent, false);

        return new AdminListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdminListDataViewHolder holder, int position) {
        Model_admin currentData = list.get(position);
        holder.username.setText(currentData.getUsername());
        holder.password.setText(currentData.getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
