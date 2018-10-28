package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;

public class TopicsActivity extends FragmentActivity {

    private static final String KEY = "e.dekod.masteringblockchain.TopicsActivity";
    private Unit unit;
    private ViewPager topicViewPager;
    private TextView unitTitleTextView;
    private ArrayList<Topic> allTopicsList;
    private StepView stepView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        unit = (Unit) getIntent().getSerializableExtra(KEY);

        allTopicsList = (ArrayList<Topic>) unit.getTopicsOfUnit();

        topicViewPager = findViewById(R.id.topic_viewPager);
        stepView = findViewById(R.id.step_view);
        unitTitleTextView = findViewById(R.id.topics_unit_title_textView);

        FragmentManager fragmentManager = getSupportFragmentManager();
        topicViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return TopicFragment.getInstance(allTopicsList.get(position));
            }

            @Override
            public int getCount() {
                return allTopicsList.size();
            }

        });
        topicViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                unitTitleTextView.setText(Html.fromHtml("<b>hello</b>"));
                stepView.go(position,true);
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

    public static Intent getIntent(Context context, Unit unit){
        Intent intent = new Intent(context,TopicsActivity.class);
        intent.putExtra(KEY, unit);
        return intent;
    }
}
