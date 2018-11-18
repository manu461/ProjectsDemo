package e.dekod.masteringblockchain;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Quiz;
import spencerstudios.com.bungeelib.Bungee;

public class QuizListRecyclerViewAdapter extends RecyclerView.Adapter<QuizListRecyclerViewAdapter.QuizListRecyclerViewHolder> {

    private ArrayList<Quiz>  allQuizList;
    private ArrayList<String> allAnswersList;
    private Context context;
    View myView;

    public QuizListRecyclerViewAdapter(ArrayList<Quiz> allQuizList, ArrayList<String> allAnswerList, Context context) {
        this.allQuizList = allQuizList;
        this.allAnswersList = allAnswerList;
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
        Quiz quiz = allQuizList.get(position);

        holder.quizNameTextView.setText(quiz.getQuizName());
        holder.quizDescriptionTextView.setText(quiz.getQuizDescription());

        Picasso.get().load(quiz.getQuizImage()).into(holder.quizImageImageView, new Callback() {
            @Override
            public void onSuccess() {
                //setup animation for loading
            }

            @Override
            public void onError(Exception e) {

            }
        });

        holder.quiz = quiz;


    }

    @Override
    public int getItemCount() {
        return allQuizList.size();
    }

    public class QuizListRecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView quizNameTextView;
        private TextView quizDescriptionTextView;
        private RatingBar quizScoreRatingBar;
        private ImageView quizImageImageView;
        private CardView quizCardView;
        private Quiz quiz;



        public QuizListRecyclerViewHolder(View itemView) {
            super(itemView);

            quizNameTextView = itemView.findViewById(R.id.quizName_textView);
            quizDescriptionTextView = itemView.findViewById(R.id.quizDesc_textView);
            quizScoreRatingBar = itemView.findViewById(R.id.quizScore_ratingBar);
            quizImageImageView = itemView.findViewById(R.id.quizImage_imageView);
            quizCardView = itemView.findViewById(R.id.quizCard_cardView);

            quizCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    final View view = LayoutInflater.from(context).inflate(R.layout.dialog_quiz_instructions, null);

                    LottieAnimationView cancelButton = view.findViewById(R.id.instruction_dialog_cancel_button_lottie_animation_view);
                    CheckBox instructionReadCheckBox = view.findViewById(R.id.instruction_dialog_isRead_checkbox);
                    final Button proceedToQuizButton = view.findViewById(R.id.instruction_dialog_proceed_button);

                    instructionReadCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            proceedToQuizButton.setEnabled(isChecked);
                        }
                    });

                    builder.setView(view);
                    final AlertDialog dialog = builder.create();

                    proceedToQuizButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = QuizActivity.getIntent(context,quiz,allAnswersList);
                            Bungee.slideLeft(context);
                            context.startActivity(intent);
                            dialog.dismiss();
                        }
                    });
                    cancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();


                }
            });
        }
    }
}
