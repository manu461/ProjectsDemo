package e.dekod.masteringblockchain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull UnitListRecyclerViewHolder holder, int position) {
        Unit unit = allUnitsList.get(position);
        holder.unitSerialTextView.setText("Unit "+unit.getUnitSerialId()+":");
        holder.unitTitleTextView.setText(unit.getUnitTitle());
        holder.unit = allUnitsList.get(position);

    }

    @Override
    public int getItemCount() {
        return allUnitsList.size();
    }

    public class UnitListRecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView unitSerialTextView;
        private TextView unitTitleTextView;
        private Button viewTopicsButton;
        private CheckBox unitIsCompleteCheckBox;
        private Unit unit;

        public UnitListRecyclerViewHolder(final View itemView) {
            super(itemView);
            unitSerialTextView = itemView.findViewById(R.id.unitSerialID_textView);
            unitTitleTextView = itemView.findViewById(R.id.unitTitle_textView);
            viewTopicsButton = itemView.findViewById(R.id.viewTopics_button);
            unitIsCompleteCheckBox = itemView.findViewById(R.id.unit_isComplete_checkBox);
            viewTopicsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = TopicsActivity.getIntent(itemView.getContext(),unit);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
