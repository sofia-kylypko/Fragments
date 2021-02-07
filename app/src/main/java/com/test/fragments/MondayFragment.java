package com.test.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.adapters.MyRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MondayFragment extends BaseFragment {


    private RecyclerView rvList;
    private MyRVAdapter adapter;

    private Button btnAdd;
    private Button btnDelete;

    private EditText setTittle;
    private EditText setDescription;


    private ArrayList<ReciptModel> list;
    private final MyRVAdapter.OnItemClick listener = this::delete;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setTittle= view.findViewById(R.id.setTittle);
        setDescription= view.findViewById(R.id.setDescription);

        rvList=view.findViewById(R.id.rvList);

        list=(ArrayList<ReciptModel>) generateRecipt();

        adapter =new MyRVAdapter(list, listener);
        adapter.notifyDataSetChanged();

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        rvList.setAdapter(adapter);

        btnAdd= view.findViewById(R.id.btnAdd);
        btnDelete= view.findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(v ->{
            add();
        });

        btnDelete.setOnClickListener(v ->{
            delete();
        });



    }

    private void delete(ReciptModel model){
        adapter.notifyItemInserted(list.indexOf(model));
        list.remove(model);
    }

    private void delete(){
        adapter.notifyItemRemoved(list.size()-1);
        list.remove(list.size()-1);

    }

    private void add(){
        adapter.notifyItemInserted(0);
        list.add(0, new ReciptModel(" "+setTittle.getText().toString() ," "+setDescription.getText().toString()));
    }

    private List<ReciptModel> generateRecipt(){
        ArrayList<ReciptModel> tmp=new ArrayList<>();
        for (int i=0; i<10; i++){
            tmp.add(new ReciptModel("Title "+i, "Discription "+i));
        }
        return tmp;
    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}