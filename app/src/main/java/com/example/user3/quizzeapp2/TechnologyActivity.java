package com.example.user3.quizzeapp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class TechnologyActivity extends AppCompatActivity {

    List<Questions> questionList;
    int score = 0;
    int currentQuestionId=0;
    QuestionDatabase database;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private Questions currentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);

        database = new QuestionDatabase(this);
        questionList = database.getAllQuestions();
        currentQ = questionList.get(currentQuestionId);

        txtQuestion=(TextView)findViewById(R.id.display_question);

        rda=(RadioButton) findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);

        butNext=(Button)findViewById(R.id.button_next);

        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rda.setChecked(false);
                rdb.setChecked(false);
                rdc.setChecked(false);

                RadioGroup grp=(RadioGroup)findViewById(R.id.groupRadioButtons);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());

                try {

                    if (currentQ.getANSWER().equals(answer.getText())) {
                        score++;
                        Log.d("Score: ", " " + score);
                    }

                    if (currentQuestionId < 5) {

                        currentQ = questionList.get(currentQuestionId);
                        setQuestionView();

                    } else {
                        Intent intent = new Intent(TechnologyActivity.this, ResultsActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putInt("id", 2);
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }catch (NullPointerException e)
                {
                    e.getMessage();
                }
            }

        });

    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        currentQuestionId++;
    }

    public void buttonExit(View view)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Quit");
        dialog.setMessage("Are you sure you want to quit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog builder = dialog.create();
        builder.show();
    }
}
