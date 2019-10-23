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

    DateFormat dateFormat = new SimpleDateFormat("d");
    DateFormat monthFormat = new SimpleDateFormat("MM");
    private int currentDayOfYear;
    private boolean weekInProgress;

    //Preferences
    private int stepsGoal = 10000;
    private int cupsOfWaterGoal = 8;
    private int numberOfMealsGoal = 3;
    private int caloriesConsumedGoal = 2000;
    private int hoursOfSleepGoal = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Sets home screen button to Sunday, Monday, Tuesday, etc.
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        String day = dayFormat.format(Calendar.getInstance().getTime());
        Button startDay = (Button) findViewById(R.id.buttonDayOfWeek);
        startDay.setText(day);

        //gets current day (out of 365)
        String currentMonthString = monthFormat.format(Calendar.getInstance().getTime());
        int currentMonthInt = Integer.valueOf(currentMonthString);
        String currentDayOfMonthString = dateFormat.format(Calendar.getInstance().getTime());
        int currentDayOfMonthInt = Integer.valueOf(currentDayOfMonthString);
        if(currentMonthInt==1){
            currentDayOfYear = currentDayOfMonthInt;
        }
        if(currentMonthInt==2){
            currentDayOfYear = 31+currentDayOfMonthInt;
        }
        if(currentMonthInt==3){
            currentDayOfYear = 60+currentDayOfMonthInt;
        }
        if(currentMonthInt==4){
            currentDayOfYear = 90+currentDayOfMonthInt;
        }
        if(currentMonthInt==5){
            currentDayOfYear = 121+currentDayOfMonthInt;
        }
        if(currentMonthInt==6){
            currentDayOfYear = 151+currentDayOfMonthInt;
        }
        if(currentMonthInt==7){
            currentDayOfYear = 182+currentDayOfMonthInt;
        }
        if(currentMonthInt==8){
            currentDayOfYear = 212+currentDayOfMonthInt;
        }
        if(currentMonthInt==9){
            currentDayOfYear = 243+currentDayOfMonthInt;
        }
        if(currentMonthInt==10){
            currentDayOfYear = 273+currentDayOfMonthInt;
        }
        if(currentMonthInt==11){
            currentDayOfYear = 304+currentDayOfMonthInt;
        }
        if(currentMonthInt==12){
            currentDayOfYear = 334+currentDayOfMonthInt;
        }

        //updates tree image
        if(lastDayScore >= 45){
            //grow two stages
        }
        if(lastDayScore >=30&&lastDayScore<45){
            //grow one stage
        }
        else{
            //doesn't grow any stages
        }



    }





    public void growTree(View V){
        //button at end of questions activity
        //extracts user input and calculates score. Then inputs it into database (lastDayScore)
        //if beginning of week, set startDate in database
        int todayScore = 0;
        int inputSteps = 5000;
        int inputCupsOfWater = 10;
        int inputMealsEaten = 2;
        int inputCaloriesConsumed = 2500;
        int inputHoursOfSleep = 6;

        //extract values from plain text boxes and assign to variables above

        if(inputSteps>=stepsGoal&&inputSteps<stepsGoal*1.5){
            todayScore += 5;
        }
        if(inputSteps>stepsGoal*1.5){
            todayScore += 10;
        }
        if(inputCupsOfWater>=cupsOfWaterGoal&&inputCupsOfWater<cupsOfWaterGoal*1.5){
            todayScore += 5;
        }
        if(inputCupsOfWater>cupsOfWaterGoal*1.5){
            todayScore += 10;
        }
        if(inputMealsEaten>=numberOfMealsGoal&&inputMealsEaten<numberOfMealsGoal*1.5){
            todayScore += 5;
        }
        if(inputMealsEaten>numberOfMealsGoal*1.5){
            todayScore += 10;
        }
        if(inputCaloriesConsumed>=caloriesConsumedGoal&&inputSteps<caloriesConsumedGoal*1.5){
            todayScore += 5;
        }
        if(inputCaloriesConsumed>caloriesConsumedGoal*1.5){
            todayScore += 10;
        }
        if(inputHoursOfSleep>=hoursOfSleepGoal&&inputHoursOfSleep<hoursOfSleepGoal*1.5){
            todayScore += 5;
        }
        if(inputHoursOfSleep>hoursOfSleepGoal*1.5){
            todayScore += 10;
        }

        if(!weekInProgress){
            //updates lastDayScore
            //lastDayScore = todayScore
            //sets startDate
        }
        else{
            //updates lastDayScore
            //lastDayScore = todayScore
            this.addScore(0);

        }

        //updates database with lastDayScore

    }

    public void goToQuestions(View v){
        //sends user to questions activity
        //sets button to either "Grow Tree' or "Plant Tree"
        Button submit = (Button) findViewById(R.id.buttonSubmit);
        if(startDate==currentDayOfYear){
            submit.setText("Plant Tree");
        }
        else{
            submit.setText("Grow Tree");
        }

    }

}
