package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Unit;

public class UnitsActivity extends AppCompatActivity {

    private static final String KEY = "e.dekod.masteringblockchain.UnitsActivity";

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView unitRecyclerView;

    private Chapter chapter;
    ArrayList<Unit> allUnitsList;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        mWebView = findViewById(R.id.webview_actionBar);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/particle_js/demo/index.html");

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_unit_activity);
        unitRecyclerView = findViewById(R.id.unit_list_recycler_view);

        unitRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        chapter = (Chapter) getIntent().getSerializableExtra(KEY);

        allUnitsList = (ArrayList<Unit>) chapter.getUnitsOfChapter();

        collapsingToolbarLayout.setTitle(chapter.getChapterTitle());
        unitRecyclerView.setAdapter(new UnitListRecyclerViewAdapter(allUnitsList));
    }

    public static Intent getIntent(Context context, Chapter chapter){
        Intent intent = new Intent(context,UnitsActivity.class);
        intent.putExtra(KEY, chapter);
        return intent;
    }
}
