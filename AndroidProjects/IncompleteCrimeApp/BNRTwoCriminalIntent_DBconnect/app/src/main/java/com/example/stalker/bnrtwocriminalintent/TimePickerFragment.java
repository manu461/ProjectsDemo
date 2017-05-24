package com.example.stalker.bnrtwocriminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

/**
 * Created by staLker on 22-04-2017.
 */

public class TimePickerFragment extends DialogFragment {
    private static final String ARGS_MINUTES = "arg_minutes";
    private static final String ARG_HOUR = "arg_hour";
    public static final String EXTRA_HRS = "android.widget.TimePicker.hours";
    public static final String EXTRA_MIN = "android.widget.TimePicker.minutes";
    private TimePicker mTimePicker;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final int hours = getArguments().getInt(ARG_HOUR);
        int minutes = getArguments().getInt(ARGS_MINUTES);
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time,null);
        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_picker);
        mTimePicker.setHour(hours);
        mTimePicker.setMinute(minutes);
        mTimePicker.setIs24HourView(false);
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.time_picker_title)
                .setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int hours = mTimePicker.getHour();
                        int minutes = mTimePicker.getMinute();
                        sendResult(Activity.RESULT_OK,hours,minutes);
                    }
                })
                .create();
    }
//
    public static TimePickerFragment newInstance(int hours, int minutes) {
        Bundle args = new Bundle();
        args.putInt(ARG_HOUR,hours);
        args.putInt(ARGS_MINUTES,minutes);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private void sendResult(int resultCode , int hour, int minutes){
        if(getTargetFragment() == null){
            return;
        }
            Intent i = new Intent();
            i.putExtra(EXTRA_HRS,hour);
            i.putExtra(EXTRA_MIN,minutes);
            getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,i);

    }
}
