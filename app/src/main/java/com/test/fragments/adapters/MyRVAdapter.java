package com.test.fragments.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.R;
import com.test.fragments.data.Repo;

import java.util.List;

public class MyRVAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Repo> repos;
    private OnItemClick listener;

    public MyRVAdapter(List<Repo> repo, OnItemClick listener) {
        this.repos = repo;
        this.listener=listener;
    }

    public void setList(List<Repo> repos){
        this.repos = repos;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contaner, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(repos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return repos.size();

    }


    public interface OnItemClick {
        public void onClick(Repo model);
    }
}

