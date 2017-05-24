package com.example.stalker.bnrtwocriminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;


public class CrimeActivityUnused extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID = "com.example.stalker.bnrtwocriminalintent.crime_id";
    protected static Intent newIntent(Context context, UUID crimeId){
        Intent i = new Intent(context,CrimeActivityUnused.class);
        i.putExtra(EXTRA_CRIME_ID,crimeId);
        return i;

    }


    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
