package examples.sda.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import examples.sda.todoapp.data.DataBaseHelper;
import examples.sda.todoapp.data.TaskEntity;

/**
 * Created by angelika on 24.05.17.
 */

public class TaskDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_description);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.floatingActionButton)
    public void saveTask() {
        final TaskEntity task = new TaskEntity(null, "tytuł  notatki", "podtytuł", false);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        //final long rowID = dataBaseHelper.saveTask(task);
    }


}
