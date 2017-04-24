package com.example.stalker.bnrtwocriminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.util.Date;
import java.util.UUID;

/**
 * Created by staLker on 22-02-2017.
 */

public class CrimeFragment extends Fragment {
    private static final int REQUEST_DATE = 1011;
    private static final int REQUEST_TIME = 2022;
    private static final String DIALOG_TIME = "DialogTime";
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private Button mTimeButton;
    private static final String ARGS_KEY_CRIME_FRAGMENT = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";

    public static CrimeFragment newInstance(UUID crimeID) {

        Bundle args = new Bundle();
        args.putSerializable(ARGS_KEY_CRIME_FRAGMENT,crimeID);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARGS_KEY_CRIME_FRAGMENT);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime,container,false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title_editText);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //not in use for now....
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //not in use for now....
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date_button);
        mDateButton.setText(mCrime.getFormattedDate());
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(mCrime.getDate());
                datePickerFragment.setTargetFragment(CrimeFragment.this,REQUEST_DATE);
                datePickerFragment.show(fragmentManager,DIALOG_DATE);
            }
        });

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.solved_checkbox);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mTimeButton = (Button) v.findViewById(R.id.crime_time_button);
        mTimeButton.setText(mCrime.getFormattedTime());
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                TimePickerFragment timePickerFragment  = TimePickerFragment.newInstance(mCrime.getHours(),mCrime.getMinutes());
                timePickerFragment.setTargetFragment(CrimeFragment.this,REQUEST_TIME);
                timePickerFragment.show(fragmentManager,DIALOG_TIME);
            }
        });
        //mDateButton.setEnabled(false);
        return v;
    }
    ////git check comment

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCrime.setDate(date);
            mDateButton.setText(mCrime.getFormattedDate());
        }
        else if(requestCode == REQUEST_TIME){
            int hours = data.getExtras().getInt(TimePickerFragment.EXTRA_HRS);
            int minutes = data.getExtras().getInt(TimePickerFragment.EXTRA_MIN);
            mCrime.setHours(hours);
            mCrime.setMinutes(minutes);
            mTimeButton.setText(mCrime.getFormattedTime());

        }
    }
}
