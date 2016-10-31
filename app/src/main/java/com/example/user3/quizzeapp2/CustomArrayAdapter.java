package com.example.user3.quizzeapp2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by User3 on 2016/10/04.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    /*
    *globally declaring variables
     */
    private Context context;
    private String[] questionArray;
    public static int score = 0;
    private RadioGroup groupAnswers;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param questionArray  The objects to represent in the ListView.
     */
    public CustomArrayAdapter(Context context, int resource, String[] questionArray) {
        super(context, resource, questionArray);

        this.context = context;
        this.questionArray = questionArray;
    }


    /*
    *overriding the getView method
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        /*
        *validating if view is not null
         */
        if(view == null)
        {
            /*
            *if null inflate the view
             */
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.row,parent, false);
        }


        /*
        *instantiating text view and set the text from the array
         */
        TextView textView = (TextView)view.findViewById(R.id.displayQuestion);
        textView.setText(questionArray[position]);

         /*
        *instantiating radio button and radio group
         */
        RadioButton bt1 = (RadioButton)view.findViewById(R.id.a1);
        RadioButton bt2 = (RadioButton)view.findViewById(R.id.a2);
        RadioButton bt3 = (RadioButton)view.findViewById(R.id.a3);
        groupAnswers = (RadioGroup)view.findViewById(R.id.groupRadioButtons);



        /*
        *checking which question is at a certain position
         */
        if(questionArray[position].equals("What is the most widely used programming language?"))
        {

            /*
            *populating array list with answers for certain question
             */
            List<String> firstQ = new ArrayList<String>();
            firstQ.add("Java");
            firstQ.add("C++");
            firstQ.add("Python");

            /*
            *shuffling tha array list
            * the answers should be in different position everytime a user plays
             */
            Collections.shuffle(firstQ);

            /*
            *setting text to radio buttons wich are answers to match the question
             */
            bt1.setText(firstQ.get(0));
            bt2.setText(firstQ.get(1));
            bt3.setText(firstQ.get(2));

            /*
            *getting text from radio button
             */
            final String bt1Answer = bt1.getText().toString();
            final String bt2Answer = bt2.getText().toString();
            final String bt3Answer = bt2.getText().toString();

            /*
            *calling on checked change listener method for radio group
             */
            groupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {


                    /*
                    *check which radio button is clicked
                     */
                    if(checkedId == R.id.a1)
                    {
                        /*
                        *from the selected radio button, test if the text is equivalent to correct
                        * or incorrect answer
                         */
                        if(bt1Answer.equals("Java"))
                        {
                            /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;


                        }else if(bt1Answer.equals("C++"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Python"))
                        {

                            /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a2)
                    {
                        if(bt2Answer.equals("Java"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("C++"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Python"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a3)
                    {
                        if(bt3Answer.equals("Java"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("C++"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Python"))
                        {
                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }
                }
            });
        }
        else if(questionArray[position].equals("What was the first operating system?"))
        {

              /*
            *populating array list with answers for certain question
             */
            List<String> secondtQ = new ArrayList<String>();
            secondtQ.add("MDOS");
            secondtQ.add("Window 7");
            secondtQ.add("Linux");

              /*
            *shuffling tha array list
            * the answers should be in different position everytime a user plays
             */
            Collections.shuffle(secondtQ);

             /*
            *setting text to radio buttons wich are answers to match the question
             */
            bt1.setText(secondtQ.get(0));
            bt2.setText(secondtQ.get(1));
            bt3.setText(secondtQ.get(2));


             /*
            *getting text from radio button
             */
            final String bt1Answer = bt1.getText().toString();
            final String bt2Answer = bt2.getText().toString();
            final String bt3Answer = bt2.getText().toString();



               /*
            *calling on checked change listener method for radio group
             */
            groupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.a1)
                    {
                        if(bt1Answer.equals("Window 7"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Linux"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("MDOS"))
                        {
                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a2)
                    {
                        if(bt2Answer.equals("Window 7"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Linux"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("MDOS"))
                        {
                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a3)
                    {
                        if(bt3Answer.equals("Window 7"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Linux"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("MDOS"))
                        {
                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }
                }
            });
        }else if(questionArray[position].equals("Which year was the first computer created?"))
        {

              /*
            *populating array list with answers for certain question
             */
            List<String> thirdQ = new ArrayList<String>();
            thirdQ.add("1948");
            thirdQ.add("1936");
            thirdQ.add("1840");

              /*
            *shuffling tha array list
            * the answers should be in different position everytime a user plays
             */
            Collections.shuffle(thirdQ);

             /*
            *setting text to radio buttons wich are answers to match the question
             */
            bt1.setText(thirdQ.get(0));
            bt2.setText(thirdQ.get(1));
            bt3.setText(thirdQ.get(2));


             /*
            *getting text from radio button
             */
            final int bt1Answer = Integer.parseInt(bt1.getText().toString());
            final int bt2Answer = Integer.parseInt(bt2.getText().toString());
            final int bt3Answer = Integer.parseInt(bt3.getText().toString());

            /*
            *calling on checked change listener method for radio group
             */
            groupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.a1)
                    {
                        if(bt1Answer == 1948)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer == 1840)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer == 1936)
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a2)
                    {
                        if(bt2Answer == 1948)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer == 1840)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer == 1936)
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a3)
                    {
                        if(bt3Answer == 1948)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer == 1840)
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer == 1936)
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }
                }
            });

        }else if(questionArray[position].equals("Which one is the best web browser?"))
        {

              /*
            *populating array list with answers for certain question
             */
            List<String> forthQ = new ArrayList<String>();
            forthQ.add("Opera Mini");
            forthQ.add("Mozilla Firefox");
            forthQ.add("Google Chrome");

              /*
            *shuffling tha array list
            * the answers should be in different position everytime a user plays
             */
            Collections.shuffle(forthQ);

             /*
            *setting text to radio buttons wich are answers to match the question
             */
            bt1.setText(forthQ.get(0));
            bt2.setText(forthQ.get(1));
            bt3.setText(forthQ.get(2));


             /*
            *getting text from radio button
             */
            final String bt1Answer = bt1.getText().toString();
            final String bt2Answer = bt2.getText().toString();
            final String bt3Answer = bt2.getText().toString();

            /*
            *calling on checked change listener method for radio group
             */
            groupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.a1)
                    {
                        if(bt1Answer.equals("Opera Mini"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Google Chrome"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Mozilla Firefox"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a2)
                    {
                        if(bt2Answer.equals("Opera Mini"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Google Chrome"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Mozilla Firefox"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a3)
                    {
                        if(bt3Answer.equals("Opera Mini"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Google Chrome"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Mozilla Firefox"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }
                }
            });
        }else if(questionArray[position].equals("Which signal transmission technology is the latest?"))
        {
              /*
            *populating array list with answers for certain question
             */
            List<String> fifthQ = new ArrayList<String>();
            fifthQ.add("Digital");
            fifthQ.add("Analog");
            fifthQ.add("Non");

              /*
            *shuffling tha array list
            * the answers should be in different position everytime a user plays
             */
            Collections.shuffle(fifthQ);

             /*
            *setting text to radio buttons wich are answers to match the question
             */
            bt1.setText(fifthQ.get(0));
            bt2.setText(fifthQ.get(1));
            bt3.setText(fifthQ.get(2));


             /*
            *getting text from radio button
             */
            final String bt1Answer = bt1.getText().toString();
            final String bt2Answer = bt2.getText().toString();
            final String bt3Answer = bt2.getText().toString();

            /*
            *calling on checked change listener method for radio group
             */
            groupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.a1)
                    {
                        if(bt1Answer.equals("Analog"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Non"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt1Answer.equals("Digital"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a2)
                    {
                        if(bt2Answer.equals("Analog"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Non"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt2Answer.equals("Digital"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }else   if(checkedId == R.id.a3)
                    {
                        if(bt3Answer.equals("Analog"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Non"))
                        {
                             /*
                            *incrementing the the total score with 0 if answer is incorrect
                             */
                            score += 0;
                        }else if(bt3Answer.equals("Digital"))
                        {

                             /*
                            *incrementing the the total score with 1 if answer is correct
                             */
                            score += 1;
                        }
                    }
                }
            });

        }



        return view;
    }
}
