package com.example.akhlak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        db = new DatabaseHelper(this);
        TextView tvResult = (TextView)findViewById(R.id.tvResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        final String playerusername = b.getString("playerusername");
        tvResult.setText("Your score is " + score + "/8.");
        db.saveScore(b);
        Button bBacKToStart = (Button)findViewById(R.id.bBackToStart);

        bBacKToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainmenuintent = new Intent(Results.this, UserAreaActivity.class);
                mainmenuintent.putExtra("playerusername" , playerusername);
                startActivity(mainmenuintent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
