package e.dekod.masteringblockchain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;


public class UnitListRecyclerViewAdapter extends RecyclerView.Adapter<UnitListRecyclerViewAdapter.UnitListRecyclerViewHolder> {

    private ArrayList<Unit> allUnitsList;


    public UnitListRecyclerViewAdapter(ArrayList<Unit> allUnitsList) {
        this.allUnitsList = allUnitsList;
    }

    @NonNull
    @Override
    public UnitListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_unit,parent,false);
        return new UnitListRecyclerViewAdapter.UnitListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UnitListRecyclerViewHolder holder, int position) {
        Unit unit = allUnitsList.get(position);
        holder.unitSerialTextView.setText("UNIT "+unit.getUnitSerialId());
        holder.unitTitleTextView.setText(unit.getUnitTitle());
        Picasso.get().load(unit.getUnitIconURL()).into(holder.unitIconImageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.imageLoadingAnimationView.setVisibility(View.GONE);
                holder.imageLoadingAnimationView.cancelAnimation();
                holder.imageLoadedUnitIncompleteAnimationView.setVisibility(View.VISIBLE);
                holder.imageLoadedUnitIncompleteAnimationView.playAnimation();
            }

            @Override
            public void onError(Exception e) {

            }
        });
        if(position==1){
           holder.unitIconImageView.setImageResource(R.drawable.completed);
           holder.imageLoadedUnitIncompleteAnimationView.setVisibility(View.GONE);
           holder.imageLoadedUnitIncompleteAnimationView.cancelAnimation();
           holder.imageLoadedUnitCompleteAnimationView.setVisibility(View.VISIBLE);
           holder.imageLoadedUnitCompleteAnimationView.playAnimation();
        }
        holder.unit = allUnitsList.get(position);


    }

    @Override
    public int getItemCount() {
        return allUnitsList.size();
    }

    public class UnitListRecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView unitSerialTextView;
        private TextView unitTitleTextView;
        private CheckBox unitIsCompleteCheckBox;
        private ImageView unitIconImageView;
        private CardView unitCardView;
        private LottieAnimationView imageLoadingAnimationView;
        private LottieAnimationView imageLoadedUnitIncompleteAnimationView;
        private LottieAnimationView imageLoadedUnitCompleteAnimationView;
        private Unit unit;

        public UnitListRecyclerViewHolder(final View itemView) {
            super(itemView);
            unitSerialTextView = itemView.findViewById(R.id.unitSerialID_textView);
            unitTitleTextView = itemView.findViewById(R.id.unitTitle_textView);
            unitIconImageView = itemView.findViewById(R.id.unitIcon_imageView);
            unitCardView = itemView.findViewById(R.id.cardView_unit);

            imageLoadingAnimationView = itemView.findViewById(R.id.image_loading_lottie_unit);
            imageLoadedUnitIncompleteAnimationView = itemView.findViewById(R.id.image_loaded_lottie_unit);
            imageLoadedUnitCompleteAnimationView = itemView.findViewById(R.id.image_loaded_lottie_unit_green);

            unitCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = TopicsActivity.getIntent(itemView.getContext(),unit);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
