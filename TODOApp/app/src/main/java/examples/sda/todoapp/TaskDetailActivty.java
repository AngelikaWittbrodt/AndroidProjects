package examples.sda.todoapp;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import examples.sda.todoapp.data.TaskDataSource;

public class TaskDetailActivty extends AppCompatActivity {

		@BindView(R.id.coordinator_layout_detail)
		CoordinatorLayout coordinatorLayoutDetail;

		@BindView(R.id.title_field)
		EditText titleField;

		@BindView(R.id.description_field)
		EditText descriptionField;

		@BindView(R.id.floatingActionButton)
		FloatingActionButton floatingActionButton;

		private TaskDataSource taskDataSource;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_todo_description);
				ButterKnife.bind(this);

				taskDataSource = TaskDataSource.getInstance(this);

		}

		@OnClick(R.id.floatingActionButton)
		public void saveNewTask() {
				String taskTitle = titleField.getText().toString();
				String taskDescription = descriptionField.getText().toString();
				if (taskDescription.equals("")) {
						descriptionField.setError("Your task description couldn't be empty.");
				} else {
						taskDataSource.insertTodo(taskTitle, taskDescription);
						long rowId = taskDataSource.insertTodo(taskTitle, taskDescription);
						if (rowId == -1) {
								Snackbar.make(coordinatorLayoutDetail, "Error occurred during saving the task", Snackbar.LENGTH_LONG)
												.show();
						} else {
								Snackbar.make(coordinatorLayoutDetail, "Task saved!", Snackbar.LENGTH_LONG)
												.show();
						}
				}
		}
}
