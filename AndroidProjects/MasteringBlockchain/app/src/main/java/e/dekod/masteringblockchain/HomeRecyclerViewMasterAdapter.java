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

    private Context context;
    ArrayList<Chapter> allChapterList;
    ArrayList<CryptoCurrency> allCryptoList;
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;


    public HomeRecyclerViewMasterAdapter(Context context, ArrayList<Chapter> allChapterList, ArrayList<CryptoCurrency> allCryptoList) {
        this.context = context;
        this.allChapterList = allChapterList;
        this.allCryptoList = allCryptoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case VERTICAL:
                view = inflater.inflate(R.layout.chapters_recycler_view, parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case HORIZONTAL:
                view = inflater.inflate(R.layout.crypto_recycler_view, parent, false);
                holder = new HorizontalViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.crypto_recycler_view, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VERTICAL)
            verticalView((VerticalViewHolder) holder);
        else if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);

    }

    private void horizontalView(HorizontalViewHolder holder) {
        Log.d("recycler","horizontal");
        CryptoListRecyclerViewAdapter adapter = new CryptoListRecyclerViewAdapter(allCryptoList,context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void verticalView(VerticalViewHolder holder) {
        Log.d("recycler","vertical");
        ChapterListRecyclerViewAdapter adapter1 = new ChapterListRecyclerViewAdapter(allChapterList, context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter1);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1)
            return VERTICAL;
        if (position == 0)
            return HORIZONTAL;
        return -1;
    }
    private class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.chapter_list_recycler_view);
        }
    }

    private class HorizontalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.crypto_list_recycler_view);
        }
    }
}
