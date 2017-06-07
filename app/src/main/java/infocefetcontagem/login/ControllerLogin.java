package infocefetcontagem.login;

/**
 * Created by elizabethduane on 07/06/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import infocefetcontagem.login.data.DbLoginHelper;
import infocefetcontagem.login.data.LoginContract.LoginEntry;

public class ControllerLogin {

    private DbLoginHelper helper;

    public ControllerLogin(Context context){

        helper = new DbLoginHelper(context);

    }

    public long Insert(String login, String password, String name){
        // Create and/or open a database to write from it
        SQLiteDatabase db = helper.getWritableDatabase();

        //create the object no be included
        ContentValues values = new ContentValues();

        values.put(LoginEntry.COLUMN_LOGIN,login);
        values.put(LoginEntry.COLUMN_PASSWORD,password);
        values.put(LoginEntry.COLUMN_NAME,name);

        Cursor c = Consulta(login);

        if (c.getCount()>0)
            return -2;

        return db.insert(LoginEntry.TABLE_NAME, null, values);

    }


    public Cursor Consulta(String login){
        // Create and/or open a database to write from it
        SQLiteDatabase db = helper.getReadableDatabase();

        //create the object no be included
        ContentValues values = new ContentValues();

        String selection = LoginEntry.COLUMN_LOGIN +" = ? ";
        String argValue [] = {login};

        return db.query(LoginEntry.TABLE_NAME,null,selection,argValue,null,null,null,null);

    }

    public int getValues(String login, String password, String name){

        Cursor c = Consulta(login);

        //there is no results
        if(c.getCount()==0)
            return -1;

        //there is more than one result
        if(c.getCount()>1)
            return -2;

        password = c.getString(c.getColumnIndexOrThrow(LoginEntry.COLUMN_PASSWORD));
        name = c.getString(c.getColumnIndexOrThrow(LoginEntry.COLUMN_NAME));

        return 0;

    }
}
