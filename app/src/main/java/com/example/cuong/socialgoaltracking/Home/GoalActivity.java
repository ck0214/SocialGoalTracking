package com.example.cuong.socialgoaltracking.Home;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.socialgoaltracking.R;
import com.kd.dynamic.calendar.generator.ImageGenerator;

import java.util.Calendar;

/**
 * Created by Cuong on 2/3/2018.
 */

public class GoalActivity extends AppCompatActivity {
    public static final String TAG = "GoalActivity";
    public static final String EXTRA_CATENAME = "com.example.application.example.EXTRA_CATENAME";
    public static final String EXTRA_GOALNAME = "com.example.application.example.EXTRA_GOALNAME";
    public static final String EXTRA_DESCRIPTIONNAME = "com.example.application.example.EXTRA_DESCRIPTIONNAME";
    public static final String EXTRA_DAYS = "com.example.application.example.EXTRA_DAYS";

    private TextView nextButtonTextView;
    private EditText goalNameEditText;
    private EditText descriptionEditText;
    EditText mStartDateEditText;
    Calendar mStartCurrentDate;
    ImageGenerator mStartImageGenerator;
    EditText mDateEditText;
    Calendar mCurrentDate;
    ImageGenerator mImageGenerator;
    public static int startDay;
    public static int startMonth;
    public static int startYear;
    public static int endDay;
    public static int endMonth;
    public static int endYear;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        nextButtonTextView = (TextView) findViewById(R.id.nextButtonTextView);
        goalNameEditText = (EditText) findViewById(R.id.goalNameTextView);
        descriptionEditText =(EditText) findViewById(R.id.descriptionTextView);



        startDayGenerator();
        endDateGenerator();


        Intent intent = getIntent();
        final String text = intent.getStringExtra(CategoryActivity.EXTRA_CATENAME);
        Toast.makeText(GoalActivity.this, text, Toast.LENGTH_LONG).show();

        nextButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar sCal = Calendar.getInstance();
                sCal.set(Calendar.DATE, startDay);
                sCal.set(Calendar.MONTH, startMonth);
                sCal.set(Calendar.YEAR, startYear);

                Calendar eCal = Calendar.getInstance();
                eCal.set(Calendar.DATE, endDay);
                eCal.set(Calendar.MONTH, endMonth);
                eCal.set(Calendar.YEAR, endYear);

                long difference = eCal.getTimeInMillis() - sCal.getTimeInMillis();
                int days = (int) (difference/ (1000*60*60*24));
                String abc = Integer.toString(days);
                Toast.makeText(GoalActivity.this, abc, Toast.LENGTH_LONG).show();

                String cateName = text;
                String goalName = goalNameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Intent intent = new Intent(GoalActivity.this, HomeActivity.class);
                intent.putExtra(EXTRA_CATENAME, cateName);
                intent.putExtra(EXTRA_GOALNAME, goalName);
                intent.putExtra(EXTRA_DESCRIPTIONNAME, description);
                intent.putExtra(EXTRA_DAYS, abc);
                startActivity(intent);
            }
        });
    }

    public void startDayGenerator(){
        mStartImageGenerator = new ImageGenerator(this);
        mStartDateEditText = (EditText)findViewById(R.id.startDateTextView);
        //  mDisplayGeneratedImage = (ImageView)findViewById(R.id.imageGen);

        mStartImageGenerator.setIconSize(50, 50);
        mStartImageGenerator.setDateSize(30);
        mStartImageGenerator.setMonthSize(10);

        mStartImageGenerator.setDatePosition(42);
        mStartImageGenerator.setMonthPosition(14);

        mStartImageGenerator.setDateColor(Color.parseColor("#3c6eaf"));
        mStartImageGenerator.setMonthColor(Color.WHITE);

        mStartImageGenerator.setStorageToSDCard(true);

        mStartDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartCurrentDate = Calendar.getInstance();
                int year = mStartCurrentDate.get(Calendar.YEAR);
                int month = mStartCurrentDate.get(Calendar.MONTH);
                int date = mStartCurrentDate.get(Calendar.DATE);

                final DatePickerDialog mDatePicker = new DatePickerDialog(GoalActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        mStartDateEditText.setText(selectedDay + "/" +selectedMonth + "/" + selectedYear);

                        mStartCurrentDate.set(selectedDay,selectedMonth,selectedYear);

                      //  String startDate = mStartDateEditText.getText().toString();


                        startDay = selectedDay;
                        startMonth = selectedMonth;
                        startYear = selectedYear;




                     //Toast.makeText(GoalActivity.this, startDate, Toast.LENGTH_LONG).show();

                    }
                }, year, month, date);
                mDatePicker.show();
            }
        });

    }

    public void endDateGenerator(){
        mImageGenerator = new ImageGenerator(this);
        mDateEditText = (EditText)findViewById(R.id.endDateTextView);
        //  mDisplayGeneratedImage = (ImageView)findViewById(R.id.imageGen);

        mImageGenerator.setIconSize(50, 50);
        mImageGenerator.setDateSize(30);
        mImageGenerator.setMonthSize(10);

        mImageGenerator.setDatePosition(42);
        mImageGenerator.setMonthPosition(14);

        mImageGenerator.setDateColor(Color.parseColor("#FCFC21"));
        mImageGenerator.setMonthColor(Color.WHITE);

        mImageGenerator.setStorageToSDCard(true);

        mDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int date = mCurrentDate.get(Calendar.DATE);

                final DatePickerDialog mDatePicker = new DatePickerDialog(GoalActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        mDateEditText.setText(selectedDay + "/" +selectedMonth + "/" + selectedYear);

                        mCurrentDate.set(selectedDay,selectedMonth,selectedYear);

                        endDay = selectedDay;
                        endMonth = selectedMonth;
                        endYear = selectedYear;
                    }
                }, year, month, date);
                mDatePicker.show();
            }
        });


    }

}
