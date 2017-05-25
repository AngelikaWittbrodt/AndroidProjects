package examples.sda.todoapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import examples.sda.todoapp.R;
import examples.sda.todoapp.data.TaskEntity;

/**
 * Created by angelika on 24.05.17.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<TaskEntity> mList = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.task_title);
            mDescription = (TextView) itemView.findViewById(R.id.task_description);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_task_item, parent, false);
        return new MyViewHolder(view);
    }

    public MyAdapter(ArrayList<TaskEntity> pList, RecyclerView pRecyclerView) {
        mList = pList;
        mRecyclerView = pRecyclerView;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        TaskEntity taskEntity = mList.get(i);
        ((MyViewHolder) viewHolder).mTitle.setText(taskEntity.getTitle());
        ((MyViewHolder) viewHolder).mDescription.setText(taskEntity.getDescription());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
