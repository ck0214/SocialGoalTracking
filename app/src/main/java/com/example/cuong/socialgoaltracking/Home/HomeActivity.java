package com.example.cuong.socialgoaltracking.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.socialgoaltracking.R;
import com.example.cuong.socialgoaltracking.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private ImageButton addGoalImageButton;
    private ImageButton rightNavImageButton;
    private DrawerLayout mDrawerLayout;
    private List<Goal> goalList = new ArrayList<Goal>();
    boolean clicked = false;
    private static int count = 0;
    private ArrayList<Goal> test;
    ArrayList<String> a = new ArrayList();
    ArrayList<String> cateA = new ArrayList<>();
   ListView lv;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: Home Activity");
        addGoalImageButton = (ImageButton) findViewById(R.id.addGoalImageButton);
        rightNavImageButton = (ImageButton) findViewById(R.id.rightNavigationMenuImageButton);

        test =  new ArrayList<Goal>();
        customAdapter = new CustomAdapter(getApplicationContext(), test);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(customAdapter);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        addGoalImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(HomeActivity.this, "Worked", Toast.LENGTH_LONG).show();
                clicked = true;
                count++;
                lv.setAdapter(customAdapter);

                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });


        rightNavImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Worked", Toast.LENGTH_LONG).show();
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        Intent intent = getIntent();
        String cateText = intent.getStringExtra(GoalActivity.EXTRA_CATENAME);
        String goalText = intent.getStringExtra(GoalActivity.EXTRA_GOALNAME);
        String descriptionText = intent.getStringExtra(GoalActivity.EXTRA_DESCRIPTIONNAME);
        String days = intent.getStringExtra(GoalActivity.EXTRA_DAYS);

//        int daysLeft = Integer.parseInt(days);

        Goal md = new Goal(cateText, goalText, days, descriptionText, "12", "23");
        test.add(md);
        customAdapter.notifyDataSetChanged();
        /*
for(int i = 0; i < 10; i++) {
    cateA.add(i, cateText);
}
        for(int i = 0; i < count; i++) {
            a.add(String.valueOf(goalList.add(new Goal(cateText, goalText, days, descriptionText, "12", "23"))));
        }
  //  Goal list = new Goal(this, cateText, goalText, days, descriptionText, "12", "23");
        String out = "";
        for (int i = 0; i< cateA.size(); i++){
            out = out + cateA.get(i);
        }

        System.out.println("Khong the tin duoc: " + out);
        //goalList.add(new Goal(cateText,goalText,days, descriptionText, "12", "23", "abc", false));

*/
        setupBottomNavigationView();
  //     polulateListView();



    }

    @SuppressLint("NewApi")
    public void addValue(View v){
        Intent intent = getIntent();
        String cateText = intent.getStringExtra(GoalActivity.EXTRA_CATENAME);
        String goalText = intent.getStringExtra(GoalActivity.EXTRA_GOALNAME);
        String descriptionText = intent.getStringExtra(GoalActivity.EXTRA_DESCRIPTIONNAME);
        String days = intent.getStringExtra(GoalActivity.EXTRA_DAYS);

        Goal md = new Goal(cateText, goalText, days, descriptionText, "12", "23");
        test.add(md);
        customAdapter.notifyDataSetChanged();
    }
    
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(HomeActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
/*
    private void polulateListView(){
        ArrayAdapter<Goal> arrayAdapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(arrayAdapter);


    }

    private class MyListAdapter extends ArrayAdapter<Goal>{
        public MyListAdapter(){
            super(HomeActivity.this, R.layout.item_view, goalList);

        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);

            }

            Goal currentGoal = goalList.get(position);
            //ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            //imageView.setImageResource(currentGoal.getIconID());

            TextView goalText = (TextView) itemView.findViewById(R.id.goalNameTextView);
            goalText.setText(currentGoal.getGoalName());


            TextView cateText = (TextView) itemView.findViewById(R.id.cateNameTextView);
            cateText.setText(currentGoal.getCategoryName());

            TextView daysLeft = (TextView) itemView.findViewById(R.id.daysTextView);
            daysLeft.setText((currentGoal.getDaysLeft()));

            return itemView;
        }
    }*/



}
