package com.example.cuong.socialgoaltracking.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.socialgoaltracking.R;

/**
 * Created by Cuong on 2/3/2018.
 */

public class CategoryActivity extends AppCompatActivity{
    private static final String TAG = "CategoryActivity";
    private TextView nextButtonTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        nextButtonTextView =(TextView) findViewById(R.id.nextButtonTextView);

        nextButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CategoryActivity.this, "Worked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
