package com.test.fragments.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle;
    private TextView txtDescription;

    private Button btnDeleteItem;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle=itemView.findViewById(R.id.txtTitle);
        txtDescription=itemView.findViewById(R.id.txtDescription);
        btnDeleteItem = itemView.findViewById(R.id.btnDeleteItem);
    }

    public void onBind(ReciptModel reciptModels, MyRVAdapter.OnItemClick listener){
        txtTitle.setText(reciptModels.getTitle());

        txtDescription.setText(reciptModels.getDescription());

        btnDeleteItem.setOnClickListener(v->listener.onClick(reciptModels));
    }
}
