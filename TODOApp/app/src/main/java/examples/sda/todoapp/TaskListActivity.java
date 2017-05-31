package examples.sda.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import examples.sda.todoapp.adapter.MyAdapter;
import examples.sda.todoapp.data.TaskDataSource;
import examples.sda.todoapp.data.TaskEntity;

public class TaskListActivity extends AppCompatActivity {

		@BindView(R.id.recycler_view)
		RecyclerView recyclerView;

		@BindView(R.id.coordinator_layout)
		CoordinatorLayout coordinatorLayout;

		private List<TaskEntity> listTasks;
		private TaskDataSource taskDataSource;
		private Cursor todoCursor;
		private MyAdapter myAdapter;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_task_list);
				ButterKnife.bind(this);

				taskDataSource = TaskDataSource.getInstance(this);
				taskDataSource.openDataBase();
		}

		public void initListView() {
				recyclerView.setHasFixedSize(true);
				recyclerView.setLayoutManager(new LinearLayoutManager(this));
				getAllTasks();
				myAdapter = new MyAdapter(listTasks);
				recyclerView.setAdapter(myAdapter);
		}

		public void getAllTasks() {
				listTasks = new ArrayList<>();
				todoCursor = getCursor();
				updateTaskList();
		}

		public Cursor getCursor() {
				todoCursor = taskDataSource.getAllTodos();
				if (todoCursor != null) {
						startManagingCursor(todoCursor);
						todoCursor.moveToFirst();
				}
				return todoCursor;
		}

		public void updateTaskList() {
				if (todoCursor != null && todoCursor.moveToFirst()) {
						do {
								long id = todoCursor.getLong(0);
								String title = todoCursor.getString(1);
								String description = todoCursor.getString(2);
								boolean completed = todoCursor.getInt(3) > 0 ? true : false;
								listTasks.add(new TaskEntity(id, title, description, completed));
						} while (todoCursor.moveToNext());
				}
		}
//		@OnClick(R.id.recycler_view)
//		public void initListViewOnItemClick() {
//				int position = 0;
//				TaskEntity task = listTasks.get(position);
//				if(task.isCompleted()) {
//						taskDataSource.updateTodo(task.getId(), task.getTitle(), task.getDescription(),false);
//				} else {
//						taskDataSource.updateTodo(task.getId(), task.getTitle(), task.getDescription(),true);
//				}
//				updateListViewData();
//		}

		public void updateListViewData() {
				todoCursor.requery();
				listTasks.clear();
				updateTaskList();
				myAdapter.notifyDataSetChanged();
		}

		@OnClick(R.id.add_task_button)
		public void goToAddNoteActivity() {
				Intent intent = new Intent(this, TaskDetailActivty.class);
				startActivity(intent);
		}

		@Override
		protected void onResume() {
				super.onResume();
				initListView();

		}

		@Override
		protected void onDestroy() {
				if (taskDataSource != null) {
						taskDataSource.closeDatabase();
				}
				super.onDestroy();
		}
}
