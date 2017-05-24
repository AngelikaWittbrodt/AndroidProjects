package examples.sda.todoapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

/**
 * Created by angelika on 23.05.17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TODOApp.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String BOOLEAN_TYPE = " INTEGER";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME +
            "(" + TodoContract.TodoEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TodoContract.TodoEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," + TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + "," +
            TodoContract.TodoEntry.COLUMN_NAME_COMPLETED + BOOLEAN_TYPE + " }";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO create tables
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TodoContract.TodoEntry.TABLE_NAME);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public long saveTask(@NonNull TaskEntity taskEntity) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, taskEntity.getTitle());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION, taskEntity.getDescription());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_COMPLETED, taskEntity.isCompleted());


        return db.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);
    }
}
