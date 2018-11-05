package e.dekod.masteringblockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import e.dekod.masteringblockchain.Beans.CryptoCurrency;


public class CryptoListRecyclerViewAdapter extends RecyclerView.Adapter<CryptoListRecyclerViewAdapter.CryptoListRecyclerViewHolder> {

    private ArrayList<CryptoCurrency> allCryptoList;
    Context context;

    public CryptoListRecyclerViewAdapter(ArrayList<CryptoCurrency> allCryptoList, Context context) {
        this.allCryptoList = allCryptoList;
        this.context = context;
    }

    @NonNull
    @Override
    public CryptoListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_crypto,parent,false);
        return new CryptoListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CryptoListRecyclerViewHolder holder, int position) {
        CryptoCurrency crypto = allCryptoList.get(position);
        Picasso.get().load(crypto.getIcon()).into(holder.cryptoIconImageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.lottieAnimationView.cancelAnimation();
                holder.lottieAnimationView.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
        holder.cryptoNameTextView.setText(crypto.getName());
        holder.crypto = allCryptoList.get(position);
    }

    @Override
    public int getItemCount() {
        return allCryptoList.size();
    }

    public class CryptoListRecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView cryptoIconImageView;
        private TextView cryptoNameTextView;
        private CardView cryptoCardView;
        private LottieAnimationView lottieAnimationView;
        private CryptoCurrency crypto;
        public CryptoListRecyclerViewHolder(View itemView) {
            super(itemView);

            cryptoIconImageView = itemView.findViewById(R.id.crypto_icon_image_view);
            cryptoNameTextView = itemView.findViewById(R.id.crypto_name_text_view);
            cryptoCardView = itemView.findViewById(R.id.cardView_crypto);
            lottieAnimationView = itemView.findViewById(R.id.image_loading_lottie_crypto);

            cryptoCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View view = LayoutInflater.from(context).inflate(R.layout.dialog_crypto_description, null);
                    builder.setView(view);
                    builder.show();
                }
            });


        }
    }
}
