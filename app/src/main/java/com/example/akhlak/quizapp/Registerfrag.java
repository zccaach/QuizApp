package com.example.akhlak.quizapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registerfrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registerfrag, container, false);
    }
        DatabaseHelper helper;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button bRegister = (Button) getView().findViewById(R.id.bRegister);
        helper = new DatabaseHelper(getActivity());
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                EditText Name = (EditText)getView().findViewById(R.id.etName);
                EditText Email = (EditText)getView().findViewById(R.id.etEmail);
                EditText Username = (EditText)getView().findViewById(R.id.etUsername);
                EditText Password = (EditText)getView().findViewById(R.id.etPassword);
                EditText Password2 = (EditText)getView().findViewById(R.id.etPassword2);

                String Namestr = Name.getText().toString();
                String Emailstr = Email.getText().toString();
                String Usernamestr = Username.getText().toString();
                String Passwordstr = Password.getText().toString();
                String Password2str = Password2.getText().toString();

                String Usernamedb = helper.searchUsername(Username.getText().toString());

                if (Namestr.equals("")||Emailstr.equals("")||Usernamestr.equals("")||Passwordstr.equals("")||Password2str.equals(""))
                {
                    Toast pass1 = Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT);
                    pass1.show();
                }

                else if(Usernamestr.equals(Usernamedb))
                {
                    Toast username = Toast.makeText(getActivity(),"Username already exists, please use another" , Toast.LENGTH_SHORT);
                    username.show();
                }


                else if (!Passwordstr.equals(Password2str))
                {
                    //POP UP MESSAGE
                    Toast pass = Toast.makeText(getActivity(), "Passwords do not match" , Toast.LENGTH_SHORT);
                    pass.show();
                }
                else
                {
                    //puts data in database
                    Contact c = new Contact();
                    c.setName(Namestr);
                    c.setEmail(Emailstr);
                    c.setPassword(Passwordstr);
                    c.setUsername(Usernamestr);

                    helper.insertContact(c);

                    Toast pass = Toast.makeText(getActivity(), "Account registered" , Toast.LENGTH_SHORT);
                    pass.show();

//                    Intent BackToRegisterIntent = new Intent(getActivity(), LoginActivity.class);
//
//                    startActivity(BackToRegisterIntent);




                }
            }
        });






    }
    }

