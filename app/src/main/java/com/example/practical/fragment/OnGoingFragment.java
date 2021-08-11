
package com.example.practical.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical.Activity.MainActivity;
import com.example.practical.Adpter.TasklistAdapter;
import com.example.practical.Database.DatabaseHandler;
import com.example.practical.Model.Task;
import com.example.practical.R;

import java.util.ArrayList;

public class OnGoingFragment extends Fragment {

    DatabaseHandler db;
    View view;
    ArrayList<Task> taskArrayList;
    RecyclerView rv_App_list;
    TasklistAdapter listAdapter;

    public OnGoingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ongoing, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {

        rv_App_list = view.findViewById(R.id.rvlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_App_list.setLayoutManager(linearLayoutManager);

        db = new DatabaseHandler(getActivity());
        try {
            taskArrayList = db.getAllTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        listAdapter = new TasklistAdapter(taskArrayList, getActivity());
        rv_App_list.setAdapter(listAdapter);

    }

}