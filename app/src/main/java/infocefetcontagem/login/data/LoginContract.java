package infocefetcontagem.login.data;

import android.provider.BaseColumns;

/**
 * Created by elizabethduane on 07/06/17.
 */

public final class LoginContract {


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private LoginContract() {}

    /* Inner class that defines the table contents */
    public static class LoginEntry implements BaseColumns {
        public static final String TABLE_NAME = "loginEntry";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_NAME = "name";
    }
}
