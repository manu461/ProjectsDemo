package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;
import e.dekod.masteringblockchain.Beans.User;

public class TopicsActivity extends FragmentActivity {

    private static final String KEY = "e.dekod.masteringblockchain.TopicsActivity";
    private Unit unit;
    private User user;
    private ViewPager topicViewPager;
    private TextView unitTitleTextView;
    private WebView webView;
    private ArrayList<Topic> allTopicsList;
    private ArrayList<Boolean> allTopicStatusList;
    private StepView stepView;

    private DatabaseReference currentUserReference;
    private DatabaseReference currentUserTopicStatusReference;
    private FirebaseAuth mAuth;

    private DatabaseReference databaseTopicStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        unit = (Unit) getIntent().getSerializableExtra(KEY);

        allTopicsList = (ArrayList<Topic>) unit.getTopicsOfUnit();



        topicViewPager = findViewById(R.id.topic_viewPager);
        stepView = findViewById(R.id.step_view);
        unitTitleTextView = findViewById(R.id.topics_unit_title_textView);
        webView = findViewById(R.id.webView_topic);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/particle_js/demo/index.html");

        allTopicStatusList = (ArrayList<Boolean>) getIntent().getSerializableExtra("key");

        mAuth = FirebaseAuth.getInstance();
        currentUserReference = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid());
        currentUserTopicStatusReference = currentUserReference.child("topicsStatus");


        FragmentManager fragmentManager = getSupportFragmentManager();
//        topicViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {.........
//            @Override
//            public Fragment getItem(int position) {
//                return TopicFragment.getInstance(allTopicsList.get(position),allTopicStatusList.get(position));
//            }
//
//            @Override
//            public int getCount() {
//                return allTopicsList.size();
//            }
//
//
//        });
        final TopicViewPagerAdapter topicViewPagerAdapter = new TopicViewPagerAdapter(fragmentManager, allTopicsList,allTopicStatusList);
        topicViewPager.setAdapter(topicViewPagerAdapter);
        topicViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                Log.d("position",position+"");
                unitTitleTextView.setText(Html.fromHtml("<b>hello</b>"));

                stepView.go(position,true);
                if(position>0){
                    int topicSerialId = allTopicsList.get(position).getTopicSerialId()-1;
                    currentUserTopicStatusReference.child(topicSerialId+"").setValue(true);
                    topicViewPagerAdapter.updateData(position-1);
                    ///now ask for update to topicViewPagerAdapter for position-1
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
                .selectedStepNumberColor(ContextCompat.getColor(this, android.R.color.white))
                // You should specify only stepsNumber or steps array of strings.
                // In case you specify both steps array is chosen.
//                .steps(new ArrayList<String>() {{
//                    add("First step");
//                    add("Second step");
//                    add("Third step");
//                }})
                // You should specify only steps number or steps array of strings.
                // In case you specify both steps array is chosen.
                .stepsNumber(allTopicsList.size())
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))


                // other state methods are equal to the corresponding xml attributes
                .commit();
    }

    public static Intent getIntent(Context context, Unit unit, ArrayList<Boolean> allTopicStatusList){
        Intent intent = new Intent(context,TopicsActivity.class);
        intent.putExtra(KEY, unit);
        intent.putExtra("key",allTopicStatusList);
        return intent;
    }
}
