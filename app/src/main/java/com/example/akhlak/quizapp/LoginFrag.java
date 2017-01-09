package com.example.akhlak.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.app.Fragment;
import android.widget.Toast;


public class LoginFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    DatabaseHelper helper;
    EditText etUsername, etPassword;
    String etUsernamestr, etPasswordstr, Password;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper = new DatabaseHelper(getActivity());
        Button bLogin = (Button) getView().findViewById(R.id.bLogin);
        etUsername = (EditText) getView().findViewById(R.id.etUsername);
        etPassword = (EditText) getView().findViewById(R.id.etPassword);





        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsernamestr = etUsername.getText().toString();
                etPasswordstr = etPassword.getText().toString();
                Password = helper.searchPass(etUsername.getText().toString());
                if (etUsernamestr.equals("")||etPasswordstr.equals(""))
                {
                    Toast emptyvalues = Toast.makeText(LoginFrag.this.getActivity(), "Please fill all fields" , Toast.LENGTH_SHORT);
                    emptyvalues.show();
                }
                else if (etPasswordstr.equals(Password))
                {
                    Intent loginIntent = new Intent(LoginFrag.this.getActivity(), UserAreaActivity.class);
                    loginIntent.putExtra("playerusername", etUsernamestr);
                    startActivity(loginIntent);
                }
                else
                {
                    Toast pass = Toast.makeText(LoginFrag.this.getActivity(), "Incorrect login details, you idiot!" , Toast.LENGTH_SHORT);
                    pass.show();
                }
            }
        });
    }
}

