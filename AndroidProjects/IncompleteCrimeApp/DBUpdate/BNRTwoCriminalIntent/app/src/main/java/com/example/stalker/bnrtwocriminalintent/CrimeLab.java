package com.example.stalker.bnrtwocriminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.stalker.bnrtwocriminalintent.database.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by staLker on 26-02-2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    protected static CrimeLab get(Context context){//returns the object.
        /*---------------->Remember we have to learn more about this context in Chapter 14<--------------*/
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
            return sCrimeLab;
        }
            return sCrimeLab;
    }


    private CrimeLab(Context context) {
        //private constructor for singleton class
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(context).getWritableDatabase();
        mCrimes = new ArrayList<>();
//        for(int i=0;i<100;i++){
//            Crime crime = new Crime();
//            crime.setTitle("Crime #"+i);
//            crime.setSolved(i%2==0);//alternate cases are solved;
//            mCrimes.add(crime);
//        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }
}
