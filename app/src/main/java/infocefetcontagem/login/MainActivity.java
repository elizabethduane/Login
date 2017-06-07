package infocefetcontagem.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String name = bundle.getString("nameUser");

        TextView tvname = (TextView) findViewById(R.id.textView_name);

        tvname.setText("BEM VINDO(A), " + name);

    }

    public void fechar(View v){

        //this.finish();
    }

}
