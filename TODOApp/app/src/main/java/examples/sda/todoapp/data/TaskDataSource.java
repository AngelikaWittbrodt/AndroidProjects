package examples.sda.todoapp.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by angelika on 24.05.17.
 */

public class TaskDataSource {

    private DataBaseHelper dataBaseHelper;

    public long saveTask(@NonNull TaskEntity taskEntity) {
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, taskEntity.getTitle());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION, taskEntity.getDescription());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_COMPLETED, taskEntity.isCompleted());

        return db.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);
    }

}
