package examples.sda.todoapp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import examples.sda.todoapp.data.DataBaseHelper;
import examples.sda.todoapp.data.TaskEntity;

public class TaskDetailActivty extends AppCompatActivity {

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_description);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.floatingActionButton)
    public void saveTask() {
        final TaskEntity task = new TaskEntity(null, "tytuł notatki", "podtytuł", false);
        DataBaseHelper databaseHelper = new DataBaseHelper(this);
        final long rowId = databaseHelper.saveTask(task);
        if (rowId == -1) {
            Snackbar.make(coordinatorLayout, "Error occurred during saving the task", Snackbar.LENGTH_LONG)
                    .show();
        } else {
            Snackbar.make(coordinatorLayout, "Task saved!", Snackbar.LENGTH_LONG)
                    .show();
        }
    }
}
