package anirudhbansal.rateit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {

    EditText username;
    EditText password;
    Button register;
    TextView register_message;
    String reg_error="Username and Password cannot be left blank";
    String reg_unavail="Username is already taken";
    String reg_succ="Registration successful.Please go back to main page to login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.reg_user);
        password = (EditText) findViewById(R.id.reg_password);
        register = (Button) findViewById(R.id.reg_compl);
        register_message=(TextView)findViewById(R.id.reg_message);
        register.setClickable(true);

    }

    public void onRegBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onRegCompl(View view){
        String s1 = username.getText().toString().trim();
        String s2 = password.getText().toString().trim();
        if (s1.length()==0 ||  s2.length()==0)
            register_message.setText(reg_error);
        else {

            UserDatabaseHelper dbUser = new UserDatabaseHelper(RegisterActivity.this);
            dbUser.open();
            long result=dbUser.AddUser(s1,s2);
            if (result != -1) {
                if(result!=-2) {
                    register_message.setText(reg_succ);
                    register.setClickable(false);
                }
                else register_message.setText(reg_unavail);
            }
            dbUser.close();
        }
    }

}
