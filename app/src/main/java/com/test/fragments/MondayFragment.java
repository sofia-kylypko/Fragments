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
import android.widget.LinearLayout;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.adapters.MyRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MondayFragment extends BaseFragment {

    private RecyclerView rvList;
    private MyRVAdapter adapter;

    Button btnAdd;
    Button btnClean;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList=view.findViewById(R.id.rvList);

        adapter =new MyRVAdapter(generateRecipes());
        adapter.notifyDataSetChanged();

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        rvList.setAdapter(adapter);


    }

    private List<ReciptModel> generateRecipes(){
        ArrayList<ReciptModel> tmp=new ArrayList<>();
        for (int i=0; i<6; i++){
            tmp.add(new ReciptModel("Title "+i, "Discription "+i));
        }
        return tmp;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnAdd.setOnClickListener(view ->{
            addNewField();
        });

        btnClean.setOnClickListener(v->{

        });

    }

    private void addNewField() {
        btnAdd= btnAdd.findViewById(R.id.btnAdd);

        ArrayList<ReciptModel> tmp = new ArrayList<>();

        btnAdd.setOnClickListener(view ->{
            for (int i = 0; i > 5; i++) {
                tmp.add(new ReciptModel("Title " + i, "Discription " + i + 1));
            }
        });

    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}