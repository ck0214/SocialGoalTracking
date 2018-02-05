package com.example.cuong.socialgoaltracking.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.socialgoaltracking.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuong on 2/3/2018.
 */

public class CategoryActivity extends AppCompatActivity{
    private static final String TAG = "CategoryActivity";
    private TextView nextButtonTextView;
    private EditText cateEditText;
    private List<Goal> goalList = new ArrayList<Goal>();
    public static final String EXTRA_CATENAME = "com.example.application.example.EXTRA_CATENAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        nextButtonTextView =(TextView) findViewById(R.id.nextButtonTextView);

        cateEditText = (EditText) findViewById(R.id.cateEditText);
        nextButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CategoryActivity.this, "Worked", Toast.LENGTH_LONG).show();

                String cateName = cateEditText.getText().toString();

                Intent intent = new Intent(CategoryActivity.this, GoalActivity.class);
                intent.putExtra(EXTRA_CATENAME, cateName);
                startActivity(intent);
            }
        });


    }

}
