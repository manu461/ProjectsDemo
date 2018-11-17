package e.dekod.masteringblockchain;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import e.dekod.masteringblockchain.Beans.Topic;

public class UnitCompleteFragment extends android.support.v4.app.Fragment {

    private LottieAnimationView unitCompleteAnimation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_complete , container , false);
        unitCompleteAnimation = view.findViewById(R.id.unit_completed_lottie);
        return view;
    }

    public static UnitCompleteFragment getInstance(){
        Bundle args = new Bundle();
        //args.putSerializable("key","value");
        UnitCompleteFragment unitCompleteFragment = new UnitCompleteFragment();
        unitCompleteFragment.setArguments(args);
        return unitCompleteFragment;
    }

    public void animate(){
        unitCompleteAnimation.playAnimation();
    }
}
