package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;
import e.dekod.masteringblockchain.Beans.User;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String KEY = "e.dekod.masteringblockchain.HomeActivity";
    FirebaseAuth mAuth;
    private ProgressBar progressBarChapterList;
    private RecyclerView chapterRecyclerView;
    private ArrayList<Chapter> allChapterList;
    private User user;
    private int topicCount;
    private Object var;
    private DatabaseReference databaseRoot;

    private DatabaseReference databaseChapters;
    private DatabaseReference databaseUser;
    private DatabaseReference databaseTopicCount;
    private boolean topicStatusExists = false;


    @Override
    protected void onStart() {
        super.onStart();
        databaseChapters.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allChapterList = new ArrayList<Chapter>();
                allChapterList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot chapterSnapshot : var){
                    Chapter chapter = chapterSnapshot.getValue(Chapter.class);
                    allChapterList.add(chapter);

                }

                chapterRecyclerView.setAdapter(new ChapterListRecyclerViewAdapter(allChapterList));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseTopicCount.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                topicCount = dataSnapshot.getValue(Integer.class);
                Log.d("manu","topicCount: "+topicCount+" :");
                if(!topicStatusExists){
                    ArrayList<Boolean> topicsStatus = new ArrayList<>();
                    for(int i=1 ; i<=topicCount ; i++){
                        databaseUser.child(mAuth.getCurrentUser().getUid()+"").child("topicsStatus").child(i+"").setValue("false")
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(HomeActivity.this, aVoid+"", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(HomeActivity.this, e+"", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Log.d("manu","topicStatus"+databaseUser.child(mAuth.getCurrentUser().getUid()).child("topicsStatus")+"");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBarChapterList = findViewById(R.id.progressBar_chapterList);
        chapterRecyclerView = (RecyclerView) findViewById(R.id.chapter_list_recycler_view);
        chapterRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseRoot = FirebaseDatabase.getInstance().getReference();
        databaseTopicCount = databaseRoot.child("topicCount");
        databaseChapters = databaseRoot.child("chapters");
        databaseUser = databaseRoot.child("users");

        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("topicsStatus")){
                    topicStatusExists = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






        /*/************demo data*****************
        Topic topic1 = new Topic(1,null,null,"",null,null,null);
        Topic topic2 = new Topic(2,null,null,null,null,null,null);
        Topic topic3 = new Topic(3,null,null,null,null,null,null);
        Topic topic4 = new Topic(4,null,null,null,null,null,null);
        Topic topic5 = new Topic(5,null,null,null,null,null,null);
        Topic topic6 = new Topic(6,null,null,null,null,null,null);

        List<Topic> allTopicsUnit1 = new ArrayList<Topic>();
        allTopicsUnit1.add(topic1);
        allTopicsUnit1.add(topic2);


        List<Topic> allTopicsUnit2 = new ArrayList<Topic>();
        allTopicsUnit2.add(topic4);
        allTopicsUnit2.add(topic5);


        Unit unit1 = new Unit(1,null,allTopicsUnit1);
        Unit unit2 = new Unit(2,null,allTopicsUnit2);

        List<Unit> allUnitsOfChapter = new ArrayList<Unit>();
        allUnitsOfChapter.add(unit1);
        allUnitsOfChapter.add(unit2);



        Chapter chapter1 = new Chapter(1,null,null,null,allUnitsOfChapter);
        Chapter chapter2 = new Chapter(2,null,null,null,allUnitsOfChapter);
        Chapter chapter3 = new Chapter(3,null,null,null,allUnitsOfChapter);

        allChapterList = new ArrayList<>();

        allChapterList.add(chapter1);
        allChapterList.add(chapter2);

        ChaptersClass chaptersClass = new ChaptersClass(allChapterList);

        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = null;
        try {
            json = mapper.writeValueAsString(chaptersClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Log.d("manu",json);
        System.out.println(json);
        //************demo data*****************/


        //chapterRecyclerView.setAdapter(new ChapterListRecyclerViewAdapter(allChapterList));

        mAuth = FirebaseAuth.getInstance();
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        TextView textView = (TextView)findViewById(R.id.textview_email);
        textView.setText(mAuth.getCurrentUser().getEmail());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rate) {
            // Handle the camera action
        } else if (id == R.id.nav_email) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_password_reset) {


        } else if (id == R.id.nav_logout) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,HomeActivity.class);
        return intent;
    }
}
