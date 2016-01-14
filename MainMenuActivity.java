package anirudhbansal.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class MainMenuActivity extends ActionBarActivity {
public static final String USER="username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent=getIntent();
        String welcome=intent.getStringExtra(USER);
        TextView welcometext=(TextView)findViewById(R.id.mainmenu);
        welcome="Hello " + welcome;
        welcometext.setText(welcome);
    }

}
