package examples.sda.todoapp.data;

import android.provider.BaseColumns;

/**
 * Created by angelika on 23.05.17.
 */

public final class TodoContract {
    private TodoContract() {
    }

    public static class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_COMPLETED = "completed";
    }

}
