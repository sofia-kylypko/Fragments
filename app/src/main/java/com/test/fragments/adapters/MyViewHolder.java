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

    private Button deleteitem;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle=itemView.findViewById(R.id.txtTitle);

        txtDescription=itemView.findViewById(R.id.txtDescription);
    }

    public void onBind(ReciptModel reciptModel, MyRVAdapter.OnItemClick listener){
        txtTitle.setText(reciptModel.getTitle());
        txtDescription.setText(reciptModel.getDescription());

        deleteitem.setOnClickListener(v->listener.onClick(reciptModel));
    }
}
