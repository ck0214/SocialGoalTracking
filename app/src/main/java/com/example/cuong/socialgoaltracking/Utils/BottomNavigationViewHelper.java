package com.example.cuong.socialgoaltracking.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.cuong.socialgoaltracking.Friends.FriendsActivity;
import com.example.cuong.socialgoaltracking.Home.HomeActivity;
import com.example.cuong.socialgoaltracking.R;
import com.example.cuong.socialgoaltracking.Setting.SettingActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Cuong on 2/3/2018.
 */

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHelp";

    @SuppressLint("LongLogTag")
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up Nav help");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_home:
                        Intent intent1 = new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_friends:
                        Intent intent2 = new Intent(context, FriendsActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_setting:
                        Intent intent3 = new Intent(context, SettingActivity.class);
                        context.startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }
}
