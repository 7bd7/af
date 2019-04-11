package ee.brightapps.af;

import android.database.sqlite.SQLiteDatabase;

public class AfDb {

    public static void inTransaction(SQLiteDatabase db, Runnable action) {
        db.beginTransaction();
        try {
            action.run();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

}
