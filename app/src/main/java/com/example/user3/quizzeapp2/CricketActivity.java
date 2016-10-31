package com.example.user3.quizzeapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CricketActivity extends AppCompatActivity {
    /*
    *declaring variable
     */
    private Spinner question1, question2, question3, question4, question5;
    private List<String> question1Answers, question2Answers, question3Answers, question4Answers, question5Answers;
    ArrayAdapter<String> q1Adapter, q2Adapter, q3Adapter, q4Adapter, q5Adapter;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        /*
        *initializing
         */
        question1 = (Spinner) findViewById(R.id.qustion1_spinner);
        question2 = (Spinner) findViewById(R.id.qustion2_spinner);
        question3 = (Spinner) findViewById(R.id.qustion3_spinner);
        question4 = (Spinner) findViewById(R.id.qustion4_spinner);
        question5 = (Spinner) findViewById(R.id.qustion5_spinner);

        /*
        *creating arraylist object
         */

        question1Answers = new ArrayList<>();
        question2Answers = new ArrayList<>();
        question3Answers = new ArrayList<>();
        question4Answers = new ArrayList<>();
        question5Answers = new ArrayList<>();

        question1Answers.add(" ");
        question1Answers.add(getResources().getString(R.string.austalia));//
        question1Answers.add(getResources().getString(R.string.pakistan));
        question1Answers.add(getResources().getString(R.string.west_indies));

        /*
        * putting list in adapter
         */
        q1Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question1Answers);

        /*
        *setting adapter in to spinner
         */
        question1.setAdapter(q1Adapter);


        /*
        *test which answer is selected
         */
        if (question1.getSelectedItem().toString().equals(getResources().getString(R.string.austalia))) {
            score++;

            Log.d("Score: ", " " + score);

        }


        /*
        *adding answers in to list
         */
        question2Answers.add(" ");
        question2Answers.add(getResources().getString(R.string.austalia));//
        question2Answers.add(getResources().getString(R.string.sri_anka));
        question2Answers.add(getResources().getString(R.string.bangladesh));

           /*
        * putting list in adapter
         */
        q2Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question2Answers);

        /*
        *setting adapter in to spinner
         */
        question2.setAdapter(q2Adapter);

        /*
        *adding answers in to list
         */
        question3Answers.add(" ");
        question3Answers.add(getResources().getString(R.string.yes));//
        question3Answers.add(getResources().getString(R.string.no));
        question3Answers.add(getResources().getString(R.string.maybe));

           /*
        * putting list in adapter
         */
        q3Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question3Answers);

        /*
        *setting adapter in to spinner
         */
        question3.setAdapter(q3Adapter);


        /*
        *adding answers in to list
         */
        question4Answers.add(" ");
        question4Answers.add(getResources().getString(R.string.new_zealand));
        question4Answers.add(getResources().getString(R.string.south_africa));
        question4Answers.add(getResources().getString(R.string.west_indies));//


           /*
        * putting list in adapter
         */
        q4Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question4Answers);

        /*
        *setting adapter in to spinner
         */
        question4.setAdapter(q4Adapter);


        /*
        *adding answers in to list
         */
        question5Answers.add(" ");
        question5Answers.add(getResources().getString(R.string.no));//
        question5Answers.add(getResources().getString(R.string.yes));
        question5Answers.add(getResources().getString(R.string.maybe));

           /*
        * putting list in adapter
         */
        q5Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question5Answers);

        /*
        *setting adapter in to spinner
         */
        question5.setAdapter(q5Adapter);


    }

    public void submitQuize(View view) {
         /*
        *test which answer is selected
         */
        if (question1.getSelectedItem().toString().equals(getResources().getString(R.string.austalia))) {
            score++;

            Log.d("Score: ", " " + score);

        }

         /*
        *test which answer is selected
         */
        if (question2.getSelectedItem().toString().equals(getResources().getString(R.string.austalia))) {
            score++;
            Log.d("Score: ", " " + score);

        }

           /*
        *test which answer is selected
         */
        if (question3.getSelectedItem().toString().equals(getResources().getString(R.string.yes))) {
            score++;
            Log.d("Score: ", " " + score);

        }


      /*
        *test which answer is selected
         */
        if (question4.getSelectedItem().toString().equals(getResources().getString(R.string.west_indies))) {
            score++;
            Log.d("Score: ", " " + score);

        }

            /*
        *test which answer is selected
         */
        if (question5.getSelectedItem().toString().equals(getResources().getString(R.string.no))) {
            score++;
            Log.d("Score: ", " " + score);

        }
        Intent intent = new Intent(CricketActivity.this, ResultsActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score); //Your score
        b.putInt("id", 1);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

}
