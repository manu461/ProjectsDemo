package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;

public class TopicsActivity extends AppCompatActivity {

    private static final String KEY = "e.dekod.masteringblockchain.TopicsActivity";
    private Unit unit;
    private ArrayList<Topic> allTopicsList;
    private StepView stepView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        unit = (Unit) getIntent().getSerializableExtra(KEY);

        allTopicsList = (ArrayList<Topic>) unit.getTopicsOfUnit();

        stepView = findViewById(R.id.step_view);
        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.colorAccent))

                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.colorPrimary))
                // You should specify only stepsNumber or steps array of strings.
                // In case you specify both steps array is chosen.
                .steps(new ArrayList<String>() {{
                    add("First step");
                    add("Second step");
                    add("Third step");
                }})
                // You should specify only steps number or steps array of strings.
                // In case you specify both steps array is chosen.
                .stepsNumber(4)
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
