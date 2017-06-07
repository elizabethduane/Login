package infocefetcontagem.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String mail = bundle.getString("emailUser");

        if(!mail.isEmpty()) {
            EditText et_mail = (EditText) findViewById(R.id.editTextEmail);

            et_mail.setText(mail);
        }

    }

    public void registerInDB(View v){

        ControllerLogin mController =  new ControllerLogin(this);

        String name = ((EditText) findViewById(R.id.editTextName)).getText().toString().trim();
        String mail = ((EditText) findViewById(R.id.editTextEmail)).getText().toString().trim();
        String pass = ((EditText) findViewById(R.id.editTextPassword)).getText().toString().trim();

        long resp = mController.Insert(mail,pass,name);

        if(resp==-1){

            Toast.makeText(this, "Error with saving user", Toast.LENGTH_SHORT).show();
            this.finish();
        }else if (resp == -2){
            Toast.makeText(this, "This email address already exists", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
            this.finish();
        }



    }
}
