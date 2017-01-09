package com.example.akhlak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class
Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        TextView tvfirstplace, tvfirstplacescore, tvsecondplace, tvsecondplacescore, tvthirdplace, tvthirdplacescore, tvfourthplace, tvfourthplacescore, tvfifthplace, tvfifthplacescore;
        Button bLeaderboardMainMenu;
        final String playerusername = getIntent().getStringExtra("playerusername");

        tvfirstplace = (TextView) findViewById(R.id.tvfirstplace);
        tvfirstplacescore = (TextView) findViewById(R.id.tvfirstplacescore);
        tvsecondplace = (TextView) findViewById(R.id.tvsecondplace);
        tvsecondplacescore = (TextView) findViewById(R.id.tvsecondplacescore);
        tvthirdplace = (TextView) findViewById(R.id.tvthirdplace);
        tvthirdplacescore = (TextView) findViewById(R.id.tvthirdplacescore);
        tvfourthplace = (TextView) findViewById(R.id.tvfourthplace);
        tvfourthplacescore = (TextView) findViewById(R.id.tvfourthplacescore);
        tvfifthplace = (TextView) findViewById(R.id.tvfifthplace);
        tvfifthplacescore = (TextView) findViewById(R.id.tvfifthplacescore);
        bLeaderboardMainMenu = (Button)findViewById(R.id.bLeaderboardMainMenu);




        DatabaseHelper db = new DatabaseHelper(this);

        Bundle b = db.getscoreat(1);
        tvfirstplace.setText(b.getString("playerusername"));
        String score =  String.valueOf(b.getInt("score"));
        tvfirstplacescore.setText(score);

        Bundle c = db.getscoreat(2);
        tvsecondplace.setText(c.getString("playerusername"));
        String score2 =  String.valueOf(c.getInt("score"));
        tvsecondplacescore.setText(score2);

        Bundle d = db.getscoreat(3);
        tvthirdplace.setText(d.getString("playerusername"));
        String score3 =  String.valueOf(d.getInt("score"));
        tvthirdplacescore.setText(score3);

        Bundle e = db.getscoreat(4);
        tvfourthplace.setText(e.getString("playerusername"));
        String score4 =  String.valueOf(e.getInt("score"));
        tvfourthplacescore.setText(score4);

        Bundle f = db.getscoreat(5);
        tvfifthplace.setText(f.getString("playerusername"));
        String score5 =  String.valueOf(f.getInt("score"));
        tvfifthplacescore.setText(score5);

        bLeaderboardMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Backtomainmenuintent = new Intent(Leaderboard.this, UserAreaActivity.class);
                Backtomainmenuintent.putExtra("playerusername", playerusername);
                startActivity(Backtomainmenuintent);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }



}
