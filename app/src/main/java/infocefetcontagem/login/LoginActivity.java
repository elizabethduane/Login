package infocefetcontagem.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private final static int CALL_MAIN = 1000;
    private final static int CALL_EDIT = 1001;

    private EditText et_email, et_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = (EditText)findViewById(R.id.editTextEmail);
        et_pass = (EditText)findViewById(R.id.editTextPassword);
    }


    public void register(View v){
        String email = et_email.getText().toString().trim();

        Intent intent = new Intent(this, UserEditActivity.class);

        intent.putExtra("emailUser", email);
        startActivityForResult(intent,CALL_EDIT);

    }

    public void singIn(View v){
        String email=null;// = et_email.getText().toString().trim();
        String userPass=null;// = et_pass.getText().toString().trim();
        String name=null, bdPass=null;


        //ControllerLogin mController = new ControllerLogin(this);

        //mController.getValues(email,bdPass,name);

        if(bdPass.contentEquals(userPass)) {
            Intent intent = new Intent(this, MainActivity.class);


            intent.putExtra("nameUser", name);
            startActivityForResult(intent, CALL_MAIN);
        }
    }
}
