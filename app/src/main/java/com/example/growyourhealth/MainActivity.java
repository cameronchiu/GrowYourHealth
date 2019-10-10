package com.example.growyourhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        String day = dayFormat.format(Calendar.getInstance().getTime());
        Button startDay = (Button) findViewById(R.id.buttonDayOfWeek);
        startDay.setText(day);


    }

    DateFormat dateFormat = new SimpleDateFormat("d");
    String date = dateFormat.format(Calendar.getInstance().getTime());
    private int startDate = 0; //variable extracted from database
    private int currentDate = Integer.valueOf(date);

    public void updateTree(View V){
        TextView test = (TextView) findViewById(R.id.textViewtest);



        test.setText(date);

    }

    public void goToQuestions(View v){
        //sends user to questions activity
        //sets button to either "Grow Tree' or "Plant Tree"
        Button submit = (Button) findViewById(R.id.buttonSubmit);
        if(startDate-currentDate==0){
            submit.setText("Plant Tree");
        }
        else{
            submit.setText("Grow Tree");
        }

    }
}
