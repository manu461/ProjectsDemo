package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Unit;

public class UnitsActivity extends AppCompatActivity {

    private static final String KEY = "e.dekod.masteringblockchain.UnitsActivity";

    private TextView chapterNameTextView;
    private RecyclerView unitRecyclerView;

    private Chapter chapter;
    ArrayList<Unit> allUnitsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        chapterNameTextView = findViewById(R.id.units_chapter_title_textView);
        unitRecyclerView = findViewById(R.id.unit_list_recycler_view);

        unitRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        chapter = (Chapter) getIntent().getSerializableExtra(KEY);

        allUnitsList = (ArrayList<Unit>) chapter.getUnitsOfChapter();

        chapterNameTextView.setText(chapter.getChapterTitle());
        unitRecyclerView.setAdapter(new UnitListRecyclerViewAdapter(allUnitsList));
    }

    public static Intent getIntent(Context context, Chapter chapter){
        Intent intent = new Intent(context,UnitsActivity.class);
        intent.putExtra(KEY, chapter);
        return intent;
    }
}
