package com.example.stalker.bnrtwocriminalintent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

/**
 * Created by staLker on 26-02-2017.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CrimeAdapter mCrimeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent intent = CrimePagerActivity.newIntent(getActivity(),crime.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list,menu);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);//wiring up the recyclerView.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//Layout manager handles the positioning of items and also defines the scrolling behaviour.
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());//object created in order to access other methods of CrimeLab in CrimeListFragment class.
        List<Crime> crimes = crimeLab.getCrimes();//Complete List<crime> is retrieved using crimeLab object using getCrimes() method of CrimeLab class.
        if (mCrimeAdapter == null) {
            mCrimeAdapter = new CrimeAdapter(crimes);//User-defined constructor of CrimeAdapter is called in order to create an instance of CrimeAdapter and to make List<crime> available to CrimeAdapter.
            mRecyclerView.setAdapter(mCrimeAdapter);//the above created instance of CrimeAdapter is set as the Adapter of our RecyclerView.
        }
        else{
            mCrimeAdapter.notifyDataSetChanged();
        }

    }




///////////////////////////////////////////////////////////////////////////////////////VIEW_HOLDER////////////////////////////////////////////////////////////////////////////////////////
    private class CrimeHolder extends RecyclerView.ViewHolder{
        private TextView mTitleTextView;//Declaring all widgets of the view of the list.
        private TextView mCrimeDateTextView;//     "
        private CheckBox mSolvedCheckBox;//        "
        private Crime mCrime;

        public CrimeHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_textView);//wiring-up all widgets of the view of the list.
            mCrimeDateTextView = (TextView) itemView.findViewById(R.id.list_item_date_textView);//         "
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_solved_checkBox);//          "
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = CrimePagerActivity.newIntent(getActivity(),mCrime.getId());
                    startActivity(i);
                }
            });
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





////////////////////////////////////////////////////////////////////////////////////////ADAPTER//////////////////////////////////////////////////////////////////////////////////////////////////
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;//an instance of List<crime> is created in order to use it in getItemCount() to get total size.

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;//instantiated when new instance of adapter is created, fragment will create the adapter in its onCreateView().
        }
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {//onCreateViewHolder creates a View and wrap it up with a ViewHolder and returns it to recycler view.
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());//creating view(step1)
            View view  = layoutInflater.inflate(R.layout.list_item_crime,parent,false);//creating view(step2)

            return new CrimeHolder(view);//wrapping the created view with a viewHolder and returning the final result to recycler view.
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {//it Binds the element at index 'position' of List<crime> to the viewHolder of that position in recyclerView.
            Crime crime = mCrimes.get(position);//element at index 'position' is retrieved from List<crime>.
            holder.mTitleTextView.setText(crime.getTitle());
            holder.mSolvedCheckBox.setChecked(crime.isSolved());
            holder.mCrimeDateTextView.setText(crime.getFormattedDate());
            holder.mCrime = crime;//passing the crime object to ViewHolder
        }
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
