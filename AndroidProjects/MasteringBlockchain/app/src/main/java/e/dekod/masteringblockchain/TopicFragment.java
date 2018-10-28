package e.dekod.masteringblockchain;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

import e.dekod.masteringblockchain.Beans.Topic;

public class TopicFragment extends android.support.v4.app.Fragment {

    private static final String KEY = "e.dekod.masteringblockchain.TopicFragment";

    private Topic topic;
    private TextView topicSerialTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topic = (Topic) getArguments().getSerializable(KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic,container,false);
        topicSerialTextView = view.findViewById(R.id.topicSerial_textView);

        topicSerialTextView.setText(topic.getTopicSerialId()+"");

        return view;
    }

    public static TopicFragment getInstance(Topic topic) {
        Bundle args = new Bundle();
        args.putSerializable(KEY,topic);
        TopicFragment fragment = new TopicFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
