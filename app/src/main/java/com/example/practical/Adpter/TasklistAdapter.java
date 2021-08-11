package com.example.practical.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practical.Model.Task;
import com.example.practical.R;

import java.util.ArrayList;

public class TasklistAdapter extends RecyclerView.Adapter<TasklistAdapter.AppListHolder> {

    public ArrayList<Task> mtaskArrayList;
    Context context;

    public TasklistAdapter(ArrayList<Task> pInfos, Context context) {
        this.mtaskArrayList = pInfos;
        this.context = context;
    }

    @NonNull
    @Override
    public AppListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AppListHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_task_data, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppListHolder appListHolder, int i) {
        appListHolder.app_paackage.setText(mtaskArrayList.get(i).getTitle());
        appListHolder.app_name.setText(mtaskArrayList.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return mtaskArrayList.size();
    }


    class AppListHolder extends RecyclerView.ViewHolder {
        TextView app_paackage, app_name;

        public AppListHolder(@NonNull View itemView) {
            super(itemView);
            app_paackage = itemView.findViewById(R.id.app_paackage);
            app_name = itemView.findViewById(R.id.app_name);
        }
    }
}
