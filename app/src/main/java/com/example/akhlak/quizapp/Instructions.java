package com.example.akhlak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        String instructions = "Once you have started the quiz, you will be able to answer 8 questions of your choice from the questions available to you. Please use the navigation buttons at the bottom of the screen to move between questions. Once you are certain you want to attemot the question, click on one of the three answers available to you. You will also have an option to use a cheat button per question which will tell you the answer but remember you will receive no points for answering that question and it will be treated as an attempted question. Once you have attempted 8 questions, you will recieve 1 point for each correct answer and you will be redirected to the results page where your score will be shown out of 8. You can then attempt it again to try and beat your score. Scores are also visible on the Leaderboards page where you can see the top five scores currently held in the game by all users, allowing you to compete with everyone. Finally, enjoy playing!";
        TextView tvinstructions;
        final String playerusername = getIntent().getStringExtra("playerusername");

        tvinstructions = (TextView)findViewById(R.id.tvinstructions);

        tvinstructions.setText(instructions);

        Button bReturn = (Button)findViewById(R.id.bReturn);

        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Returnintent = new Intent(Instructions.this, UserAreaActivity.class);
                Returnintent.putExtra("playerusername", playerusername);
                startActivity(Returnintent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
