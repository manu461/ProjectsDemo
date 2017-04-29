package com.example.stalker.bnronegeoquiz;

/**
 * Created by staLker on 01-02-2017.
 */
public class Questions {
    private int mTextResId;
    private boolean mAnswerTrue;
    public Questions(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
