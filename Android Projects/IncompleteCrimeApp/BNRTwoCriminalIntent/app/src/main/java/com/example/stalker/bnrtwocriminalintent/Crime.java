package com.example.stalker.bnrtwocriminalintent;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Calendar;

/**
 * Created by staLker on 21-02-2017.
 */

public class Crime {
    private String mTitle;
    private UUID mId;
    private Date mDate;
    private boolean mSolved;
    private int hours;
    private int minutes;

    public String getFormattedTime(){
        int hours = this.getHours();
        String am_pm = hours>=12 ? "P.M." : "A.M.";
        int hoursTemp;
        if(hours == 0){
            hoursTemp = 12;
        }
        else if(hours > 13){
            hoursTemp = hours%12;
        }
        else {
            hoursTemp = hours;
        }

        return hoursTemp+":"+this.getMinutes()+" "+am_pm;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        setHours(calendar.get(Calendar.HOUR));
        setMinutes(calendar.get(Calendar.MINUTE));
    }


    public String getFormattedDate(){
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mDate);
        return formattedDate;

    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
