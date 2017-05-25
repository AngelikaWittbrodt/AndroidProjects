package examples.sda.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import examples.sda.todoapp.adapter.MyAdapter;
import examples.sda.todoapp.data.TaskEntity;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        ButterKnife.bind(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<TaskEntity> list = new ArrayList<>();
        for(int i=0; i<20 ;i++) {
            list.add(new TaskEntity(null, "tytuł notatki", "podtytuł", false));
        }

        recyclerView.setAdapter(new MyAdapter(list, recyclerView));
    }

    @OnClick(R.id.add_task_button)
    public void goToAddNoteActivity() {
        Intent intent = new Intent(this, TaskDetailActivty.class);
        startActivity(intent);
    }
}
