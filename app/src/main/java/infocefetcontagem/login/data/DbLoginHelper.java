package infocefetcontagem.login.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import infocefetcontagem.login.data.LoginContract.LoginEntry;

/**
 * Created by elizabethduane on 07/06/17.
 */

public class DbLoginHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG = DbLoginHelper.class.getSimpleName();

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "login.db";

    public DbLoginHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_LOGIN_TABLE =  "CREATE TABLE " + LoginEntry.TABLE_NAME + " ("
                + LoginEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LoginEntry.COLUMN_LOGIN+ " TEXT NOT NULL, "
                + LoginEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "
                + LoginEntry.COLUMN_NAME + " TEXT NOT NULL);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
