package com.example.akhlak.quizapp;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        LoginFrag fragmment = new LoginFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentcontainer, fragmment, null);
        ft.commit();

        Button registerLink = (Button) findViewById(R.id.registerpageLink);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registerfrag fragmment2 = new Registerfrag();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentcontainer, fragmment2, null);
                ft.commit();
            }
        });

        Button bLogin = (Button) findViewById(R.id.bLoginPage);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFrag fragmment = new LoginFrag();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentcontainer, fragmment, null);
                ft.commit();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
