package e.dekod.masteringblockchain;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TopicStatusDao {
    private static ArrayList<Boolean> allTopicStatusList;
    private static FirebaseAuth mAuth;
    private static DatabaseReference currentUserReference;
    private static DatabaseReference currentUserTopicStatusReference;
    private static boolean result = false;

    public static boolean connect() {
        mAuth = FirebaseAuth.getInstance();
        currentUserReference = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid());
        currentUserTopicStatusReference = currentUserReference.child("topicsStatus");
        currentUserTopicStatusReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allTopicStatusList = new ArrayList<Boolean>();
                allTopicStatusList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for (DataSnapshot allTopicStatusSnapshot : var) {
                    allTopicStatusList.add(allTopicStatusSnapshot.getValue(Boolean.class));
                }
                result = true;
                //------------------------------------//

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                result = false;
            }
        });
        return result;
    }

    public static ArrayList<Boolean> getTopicStatusList() {
        return allTopicStatusList;
    }
}
