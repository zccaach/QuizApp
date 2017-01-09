package com.example.akhlak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Myscores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myscores);

        DatabaseHelper db = new DatabaseHelper(this);
        final String playerusername = getIntent().getStringExtra("playerusername");
        Button bmainmenu =(Button)findViewById(R.id.bmainmenu);
        TextView tvfirstscore = (TextView)findViewById(R.id.tvfirstscore);
        TextView tvsecondscore = (TextView)findViewById(R.id.tvsecondscore);
        TextView tvthirdscore = (TextView)findViewById(R.id.tvthirdscore);


        tvfirstscore.setText(String.valueOf(db.getuserscore(playerusername)[0]));
        tvsecondscore.setText(String.valueOf(db.getuserscore(playerusername)[1]));
        tvthirdscore.setText(String.valueOf(db.getuserscore(playerusername)[2]));

        bmainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainmenu = new Intent(Myscores.this, UserAreaActivity.class);
                mainmenu.putExtra("playerusername", playerusername);
                startActivity(mainmenu);
            }
        });






    }

    @Override
    public void onBackPressed() {

    }
}
