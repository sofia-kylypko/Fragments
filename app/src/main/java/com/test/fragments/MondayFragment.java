package com.test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.adapters.MyRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MondayFragment extends BaseFragment {

    private RecyclerView rvList;
    private MyRVAdapter adapter;

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