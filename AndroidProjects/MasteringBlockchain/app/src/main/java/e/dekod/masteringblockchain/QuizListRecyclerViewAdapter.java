package e.dekod.masteringblockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Quiz;

public class QuizListRecyclerViewAdapter extends RecyclerView.Adapter<QuizListRecyclerViewAdapter.QuizListRecyclerViewHolder> {

    private ArrayList<Quiz>  allQuizList;
    private Context context;

    public QuizListRecyclerViewAdapter(ArrayList<Quiz> allQuizList, Context context) {
        this.allQuizList = allQuizList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuizListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_quiz,parent,false);
        return new QuizListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class QuizListRecyclerViewHolder extends RecyclerView.ViewHolder{

        public QuizListRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
