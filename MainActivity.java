package anirudhbansal.rateit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText username,password;
    TextView error;
    String error_message="Username and Password don't match.Please try again.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.main_user);
        password=(EditText)findViewById(R.id.main_password);
        error=(TextView)findViewById(R.id.error_login);
    }
public void onMainReg(View view){
    Intent intent=new Intent(this,RegisterActivity.class);
    startActivity(intent);
}
public void onMainLog(View view){
    String s1=username.getText().toString();
    String s2=password.getText().toString();
    try{
        if(s1.length() > 0 && s2.length() >0)
        {
            UserDatabaseHelper dbUser = new UserDatabaseHelper(MainActivity.this);
            dbUser.open();
            if(dbUser.Login(s1,s2))
            {
                error.setText("");
                Intent intent=new Intent(this,MainMenuActivity.class);
                intent.putExtra(MainMenuActivity.USER,s1);
                startActivity(intent);
            }else{
               error.setText(error_message);
            }
            dbUser.close();
        }

    }catch(Exception e)
    {
        Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
}
