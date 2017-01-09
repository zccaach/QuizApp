package com.example.akhlak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Quiz extends AppCompatActivity {

    List<question_class> quesList;
    int score = 0;
    int qid=0;
    int ansid=0;
    question_class currentQ;
    TextView txtQuestion, tvAnswered;
    Button bA, bB, bC , bSkip, bNext, bPrevious;
    boolean[] questionAttempted = {false,false,false,false,false,false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

            QuizDatabase db = new QuizDatabase(this);
            quesList = db.getAllQuestions();
            currentQ = quesList.get(qid);


            txtQuestion = (TextView) findViewById(R.id.tvQuestion);
            bA = (Button) findViewById(R.id.bA);
            bB = (Button) findViewById(R.id.bB);
            bC = (Button) findViewById(R.id.bC);
            bSkip = (Button) findViewById(R.id.bSkip);
            bNext = (Button) findViewById(R.id.bNext);
            bPrevious = (Button) findViewById(R.id.bPrevious);
            tvAnswered = (TextView)findViewById(R.id.tvAnswered);
            final String Answered = "answered";



            bA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(questionAttempted[qid]){
                        Toast alreadyansweredtoast = Toast.makeText(Quiz.this, "You have already attempted this question!", Toast.LENGTH_SHORT);
                        alreadyansweredtoast.show();


                    }
                    else{
                        getANSWER(bA.getText().toString());
                        questionAttempted[qid]=true;

                        endquiz();
                    }
                }
            });

            bB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(questionAttempted[qid]){
                        Toast alreadyansweredtoast = Toast.makeText(Quiz.this, "You have already attempted this question!", Toast.LENGTH_SHORT);
                        alreadyansweredtoast.show();


                    }
                    else{
                        getANSWER(bB.getText().toString());
                        questionAttempted[qid]=true;

                        endquiz();
                    }
                }
            });

            bC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(questionAttempted[qid]){
                        Toast alreadyansweredtoast = Toast.makeText(Quiz.this, "You have already attempted this question!", Toast.LENGTH_SHORT);
                        alreadyansweredtoast.show();


                    }
                    else{
                        getANSWER(bC.getText().toString());
                        questionAttempted[qid]=true;

                        endquiz();
                    }
                }
            });

            bSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(questionAttempted[qid]){
                        Toast alreadyansweredtoast = Toast.makeText(Quiz.this, "You have already attempted this question!", Toast.LENGTH_SHORT);
                        alreadyansweredtoast.show();

                    }
                    else{
                        ansid++;
                        Toast skiptoast = Toast.makeText(Quiz.this, "The answer is " + currentQ.getANSWER() + ".", Toast.LENGTH_SHORT);
                        skiptoast.show();
                        questionAttempted[qid]=true;

                        endquiz();

                    }



                }
            });

            bNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qid < 9){
                        qid++;
                        currentQ = quesList.get(qid);
                        setQuestionView();

                    }
                    else {
                        Toast nomoreqtoast = Toast.makeText(Quiz.this, "No more questions!" , Toast.LENGTH_SHORT);
                        nomoreqtoast.show();
                    }
                }
            });

            bPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qid > 0){
                        qid--;
                        currentQ = quesList.get(qid);
                        setQuestionView();


                    }
                    else {
                        Toast nomoreqtoast = Toast.makeText(Quiz.this, "No more questions!" , Toast.LENGTH_SHORT);
                        nomoreqtoast.show();
                    }
                }
            });

            setQuestionView();
            endquiz();



        }


    public void getANSWER(String AnswerString){
        if (currentQ.getANSWER().equals(AnswerString)){
            score++;
            ansid++;
            Toast correcttoast = Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_SHORT);
            correcttoast.show();

        }

        else{
            ansid++;
            Toast incorrecttoast = Toast.makeText(Quiz.this, "Incorrect." , Toast.LENGTH_SHORT);
            incorrecttoast.show();

        }



    }

    public void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        bA.setText(currentQ.getOPTA());
        bB.setText(currentQ.getOPTB());
        bC.setText(currentQ.getOPTC());

    }

    public void endquiz()
    {
        if(ansid == 8)
        {
            Intent resultintent = new Intent(Quiz.this, Results.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            b.putString("playerusername" , getIntent().getStringExtra("playerusername"));
            resultintent.putExtras(b);
            startActivity(resultintent);
        }
    }

    @Override
    public void onBackPressed() {

    }

    }

