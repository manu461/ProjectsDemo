package e.dekod.masteringblockchain;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Chapter;

import static android.support.v7.content.res.AppCompatResources.getDrawable;

public class ChapterListRecyclerViewAdapter extends RecyclerView.Adapter<ChapterListRecyclerViewAdapter.ChapterListRecyclerViewHolder> {


    private ArrayList<Chapter> allChaptersList;
    public ChapterListRecyclerViewAdapter(ArrayList<Chapter> allChaptersList) {
        this.allChaptersList = allChaptersList;
    }

    @NonNull
    @Override
    public ChapterListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chapter_list_item,parent,false);
        return new ChapterListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterListRecyclerViewHolder holder, int position) {
        Chapter chapter = allChaptersList.get(position);
        holder.chapterIconImageView.setImageResource(R.drawable.app_logo);
        holder.chapterTitleTextView.setText(chapter.getChapterTitle());
        holder.chapterDescriptionTextView.setText(chapter.getChapterDescription());
        holder.chapterProgressProgressBar.setProgress(chapter.getChapterProgress());
        holder.chapterProgressTextView.setText(chapter.getChapterProgress()+"");
        holder.chapterSerialTextView.setText("Chapter "+chapter.getChapterSerial()+"/"+allChaptersList.size());
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
        public ChapterListRecyclerViewHolder(View itemView) {
            super(itemView);
            chapterIconImageView = itemView.findViewById(R.id.chapter_icon_imageView);
            chapterTitleTextView = itemView.findViewById(R.id.chapter_title_textView);
            chapterDescriptionTextView = itemView.findViewById(R.id.chapter_description_textView);
            chapterProgressProgressBar = itemView.findViewById(R.id.chapter_progress_progressBar);
            chapterProgressTextView = itemView.findViewById(R.id.chapter_progress_textView);
            chapterSerialTextView = itemView.findViewById(R.id.chapter_serial_textView);
            chapterIsCompleteCheckbox = itemView.findViewById(R.id.chapter_isComplete_checkBox);
        }
    }
}
