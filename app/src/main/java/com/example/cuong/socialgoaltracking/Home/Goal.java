package com.example.cuong.socialgoaltracking.Home;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cuong.socialgoaltracking.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuong on 2/3/2018.
 */

public class Goal{
    private String categoryName;
    private String goalName;
    private String description;
    private String startDate;
    private String endDate;
    private String daysLeft;
    private List<Goal> checkPoints;
    private boolean isReminded;

    public Goal(String categoryName, String goalName, String daysLeft, String description, String startDate, String endDate){
        super();
        this.categoryName = categoryName;
        this.goalName = goalName;
        this.daysLeft = daysLeft;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkPoints = new ArrayList<Goal>();
        this.isReminded = isReminded;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Goal> getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(List<Goal> checkPoints) {
        this.checkPoints = checkPoints;
    }

    public boolean isReminded() {
        return isReminded;
    }

    public void setReminded(boolean reminded) {
        isReminded = reminded;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }

/*
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.item_view, null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) r.getTag();
        }

            viewHolder.tv1.setText(categoryName[position]);
        viewHolder.tv2.setText(goalName[position]);
        viewHolder.tv3.setText(daysLeft[position]);


        return r;


    }

    class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ViewHolder(View v){
            tv1 = v.findViewById(R.id.cateNameTextView);
            tv2 = v.findViewById(R.id.goalNameTextView);
            tv3 = v.findViewById(R.id.daysTextView);
        }

    }*/
}
