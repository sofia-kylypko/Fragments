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
import android.widget.Toast;

import com.test.fragments.Modals.ReciptModel;
import com.test.fragments.adapters.MyRVAdapter;
import com.test.fragments.data.Repo;
import com.test.fragments.data.RestService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MondayFragment extends BaseFragment {


    private RecyclerView rvList;
    private MyRVAdapter adapter;

    private Button btnAdd;
    private Button btnDelete;

    private EditText setTittle;
    private EditText setDescription;


    private ArrayList<Repo> list;
    private final MyRVAdapter.OnItemClick listener = this::delete;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list=new ArrayList<>();

        setTittle = view.findViewById(R.id.setTittle);
        setDescription = view.findViewById(R.id.setDescription);

        rvList = view.findViewById(R.id.rvList);
        adapter = new MyRVAdapter(list, listener);
        adapter.notifyDataSetChanged();

        getRepo("sofia-kylypko");

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        rvList.setAdapter(adapter);

        btnAdd = view.findViewById(R.id.btnAdd);
        btnDelete = view.findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(v -> {
            add();
        });

        btnDelete.setOnClickListener(v -> {
            delete();
        });


    }

    private void delete(Repo model) {
        adapter.notifyItemInserted(list.indexOf(model));
        list.remove(model);
    }

    private void delete() {
        adapter.notifyItemRemoved(list.size() - 1);
        list.remove(list.size() - 1);

    }

    private void add() {
        adapter.notifyItemInserted(0);
        list.add(0, new Repo());
    }

    private List<Repo> generateRecipt() {
        ArrayList<Repo> tmp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tmp.add(new Repo());
        }
        return tmp;
    }

    private void getRepo(String name) {
        RestService.create().getRepo(name).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                list.addAll(response.body());
                adapter.setList(list);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}