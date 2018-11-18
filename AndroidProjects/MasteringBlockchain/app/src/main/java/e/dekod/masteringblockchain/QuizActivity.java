package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Luggage;
import e.dekod.masteringblockchain.Beans.Quiz;

public class QuizActivity extends AppCompatActivity {

    private static final String KEY_ONE = "e.dekod.masteringblockchain.QuizActivity_key_one";
    private static final String KEY_TWO = "e.dekod.masteringblockchain.QuizActivity_key_two";


    private Quiz quiz;
    private ArrayList<String> allAnswersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = (Quiz) getIntent().getSerializableExtra(KEY_ONE);
        allAnswersList = (ArrayList<String>) getIntent().getSerializableExtra(KEY_TWO);
    }

    public static Intent getIntent(Context context, Quiz quiz, ArrayList<String> allAnswersList){
        Intent intent = new Intent(context,QuizActivity.class);
        intent.putExtra(KEY_ONE, quiz);
        intent.putExtra(KEY_TWO, allAnswersList);
        return intent;
    }
}
