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
import android.widget.ImageView;
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
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.CryptoCurrency;
import e.dekod.masteringblockchain.Beans.Luggage;
import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;
import e.dekod.masteringblockchain.Beans.User;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String KEY = "e.dekod.masteringblockchain.HomeActivity";

    //private RecyclerView chapterRecyclerView;
    private SliderLayout sliderLayout;
    //private RecyclerView cryptoRecyclerView;
    private RecyclerView masterRecyclerView;
    private Luggage luggage;
    private ArrayList<Chapter> allChapterList;
    private ArrayList<CryptoCurrency> allCryptoList;
    private User user;
    private int topicCount;
    private ArrayList<String> homePageImages;
    private boolean sliderViewIsSetOnce = false;


    @Override
    protected void onStart() {
        super.onStart();

        allChapterList = luggage.getAllChapterList();
        allCryptoList = luggage.getAllCryptoList();
        user = luggage.getUser();
        Log.d("debug","Home : "+user.toString());
        topicCount = luggage.getTopicCount();
        homePageImages = luggage.getHomePageImages();

        if(!sliderViewIsSetOnce) {
            setSliderViews();
        }

        //chapterRecyclerView.setAdapter(new ChapterListRecyclerViewAdapter(allChapterList));
        //cryptoRecyclerView.setAdapter(new CryptoListRecyclerViewAdapter(allCryptoList));
        masterRecyclerView.setAdapter(new HomeRecyclerViewMasterAdapter(this,allChapterList,allCryptoList));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //progressBarChapterList = findViewById(R.id.progressBar_chapterList);
        //chapterRecyclerView = (RecyclerView) findViewById(R.id.chapter_list_recycler_view);
        //cryptoRecyclerView = findViewById(R.id.crypto_list_recycler_view);
        masterRecyclerView = findViewById(R.id.master_recycler_view);

        sliderLayout = findViewById(R.id.imageSlider);

        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL);
        sliderLayout.setScrollTimeInSec(1);


        //chapterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //cryptoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        masterRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        luggage = (Luggage) getIntent().getSerializableExtra(KEY);

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
        ImageView userImageView = findViewById(R.id.userImage_nav_bar_imageView);
        TextView nameTextView = findViewById(R.id.userName_nav_bar_textView);
        TextView emailTextView = (TextView)findViewById(R.id.userEmail_nav_bar_textView);

        Picasso.get().load(user.getUserImage()).into(userImageView);
        nameTextView.setText(user.getUserName());
        emailTextView.setText(user.getUserEmail());
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
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(HomeActivity.this, SplashScreen.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setSliderViews() {
        for(int i=0;i<homePageImages.size();i++){
            SliderView sliderView = new SliderView(this);
            sliderView.setImageUrl(homePageImages.get(i));
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
            sliderViewIsSetOnce = true;
        }
    }

    public static Intent getIntent(Context context, Luggage luggage){
        Intent intent = new Intent(context,HomeActivity.class);
        intent.putExtra(KEY, luggage);
        return intent;
    }
}
