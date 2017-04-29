package com.example.stalker.bnronegeoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionText;
    private Button mNextButton;
    private TextView mScoreText;
    private int question;
    private Button mCheatButton;


    private static final String KEY_INDEX = "index";
    private static final String TAG = "QuizActivity";
    private static final int REQUEST_CODE_CHEAT = 0;


    private Questions[] mAllQuestions = new Questions[]{
            new Questions(R.string.question1,false),
            new Questions(R.string.question2,false),
            new Questions(R.string.question3,true),
            new Questions(R.string.question4,true),
            new Questions(R.string.question5,false),
            new Questions(R.string.question6,true),
            new Questions(R.string.question7,false),
            new Questions(R.string.question8,true),
            new Questions(R.string.question9,true),
            new Questions(R.string.question10,false),
    };
//    private int[] mStatus = new int[mAllQuestions.length];

    private int mCurrentindex = 0;
    private int mCurrentscore = 0;
    private boolean mIsCheater = false;
    //public View view = findViewById(R.id.score_text);
    //public View root = view.getRootView();
//    private LinearLayout main = (LinearLayout) findViewById(R.id.main);


    private void updateQuestion(){
        //Log.d(TAG,"updateQuestion"+mCurrentindex,new Exception("fuck"));
        mCurrentindex = (mCurrentindex+1)% mAllQuestions.length;
        question = mAllQuestions[mCurrentindex].getTextResId();
        mQuestionText.setText(question);
        mFalseButton.setEnabled(true);
        mTrueButton.setEnabled(true);
        //setActivityBackgroundColor(R.color.colorNormal);
    }

    private void checkAnswer(boolean AnswerPressed){
        boolean whatPressed = mAllQuestions[mCurrentindex].isAnswerTrue();
        int messageResId;

        if(mIsCheater){
            messageResId = R.string.judgment_toasts;
        }
        else {
            if (whatPressed == AnswerPressed) {
                mCurrentscore++;
                mScoreText.setText(Integer.toString(mCurrentscore));
                messageResId = R.string.right_answer;
            } else {
                messageResId = R.string.wrong_answer;
            }
        }
        Log.d(TAG, String.valueOf(mIsCheater));
        Toast.makeText(QuizActivity.this,messageResId,Toast.LENGTH_SHORT).show();
//        mStatus[mCurrentindex] = 1;
//        if(mStatus[mCurrentindex] == 1){
            mFalseButton.setEnabled(false);
            mTrueButton.setEnabled(false);
//        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, mCurrentindex);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }

            if(requestCode == REQUEST_CODE_CHEAT){
                mIsCheater = true;
            }
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            mCurrentindex = savedInstanceState.getInt(KEY_INDEX);
        }

        setContentView(R.layout.activity_quiz);


        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionText = (TextView) findViewById(R.id.question_text);
        mNextButton = (Button) findViewById(R.id.next_button);
        mScoreText = (TextView) findViewById(R.id.score_text);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        //Toast.makeText(this,"APP STARTED",Toast.LENGTH_SHORT).show();
        question = mAllQuestions[mCurrentindex].getTextResId();
        mQuestionText.setText(question);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);

            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   checkAnswer(false);

            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                mIsCheater = false;

         }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = CheatActivity.newIntent(QuizActivity.this,mAllQuestions[mCurrentindex].isAnswerTrue());
                startActivityForResult(i,REQUEST_CODE_CHEAT);
            }
        });


    }

}
