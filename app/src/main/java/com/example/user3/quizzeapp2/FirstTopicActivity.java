package com.example.user3.quizzeapp2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FirstTopicActivity extends AppCompatActivity {

    /*
    *declaring variables global
     */
    private TextView tvQuestion, timeLeft;
    private int score = 0;
    private int currentIndex = 0;
    private String currentQuestion;
    private Button button;
    private Button buttonScore;
    private RadioButton rbAnswer1, rbAnswer2, rbAnswer3;
    private RadioGroup rgAnswers;
    private ArrayList<String> questionArrayList;
    private CountDownTimer countDown;


      /*
    *declaring variables and initializing string array that stores questions
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_topic);

        /*
        *referencing text view that will display questions. one at a time
         */
        tvQuestion = (TextView) findViewById(R.id.question_text_view);
        timeLeft = (TextView)findViewById(R.id.timeLeft);

          /*
        *referencing button that will start the quizze and late act as next button
        * referencing radio group that contain radio buttons
         */
        button = (Button) findViewById(R.id.change_next);
        rgAnswers = (RadioGroup) findViewById(R.id.groupAnswers);
        buttonScore = (Button)findViewById(R.id.view_score);

          /*
        *referencing radio buttons that displays answers for certain question to choose from
         */
        rbAnswer1 = (RadioButton) findViewById(R.id.answer1);
        rbAnswer2 = (RadioButton) findViewById(R.id.answer2);
        rbAnswer3 = (RadioButton) findViewById(R.id.answer3);

          /*
        *setting all radio buttons to invisible
        * they are not supposed to be visible before you start the quizze
         */
        buttonScore.setEnabled(false);
        rbAnswer1.setVisibility(View.GONE);
        rbAnswer2.setVisibility(View.GONE);
        rbAnswer3.setVisibility(View.GONE);

        /*
        *Creating new object of array list
         */

        questionArrayList = new ArrayList<>();


        /*
        *populating array list with questions
         */

        questionArrayList.add(getResources().getString(R.string.user_interface));
        questionArrayList.add(getResources().getString(R.string.directory));
        questionArrayList.add(getResources().getString(R.string.basic_building_element));
        questionArrayList.add(getResources().getString(R.string.manifest));
        questionArrayList.add(getResources().getString(R.string.class_inherited));

        /*
        *shuffling questions in the array list every time a user plays the quiz
         */

        Collections.shuffle(questionArrayList);



    }


    public void startQuizze(View view) {

        if(countDown != null)
        {
            countDown.cancel();
        }

        countDown = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeLeft.setText("Time left: " + String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                timeLeft.setText("Time up!");
                if(timeLeft.getText().equals("Time up!"))
                {
                    rbAnswer1.setEnabled(false);
                    rbAnswer2.setEnabled(false);
                    rbAnswer3.setEnabled(false);
                }
            }
        }.start();




        /*
        *changing text on button
         */

        button.setText("Next");

          /*
        *setting all radio buttons to invisible
        * they are not supposed to be visible before you start the quizze
         */
        rbAnswer1.setVisibility(View.VISIBLE);
        rbAnswer2.setVisibility(View.VISIBLE);
        rbAnswer3.setVisibility(View.VISIBLE);


        /*
        *setting selected false for all radio buttons
         */
        rbAnswer1.setChecked(false);
        rbAnswer2.setChecked(false);
        rbAnswer3.setChecked(false);



        /*
        *tesing if current index has not exceeded the of array list
         */

        if (currentIndex < questionArrayList.size()) {
            /*
            *getting question at current index
             */

            currentQuestion = questionArrayList.get(currentIndex);
            Log.d("question", currentQuestion);


             /*
            *testing which question is displayed/stored in the question variable/where currently the
             *cursor is
             */
            if (currentQuestion.equals(getResources().getString(R.string.user_interface))) {

            /*
            *setting currentQuestion to text view
             */
                tvQuestion.setText(currentQuestion);

             /*
              *creating array list to store answers
             */

                ArrayList<String> userInterface = new ArrayList<>();

            /*
            *adding answers to array list
             */
             userInterface.add(getResources().getString(R.string.isTrue));
             userInterface.add(getResources().getString(R.string.isFalse));
             userInterface.add(getResources().getString(R.string.none));

             Collections.shuffle(userInterface);

            /*
            *setting text to all radio buttons
             */
                rbAnswer1.setText(userInterface.get(0));
                rbAnswer2.setText(userInterface.get(1));
                rbAnswer3.setText(userInterface.get(2));


                rbAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        String text = rbAnswer1.getText().toString();
                        if(isChecked && text.equals(getResources().getString(R.string.isFalse)))
                        {

                                score += 1;

                        }
                        rbAnswer2.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });

                rbAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && rbAnswer2.getText().toString().equals(getResources().getString(R.string.isFalse)))
                        {

                                 score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && (rbAnswer3.getText().toString().equals(getResources().getString(R.string.isFalse))))
                        {

                                score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer2.setEnabled(false);
                    }
                });






            } else if (currentQuestion.equals(getResources().getString(R.string.directory))) {

            /*
            *setting currentQuestion to text view
             */
                tvQuestion.setText(currentQuestion);

             /*
              *creating array list to store answers
             */

                ArrayList<String> direcory = new ArrayList<>();

            /*
            *adding answers to array list
             */
                direcory.add(getResources().getString(R.string.res));
                direcory.add(getResources().getString(R.string.drawable));
                direcory.add(getResources().getString(R.string.values));

                Collections.shuffle(direcory);

            /*
            *setting text to all radio buttons
             */
                rbAnswer1.setText(direcory.get(0));
                rbAnswer2.setText(direcory.get(1));
                rbAnswer3.setText(direcory.get(2));


                rbAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                        String text = rbAnswer1.getText().toString();
                        if(isChecked && text.equals(getResources().getString(R.string.res)))
                        {

                                score += 1;

                        }
                        rbAnswer2.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });

                rbAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && rbAnswer2.getText().toString().equals(getResources().getString(R.string.res)))
                        {

                            score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && (rbAnswer3.getText().toString().equals(getResources().getString(R.string.res))))
                        {

                            score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer2.setEnabled(false);
                    }
                });




            } else if (currentQuestion.equals(getResources().getString(R.string.basic_building_element))) {

             /*
            *setting currentQuestion to text view
             */
                tvQuestion.setText(currentQuestion);

             /*
              *creating array list to store answers
             */

                ArrayList<String> basicElement = new ArrayList<>();

            /*
            *adding answers to array list
             */
                basicElement.add(getResources().getString(R.string.layout));
                basicElement.add(getResources().getString(R.string.view));
                basicElement.add(getResources().getString(R.string.xml));

                Collections.shuffle(basicElement);

            /*
            *setting text to all radio buttons
             */
                rbAnswer1.setText(basicElement.get(0));
                rbAnswer2.setText(basicElement.get(1));
                rbAnswer3.setText(basicElement.get(2));


                rbAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                        String text = rbAnswer1.getText().toString();
                        if(isChecked && text.equals(getResources().getString(R.string.view)))
                        {
                                score += 1;

                        }
                        rbAnswer2.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });

                rbAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && rbAnswer2.getText().toString().equals(getResources().getString(R.string.view)))
                        {

                            score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && (rbAnswer3.getText().toString().equals(getResources().getString(R.string.view))))
                        {

                            score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer2.setEnabled(false);
                    }
                });



            } else if (currentQuestion.equals(getResources().getString(R.string.manifest))) {

             /*
            *setting currentQuestion to text view
             */
                tvQuestion.setText(currentQuestion);

             /*
              *creating array list to store answers
             */

                ArrayList<String> manifest = new ArrayList<>();

            /*
            *adding answers to array list
             */
                manifest.add(getResources().getString(R.string.manifests));
                manifest.add(getResources().getString(R.string.view));
                manifest.add(getResources().getString(R.string.xml));

                Collections.shuffle(manifest);

            /*
            *setting text to all radio buttons
             */
                rbAnswer1.setText(manifest.get(0));
                rbAnswer2.setText(manifest.get(1));
                rbAnswer3.setText(manifest.get(2));


                rbAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                        String text = rbAnswer1.getText().toString();
                        if(isChecked && text.equals(getResources().getString(R.string.manifests)))
                        {
                                score += 1;

                        }
                        rbAnswer2.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });

                rbAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && rbAnswer2.getText().toString().equals(getResources().getString(R.string.manifests)))
                        {

                            score += 1;
                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && (rbAnswer3.getText().toString().equals(getResources().getString(R.string.manifests))))
                        {

                            score += 1;

                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer2.setEnabled(false);

                    }
                });

            } else if (currentQuestion.equals(getResources().getString(R.string.class_inherited))) {

                 /*
            *setting currentQuestion to text view
             */
                tvQuestion.setText(currentQuestion);

             /*
              *creating array list to store answers
             */

                ArrayList<String> inherit = new ArrayList<>();

            /*
            *adding answers to array list
             */
                inherit.add(getResources().getString(R.string.activity));
                inherit.add(getResources().getString(R.string.compat));
                inherit.add(getResources().getString(R.string.view));

                Collections.shuffle(inherit);

            /*
            *setting text to all radio buttons
             */
                rbAnswer1.setText(inherit.get(0));
                rbAnswer2.setText(inherit.get(1));
                rbAnswer3.setText(inherit.get(2));


                rbAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                        //String text = rbAnswer1.getText().toString();
                        if(rbAnswer1.getText().equals(getResources().getString(R.string.activity)))
                        {


                                score += 1;

                        }
                        rbAnswer2.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        if(isChecked && rbAnswer2.getText().toString().equals(getResources().getString(R.string.activity)))
                        {

                            score += 1;
                        }
                        rbAnswer1.setEnabled(false);
                        rbAnswer3.setEnabled(false);
                    }
                });


                rbAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(isChecked && (rbAnswer3.getText().toString().equals(getResources().getString(R.string.activity))))
                    {

                        score += 1;
                    }
                    rbAnswer1.setEnabled(false);
                    rbAnswer2.setEnabled(false);

                    }
                });


            }


        }

        /*
        *enabling all radio buttons
         */
        rbAnswer1.setEnabled(true);
        rbAnswer2.setEnabled(true);
        rbAnswer3.setEnabled(true);

        currentIndex++;

        if(currentIndex > 5)
        {
            button.setText("Finished");
            buttonScore.setEnabled(true);
            button.setEnabled(false);
             /*
            *setting all radio buttons to invisible
            * they are not supposed to be visible before you start the quizze
             */
            tvQuestion.setText(" ");

            if(countDown != null) {
                countDown.cancel();
            }timeLeft.setText(" ");
            rbAnswer1.setVisibility(View.GONE);
            rbAnswer2.setVisibility(View.GONE);
            rbAnswer3.setVisibility(View.GONE);


            //startActivity(new Intent(FirstTopicActivity.this, MainActivity.class));
        }

    }


    public void viewScore(View view) {



        /*
        *instatiating alert dialog to view score
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        /*
        *setting title for alert dialog
         */
        builder.setTitle("Score");

        /*
        *converting score to percentage
         */
        int totalScore = (score / 5) * 100;
        Log.d("Score: ", " " + totalScore);

        /*
        *determing results based on score
         */
        if (score < 3) {

            /*
            *displaying results and score
             */
            builder.setMessage("Sorry! Your score is " + score + "/5 you did not make it.");
        } else if (score >= 3 && score <= 4) {

             /*
            *displaying results and score
             */
            builder.setMessage("Congratulations! Your score is " + score + "/5 you passed.");

       } else if (score == 5) {

             /*
            *displaying results and score
             */
            builder.setMessage("Congratulations! Your score is " + score + "/5 you passed with distinction.");

        }

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        /*
        *create alert dialog
         */
        AlertDialog dialog = builder.create();

        /*
        *showing alert dialog
         */
         dialog.show();
    }


}