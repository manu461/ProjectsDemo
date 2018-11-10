package e.dekod.masteringblockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Topic;

public class TestPagerAdapter extends PagerAdapter {

    Context context;
    private ArrayList<Topic> allTopicsList;
    private ArrayList<Boolean> allTopicStatusList;

    public TestPagerAdapter(Context context, ArrayList<Topic> allTopicsList, ArrayList<Boolean> allTopicStatusList) {
        this.context = context;
        this.allTopicsList = allTopicsList;
        this.allTopicStatusList = allTopicStatusList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) layoutInflater.inflate(R.layout.fragment_topic, container, false);
        TextView topicSerialTextView = layout.findViewById(R.id.topicSerial_textView);
        CheckBox topicIsCompleteCheckbox = layout.findViewById(R.id.topic_isComplete_checkBox);

        topicSerialTextView.setText(allTopicsList.get(position).getTopicSerialId()+"");
        topicIsCompleteCheckbox.setChecked(allTopicStatusList.get(allTopicsList.get(position).getTopicSerialId()));

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return allTopicsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}
