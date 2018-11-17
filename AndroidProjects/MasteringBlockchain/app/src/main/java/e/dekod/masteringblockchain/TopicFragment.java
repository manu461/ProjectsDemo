package e.dekod.masteringblockchain;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

import e.dekod.masteringblockchain.Beans.Topic;

public class TopicFragment extends android.support.v4.app.Fragment {

    private static final String KEY = "e.dekod.masteringblockchain.TopicFragment";

    private Topic topic;
    private TextView topicSerialTextView;
    Boolean isTopicComplete = false;
    private CheckBox topicIsCompleteCheckbox;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topic = (Topic) getArguments().getSerializable(KEY);
        isTopicComplete = getArguments().getBoolean("key");
        Log.d("debug",isTopicComplete.toString());
        Log.d("frag","onCreate"+topic.getTopicSerialId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("frag","onCreateView"+topic.getTopicSerialId());
        View view = inflater.inflate(R.layout.fragment_topic,container,false);
        topicSerialTextView = view.findViewById(R.id.topicSerial_textView);
        topicIsCompleteCheckbox = view.findViewById(R.id.topic_isComplete_checkBox);

        topicSerialTextView.setText(topic.getTopicSerialId()+"");
        topicIsCompleteCheckbox.setChecked(isTopicComplete);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("frag","onActivityCreated"+topic.getTopicSerialId());
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("frag","onStart"+topic.getTopicSerialId());
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("frag","onResume"+topic.getTopicSerialId());
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("frag","onPause"+topic.getTopicSerialId());
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("frag","onStop"+topic.getTopicSerialId());
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("frag","onDestroyView"+topic.getTopicSerialId());
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("frag","onDestroy"+topic.getTopicSerialId());
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("frag","onDetach"+topic.getTopicSerialId());
        super.onDetach();
    }

    public static TopicFragment getInstance(Topic topic, Boolean isTopicComplete) {
        Bundle args = new Bundle();
        args.putSerializable(KEY,topic);
        args.putBoolean("key",isTopicComplete);
        TopicFragment fragment = new TopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void update(){
        topicIsCompleteCheckbox.setChecked(true);

    }





}
