package examples.sda.todoapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by angelika on 24.05.17.
 */

public class TaskDataSource {

		private static TaskDataSource INSTANCE;
		private DataBaseHelper dbHelper;
		private SQLiteDatabase db;
		private Context context;

		// Prevent direct instantiation
		private TaskDataSource(@NonNull Context context) {
				dbHelper = new DataBaseHelper(context);
		}

		public static synchronized TaskDataSource getInstance(@NonNull Context context) {
				//Use the application context, which will ensure that you don't accidentally leak an Activity's context.
				// See this article for more information:
				// http://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html
				if (INSTANCE == null) {
						INSTANCE = new TaskDataSource(context.getApplicationContext());
				}
				return INSTANCE;
		}

		public void openDataBase() {
				try {
						db = dbHelper.getWritableDatabase();
				} catch (SQLException e) {
						db = dbHelper.getReadableDatabase();
				}
		}

		public void closeDatabase() {
				dbHelper.close();
		}

		public long insertTodo(String title, String description) {
				ContentValues values = new ContentValues();
				values.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, title);
				values.put(TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION, description);

				return db.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);
		}

		public boolean updateTodo(TaskEntity task) {
				long id = task.getId();
				String title = task.getTitle();
				String description = task.getDescription();
				boolean completed = task.isCompleted();
				return updateTodo(id, title, description, completed);
		}

		public boolean updateTodo(long id,String title, String description, boolean completed) {
				String where = TodoContract.TodoEntry._ID + "=" + id;
				int completedTask = completed ? 1 : 0;
				ContentValues updateTodoValues = new ContentValues();
				updateTodoValues.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, title);
				updateTodoValues.put(TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION, description);
				updateTodoValues.put(TodoContract.TodoEntry.COLUMN_NAME_COMPLETED, completed);
				return db.update(TodoContract.TodoEntry.TABLE_NAME, updateTodoValues, where, null) > 0;
		}

		public boolean deleteTodo(long id) {
				String where = TodoContract.TodoEntry._ID + "=" + id;
				return db.delete(TodoContract.TodoEntry.TABLE_NAME, where, null) > 0;
		}

		public TaskEntity getTodo(long id) {
				String[] columns = {TodoContract.TodoEntry._ID,
								TodoContract.TodoEntry.COLUMN_NAME_TITLE,
								TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION,
								TodoContract.TodoEntry.COLUMN_NAME_COMPLETED};
				//Filter results WHERE "completed" = "0"
				String where = TodoContract.TodoEntry._ID + "=" + id;
				//String[] selcetionArgs = {"0"};
				//How you want the results sorted in the resulting Cursor
				String sortOrder = TodoContract.TodoEntry.COLUMN_NAME_TITLE + " DESC";
				Cursor cursor = db.query(TodoContract.TodoEntry.TABLE_NAME, columns,
								where, null, null, null, sortOrder);
				TaskEntity task = null;
				//while (cursor.moveToNext()) {
				if (cursor != null && cursor.moveToFirst()) {
						String title = cursor.getString(1);
						String description = cursor.getString(2);
						boolean completed = cursor.getInt(3) > 0 ? true : false;
						task = new TaskEntity(id, title, description, completed);
				}
				return task;
		}

		public Cursor getAllTodos() {
				String[] columns = {TodoContract.TodoEntry._ID,
								TodoContract.TodoEntry.COLUMN_NAME_TITLE,
								TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION,
								TodoContract.TodoEntry.COLUMN_NAME_COMPLETED};
				return db.query(TodoContract.TodoEntry.TABLE_NAME, columns, null, null, null, null, null);
		}
}
