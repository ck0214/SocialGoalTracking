package com.example.cuong.socialgoaltracking.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cuong.socialgoaltracking.R;

import java.util.ArrayList;

/**
 * Created by Cuong on 2/4/2018.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Goal> itemGoalList;
    public CustomAdapter(Context applicationContext, ArrayList<Goal> test) {
        this.context = applicationContext;
        this.itemGoalList = test;
    }

    @Override
    public int getCount() {
        return itemGoalList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemGoalList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = null;
        if(convertView == null){
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(CategoryActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_view, null);
            TextView tv1 = (TextView) convertView.findViewById(R.id.cateNameTextView);
            TextView tv2 = (TextView) convertView.findViewById(R.id.goalNameTextView);
            TextView tv3 = (TextView) convertView.findViewById(R.id.daysTextView);
            Goal m = itemGoalList.get(position);
            tv1.setText(m.getCategoryName());
            tv2.setText(m.getGoalName());
            tv3.setText(m.getDaysLeft());
        }
        return convertView;
    }
}
