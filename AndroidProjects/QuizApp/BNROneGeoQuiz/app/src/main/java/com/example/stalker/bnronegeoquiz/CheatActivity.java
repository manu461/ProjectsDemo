package com.example.stalker.bnronegeoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private TextView mWarningText;
    private Button mShowAnswerButton;
    private TextView mAPIlevel;



    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.stalker.bnronegeoquiz.QuizActivity";

    public static Intent newIntent(Context context, boolean isAnswerTrue){
        Intent i = new Intent(context,CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,isAnswerTrue);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mShowAnswerButton = (Button)findViewById(R.id.show_answer_button);
        mWarningText = (TextView)findViewById(R.id.warning_text_view);
        mAPIlevel = (TextView)findViewById(R.id.apiLevelTextView);

        mAPIlevel.setText("API Level "+Build.VERSION.SDK_INT);

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = String.valueOf(getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false));
                mWarningText.setText(answer);
                setResult(RESULT_OK);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mShowAnswerButton.getWidth() / 2;
                    int cy = mShowAnswerButton.getHeight() / 2;
                    float radius = mShowAnswerButton.getWidth();
                    Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerButton, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mWarningText.setVisibility(View.VISIBLE);
                            mShowAnswerButton.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }
                else{
                    mShowAnswerButton.setVisibility(View.INVISIBLE);
                    mWarningText.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
