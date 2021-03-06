package examples.sda.todoapp.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by angelika on 23.05.17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
		public static final int DATABASE_VERSION = 3;
		public static final String DATABASE_NAME = "TODOApp.db";
		public static final String TEXT_TYPE = " TEXT";
		public static final String BOOLEAN_TYPE = " INTEGER DEFAULT 0";
		public static final String ID_TYPE = " INTEGER PRIMARY KEY AUTOINCREMENT,";

		public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME +
						"(" + TodoContract.TodoEntry._ID + ID_TYPE
						+ TodoContract.TodoEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," + TodoContract.TodoEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + "," +
						TodoContract.TodoEntry.COLUMN_NAME_COMPLETED + BOOLEAN_TYPE + " )";

		public DataBaseHelper(Context context) {
				super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
				db.execSQL(SQL_CREATE_ENTRIES);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				db.execSQL("DROP TABLE IF EXISTS" + TodoContract.TodoEntry.TABLE_NAME);
				db.execSQL(SQL_CREATE_ENTRIES);
		}
}
