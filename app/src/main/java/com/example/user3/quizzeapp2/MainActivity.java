package com.example.user3.quizzeapp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner topics;
    private ArrayAdapter<String> adapter;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *Declaring and Initialising array for spinner
         */


        String[] topicArray = {"Select option","Android", "Cricket", "Technology"};

         /*
        *Initialising spinner and adapter array and also setting adapater to spinner
         */
        topics = (Spinner)findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, topicArray);
        topics.setAdapter(adapter);

        /*
        *Initialising button and and set background image to it
         */
        btn = (Button)findViewById(R.id.continueButton);

    }


    public void buttonContinue(View view)
    {
        String text = topics.getSelectedItem().toString();

          /*
          *Check which topic is selected and direct user to relevent screens to do the quizze
          * if user did not select topic error message pops up
         */

        if(text.equals("Android"))
        {
            Intent intent = new Intent(this, FirstTopicActivity.class);
            startActivity(intent);


        }
        else if(text.equals("Cricket"))
        {
            Intent intent = new Intent(this, CricketActivity.class);
            startActivity(intent);

        }
        else if(text.equals("Technology"))
        {
            Intent intent = new Intent(this, TechnologyActivity.class);
            intent.putExtra("id",3);
            startActivity(intent);

        }
        else if(text.equals("Select option"))
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Error");
            dialog.setMessage("Nothing selected, Please select a topic to move forward");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog builder = dialog.create();
            builder.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);


        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        return true;
    }


}
