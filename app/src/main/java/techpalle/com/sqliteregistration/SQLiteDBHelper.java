package techpalle.com.sqliteregistration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by srinath on 28-01-2018.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_ID =  "userid";
    public static final String COLUMN_FULLNAME =  "fullname";
    public static final String COLUMN_EMAIL =  "email";
    public static final String COLUMN_PASSWORD =  "password";
    public static final String COLUMN_MOBILE =  "mobile";

    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULLNAME + " TEXT, "+
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_MOBILE + " TEXT " + ")";

    //modified constructor
    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
