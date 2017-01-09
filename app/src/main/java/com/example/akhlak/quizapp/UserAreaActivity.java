package com.example.akhlak.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAreaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
            final String playerusername = getIntent().getStringExtra("playerusername");
            Button bStartQuiz = (Button) findViewById(R.id.bStartQuiz);
            TextView tvName = (TextView) findViewById(R.id.tvName);
            tvName.setText(playerusername);
            bStartQuiz.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    Intent StartQuizIntent = new Intent(UserAreaActivity.this, Quiz.class);
                    StartQuizIntent.putExtra("playerusername", playerusername);
                    startActivity(StartQuizIntent);

                }
            });

        Button bLeaderboard = (Button)findViewById(R.id.bLeaderboard);
        bLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoleaderboardintent = new Intent(UserAreaActivity.this, Leaderboard.class);
                gotoleaderboardintent.putExtra("playerusername", playerusername);
                startActivity(gotoleaderboardintent);
            }
        });

        Button bLogout = (Button)findViewById(R.id.bLogout);
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutintent = new Intent(UserAreaActivity.this, StartPage.class);
                startActivity(logoutintent);
            }
        });

        Button bMyLeaderboard = (Button)findViewById(R.id.bMyLeaderboard);
        bMyLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myleaderboardintent = new Intent(UserAreaActivity.this, Myscores.class);
                myleaderboardintent.putExtra("playerusername", playerusername);
                startActivity(myleaderboardintent);
            }
        });

        Button bInstructions = (Button)findViewById(R.id.bInstructions);
        bInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instructionsintent = new Intent(UserAreaActivity.this, Instructions.class);
                instructionsintent.putExtra("playerusername", playerusername);
                startActivity(instructionsintent);
            }
        });



    }

    @Override
    public void onBackPressed() {

    }





    }

