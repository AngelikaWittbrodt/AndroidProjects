package examples.sda.todoapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by angelika on 24.05.17.
 */

public class DatabaseReadTask {

    private DataBaseHelper mDbHelper;

    SQLiteDatabase db = mDbHelper.getReadableDatabase();
    //Define a projection that specifies which columns form the database
    //you will actually use after this query
    String[] projection = {TodoContract.TodoEntry._ID,
            TodoContract.TodoEntry.COLUMN_NAME_TITLE,
            TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION,
            TodoContract.TodoEntry.COLUMN_NAME_COMPLETED};

    //Filter results WHERE "completed" = "0"
    String selection = TodoContract.TodoEntry.COLUMN_NAME_COMPLETED + " =?";
    String[] selcetionArgs = {"0"};

    //How you want the results sorted in the resulting Cursor
    String sortOrder = TodoContract.TodoEntry.COLUMN_NAME_TITLE + " DESC";

    Cursor cursor = db.query(TodoContract.TodoEntry.TABLE_NAME, projection, selection, selcetionArgs, null, null, sortOrder);


}
