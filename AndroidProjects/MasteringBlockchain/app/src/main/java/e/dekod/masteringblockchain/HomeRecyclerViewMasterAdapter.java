package e.dekod.masteringblockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.CryptoCurrency;

public class HomeRecyclerViewMasterAdapter extends RecyclerView.Adapter {

    private final ArrayList<Boolean> allTopicStatusList;
    private Context context;
    ArrayList<Chapter> allChapterList;
    ArrayList<CryptoCurrency> allCryptoList;
    private final int CHAPTER = 1;
    private final int CRYPTO = 2;
    private final int QUIZ = 3;


    public HomeRecyclerViewMasterAdapter(Context context, ArrayList<Chapter> allChapterList, ArrayList<CryptoCurrency> allCryptoList, ArrayList<Boolean> allTopicStatusList) {
        this.context = context;
        this.allChapterList = allChapterList;
        this.allCryptoList = allCryptoList;
        this.allTopicStatusList = allTopicStatusList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case CHAPTER:
                view = inflater.inflate(R.layout.chapters_recycler_view, parent, false);
                holder = new ChapterListViewHolder(view);
                break;
            case CRYPTO:
                view = inflater.inflate(R.layout.crypto_recycler_view, parent, false);
                holder = new CryptoListViewHolder(view);
                break;

            case QUIZ:
                view = inflater.inflate(R.layout.quiz_recycler_view, parent, false);
                holder = new QuizListViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.quiz_recycler_view, parent, false);
                holder = new QuizListViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == CHAPTER)
            ChapterView((ChapterListViewHolder) holder);
        else if (holder.getItemViewType() == CRYPTO)
            CryptoView((CryptoListViewHolder) holder);
        else if (holder.getItemViewType() == QUIZ)
            QuizView((QuizListViewHolder)holder);
    }

    private void CryptoView(CryptoListViewHolder holder) {
        Log.d("recycler","crypto");
        CryptoListRecyclerViewAdapter adapter = new CryptoListRecyclerViewAdapter(allCryptoList,context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        holder.recyclerView.setItemViewCacheSize(20);
        holder.recyclerView.setDrawingCacheEnabled(true);
        holder.recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        holder.recyclerView.getRecycledViewPool().setMaxRecycledViews(1,0);

        holder.recyclerView.setAdapter(adapter);
    }

    private void ChapterView(ChapterListViewHolder holder) {
        Log.d("recycler","chapter");
        ChapterListRecyclerViewAdapter adapter = new ChapterListRecyclerViewAdapter(allTopicStatusList, allChapterList, context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        holder.recyclerView.setItemViewCacheSize(20);
        holder.recyclerView.setDrawingCacheEnabled(true);
        holder.recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        holder.recyclerView.getRecycledViewPool().setMaxRecycledViews(1,0);

        holder.recyclerView.setAdapter(adapter);
    }

    private void QuizView(QuizListViewHolder holder){

        Log.d("recycler","quiz");
        QuizListRecyclerViewAdapter adapter = new QuizListRecyclerViewAdapter(null,context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        holder.recyclerView.setItemViewCacheSize(20);
        holder.recyclerView.setDrawingCacheEnabled(true);
        holder.recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        holder.recyclerView.getRecycledViewPool().setMaxRecycledViews(1,0);

        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1)
            return CHAPTER;
        if (position == 0)
            return CRYPTO;
        if (position == 2)
            return QUIZ;
        return -1;
    }

    private class ChapterListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        ChapterListViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.chapter_list_recycler_view);
        }
    }

    private class CryptoListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        CryptoListViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.crypto_list_recycler_view);
        }
    }

    private class QuizListViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        QuizListViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.quiz_list_recycler_view);
        }
    }


}
