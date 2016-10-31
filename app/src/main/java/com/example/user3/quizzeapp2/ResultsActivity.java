package com.example.user3.quizzeapp2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private TextView viewQuestions;
    private  int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        /*
        *get rating bar object
        */
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
        viewQuestions = (TextView)findViewById(R.id.reviewQuestions) ;

        /*
        *get text view
        */
        TextView t = (TextView) findViewById(R.id.textResult);

        /*
        *get score
        */
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        id = b.getInt("id");


        if (id == 1) {
              /*
            *display score
            */
            bar.setRating(score);

            if (score == 1 || score == 2) {
                t.setText("Score: " + score + ", Sorry! Try again");
            } else if (score == 3 || score == 4) {
                t.setText("Score: " + score + ", Have you been reading cricket blogs?");
            } else if (score == 5) {
                t.setText("Score: " + score + ", Wow! Are you a cricket star?");
            } else {
                t.setText("Score: " + score + ", Cricket is not your thing try another topic");
            }
        } else if (id == 2) {
            /*
            *display score
            */
            bar.setRating(score);

            if (score == 1 || score == 2) {
                t.setText("Score: " + score + ", Sorry! Try again");
            } else if (score == 3 || score == 4) {
                t.setText("Score: " + score + ", Have you been practicing computer science");
            } else if (score == 5) {
                t.setText("Score: " + score + ", Wow! are you computer science");
            } else {
                t.setText("Score: " + score + ", Computer Science is not your thing try another topic");
            }
        }


    }


    public void reviewQuestions(View view)
    {
        if(id == 1) {

            viewQuestions.setText("This is how you should have answered:\n" +
                    "\n \nQ: "+ getResources().getString(R.string.opponent) + "\nA: " +getResources().getString(R.string.austalia) +
                    "\n \nQ: "+ getResources().getString(R.string.batman) + "\nA: " +getResources().getString(R.string.austalia) +
                    "\n \nQ: "+ getResources().getString(R.string.browler) + "\nA: " +getResources().getString(R.string.yes) +
                    "\n \nQ: "+ getResources().getString(R.string.twenty_twenty) + "\nA: " +getResources().getString(R.string.west_indies) +
                    "\n \nQ: "+ getResources().getString(R.string.ever_won) + "\nA: " +getResources().getString(R.string.no));

        }else if(id == 2) {

            viewQuestions.setText("This is how you should have answered:\n" +
                    "\n \nQ: "+ getResources().getString(R.string.largest) + "\nA: " +getResources().getString(R.string.cisco) +
                    "\n \nQ: "+ getResources().getString(R.string.os) + "\nA: " +getResources().getString(R.string.bios) +
                    "\n \nQ: "+ getResources().getString(R.string.memory) + "\nA: " +getResources().getString(R.string.register) +
                    "\n \nQ: "+ getResources().getString(R.string.traffic) + "\nA: " +getResources().getString(R.string.register) +
                    "\n \nQ: "+ getResources().getString(R.string.language) + "\nA: " +getResources().getString(R.string.basic));
        }

    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
