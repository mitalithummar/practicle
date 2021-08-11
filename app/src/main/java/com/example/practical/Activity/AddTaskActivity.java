package com.example.practical.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practical.Database.DatabaseHandler;
import com.example.practical.Model.Task;
import com.example.practical.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddTaskActivity extends AppCompatActivity {

    DatabaseHandler db;
    TextView mTitle, mDescription;
    Button mBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add New Task");

        db = new DatabaseHandler(this);

        mTitle = findViewById(R.id.title);
        mDescription = findViewById(R.id.description);
        mBtnSubmit = findViewById(R.id.submit);

        Task task = new Task();
        task.setTitle(mTitle.getText().toString());
        task.setDescription(mDescription.getText().toString());
        task.setRemindMe("");
        task.setDueDate("");

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.addTask(task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}