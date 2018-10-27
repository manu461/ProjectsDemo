package e.dekod.masteringblockchain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.Unit;

public class ChapterListRecyclerViewAdapter extends RecyclerView.Adapter<ChapterListRecyclerViewAdapter.ChapterListRecyclerViewHolder> {


    private ArrayList<Chapter> allChaptersList;
    public ChapterListRecyclerViewAdapter(ArrayList<Chapter> allChaptersList) {
        this.allChaptersList = allChaptersList;
    }

    @NonNull
    @Override
    public ChapterListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_chapter,parent,false);
        return new ChapterListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterListRecyclerViewHolder holder, int position) {
        Chapter chapter = allChaptersList.get(position);
        Picasso.get().load(chapter.getChapterIconURI()).into(holder.chapterIconImageView);
        holder.chapterTitleTextView.setText(chapter.getChapterTitle());
        holder.chapterDescriptionTextView.setText(chapter.getChapterDescription());
        holder.chapter = allChaptersList.get(position);

    }

    @Override
    public int getItemCount() {
        return allChaptersList.size();
    }

    public class ChapterListRecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView chapterIconImageView;
        private TextView chapterTitleTextView;
        private TextView chapterDescriptionTextView;
        private ProgressBar chapterProgressProgressBar;
        private TextView chapterProgressTextView;
        private TextView chapterSerialTextView;
        private CheckBox chapterIsCompleteCheckbox;
        private Chapter chapter;
        private CardView chapterCardView;
        public ChapterListRecyclerViewHolder(final View itemView) {
            super(itemView);
            chapterIconImageView = itemView.findViewById(R.id.chapter_icon_imageView);
            chapterTitleTextView = itemView.findViewById(R.id.chapter_title_textView);
            chapterDescriptionTextView = itemView.findViewById(R.id.chapter_description_textView);
            chapterProgressProgressBar = itemView.findViewById(R.id.chapter_progress_progressBar);
            chapterProgressTextView = itemView.findViewById(R.id.chapter_progress_textView);
            chapterSerialTextView = itemView.findViewById(R.id.chapter_serial_textView);
            chapterIsCompleteCheckbox = itemView.findViewById(R.id.chapter_isComplete_checkBox);
            chapterCardView = itemView.findViewById(R.id.cardView_chapter);

            chapterCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),chapter.getChapterTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = UnitsActivity.getIntent(itemView.getContext(),chapter);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
