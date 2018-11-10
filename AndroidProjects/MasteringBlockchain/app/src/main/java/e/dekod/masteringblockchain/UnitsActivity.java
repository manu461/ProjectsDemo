package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Unit;
import e.dekod.masteringblockchain.Beans.User;

public class UnitsActivity extends AppCompatActivity {

    private static final String KEY = "e.dekod.masteringblockchain.UnitsActivity";

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView unitRecyclerView;
    private ArcProgress arcProgressUnit;

    private Chapter chapter;
    ArrayList<Unit> allUnitsList;
    ArrayList<Boolean> allTopicStatusList;
    private WebView mWebView;

    private ArrayList<Integer> completed;
    private ArrayList<Integer> total;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        mWebView = findViewById(R.id.webview_actionBar);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/particle_js/demo/index.html");



        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_unit_activity);
        unitRecyclerView = findViewById(R.id.unit_list_recycler_view);
        arcProgressUnit = findViewById(R.id.arc_progress);


        unitRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        chapter = (Chapter) getIntent().getSerializableExtra(KEY);
        allTopicStatusList = (ArrayList<Boolean>) getIntent().getSerializableExtra("key");

        allUnitsList = (ArrayList<Unit>) chapter.getUnitsOfChapter();

        collapsingToolbarLayout.setTitle(chapter.getChapterTitle());
        method();
        int sumTotal = 0;
        int sumCompleted = 0;
        for(int i =0; i<total.size();i++){
            sumCompleted += completed.get(i);
            sumTotal += total.get(i);
        }
        arcProgressUnit.setProgress(sumCompleted*100/sumTotal);
        unitRecyclerView.setAdapter(new UnitListRecyclerViewAdapter(allTopicStatusList,completed,total,allUnitsList,this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth mAuth;
        DatabaseReference databaseUser;
        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid()).child("topicsStatus");
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allTopicStatusList = new ArrayList<>();
                allTopicStatusList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot statusSnapshot : var){
                    Boolean status = statusSnapshot.getValue(Boolean.class);
                    allTopicStatusList.add(status);
                }

                method();
                int sumTotal = 0;
                int sumCompleted = 0;
                for(int i =0; i<total.size();i++){
                    sumCompleted += completed.get(i);
                    sumTotal += total.get(i);
                }
                arcProgressUnit.setProgress(sumCompleted*100/sumTotal);
                unitRecyclerView.setAdapter(new UnitListRecyclerViewAdapter(allTopicStatusList,completed,total,allUnitsList,UnitsActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void method() {
        completed = new ArrayList<>();
        total = new ArrayList<>();
        for(int i=0;i<allUnitsList.size();i++){
            int totalTopicsOfUnit = 0;
            int completedTopicsOfUnit = 0;
            for(int j=0;j<allUnitsList.get(i).getTopicsOfUnit().size();j++){
                if(allTopicStatusList.get(allUnitsList.get(i).getTopicsOfUnit().get(j).getTopicSerialId())){
                    completedTopicsOfUnit++;
                }
                totalTopicsOfUnit++;
            }
            completed.add(completedTopicsOfUnit);
            total.add(totalTopicsOfUnit);
        }
    }

    public static Intent getIntent(Context context, Chapter chapter, ArrayList<Boolean> allTopicStatusList){
        Intent intent = new Intent(context,UnitsActivity.class);
        intent.putExtra(KEY, chapter);
        intent.putExtra("key",allTopicStatusList);
        return intent;
    }
}
