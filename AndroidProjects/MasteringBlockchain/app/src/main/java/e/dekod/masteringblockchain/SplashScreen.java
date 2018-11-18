package e.dekod.masteringblockchain;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import e.dekod.masteringblockchain.Beans.Chapter;
import e.dekod.masteringblockchain.Beans.CryptoCurrency;
import e.dekod.masteringblockchain.Beans.Luggage;
import e.dekod.masteringblockchain.Beans.Quiz;
import e.dekod.masteringblockchain.Beans.User;
import spencerstudios.com.bungeelib.Bungee;

public class SplashScreen extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;
    private static int SPLASH_TIME_OUT = 3000;

    private WebView mWebView;
    private SignInButton googleSignInButton;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseRoot;
    private DatabaseReference databaseChapters;
    private DatabaseReference databaseCrypto;
    private DatabaseReference databaseTopicCount;
    private DatabaseReference databaseUser;
    private DatabaseReference databaseHomePageImages;
    private DatabaseReference databaseQuizzes;
    private DatabaseReference databaseAnswers;

    private ArrayList<Chapter> allChapterList;
    private ArrayList<CryptoCurrency> allCryptoList;
    private int topicCount;
    private User user;
    private ArrayList<String> homePageImages;
    private ArrayList<Quiz> allQuizList;
    private ArrayList<String> allAnswersList;

    private boolean chaptersLoaded = false;
    private boolean cryptoLoaded = false;
    private boolean topicCountLoaded = false;
    private boolean userLoaded = false;
    private boolean homePageImagesLoaded = false;
    private boolean quizLoaded = false;
    private boolean answerListLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("debug","enter onCreate");

        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        mWebView = findViewById(R.id.webView_splash);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/particle_js/demo/index.html");

        googleSignInButton = findViewById(R.id.signUp_button);
        googleSignInButton.setSize(SignInButton.SIZE_WIDE);


        mAuth = FirebaseAuth.getInstance();
        databaseRoot = FirebaseDatabase.getInstance().getReference();
        databaseChapters = databaseRoot.child("chapters");
        databaseCrypto = databaseRoot.child("cryptoCurrency");
        databaseTopicCount = databaseRoot.child("topicCount");
        databaseUser = databaseRoot.child("users");
        databaseHomePageImages = databaseRoot.child("homePageImages");
        databaseQuizzes = databaseRoot.child("quizzes");
        databaseAnswers = databaseRoot.child("answers");



        Log.d("debug","exit onCreate");




    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("debug","enter onStart");


        //retrieve all chapters and store it in the arrayList
        databaseChapters.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start chapter OnDataChange");
                allChapterList = new ArrayList<Chapter>();
                allChapterList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot chapterSnapshot : var){
                    Chapter chapter = chapterSnapshot.getValue(Chapter.class);
                    allChapterList.add(chapter);


                }
                chaptersLoaded = true;


                //------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end chapter OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //retrieve all crypto and store it in the arrayList
        databaseCrypto.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start chapter OnDataChange");
                allCryptoList = new ArrayList<CryptoCurrency>();
                allCryptoList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot cryptoSnapshot : var){
                    CryptoCurrency crypto = cryptoSnapshot.getValue(CryptoCurrency.class);
                    allCryptoList.add(crypto);


                }
                cryptoLoaded = true;


                //------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end chapter OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //retrieve topic count and store it a int variable
        databaseTopicCount.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start topicCount OnDataChange");
                topicCount = dataSnapshot.getValue(Integer.class);
                topicCountLoaded = true;

                //-----------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end topicCount OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //retrieve Homepage Images
        databaseHomePageImages.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start homePageImages OnDataChange");
                homePageImages = new ArrayList<String>();
                homePageImages.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot homePageImagesSnapshot : var){
                    homePageImages.add(homePageImagesSnapshot.getValue(String.class));
                }
                homePageImagesLoaded = true;


                //------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end homePageImages OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //retrieve all quizzes and store it in the arrayList
        databaseQuizzes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start quizzes OnDataChange");
                allQuizList = new ArrayList<Quiz>();
                allQuizList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot quizSnapshot : var){
                    Quiz quiz = quizSnapshot.getValue(Quiz.class);
                    allQuizList.add(quiz);


                }
                quizLoaded = true;


                //------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end quizzes OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //retrieve all answers and store it in the arrayList
        databaseAnswers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("debug","start allAnswers OnDataChange");
                allAnswersList = new ArrayList<String>();
                allAnswersList.clear();
                Iterable<DataSnapshot> var = dataSnapshot.getChildren();
                for(DataSnapshot answersSnapshot : var){
                    allAnswersList.add(answersSnapshot.getValue(String.class));
                }
                answerListLoaded = true;


                //------------------------------------//
                tryLaunchingIntent();
                Log.d("debug","end allAnswers OnDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






        if (mAuth.getCurrentUser() != null) {

            Log.d("debug","start- if user not null");

            //retrieve user information from database and store it in user object
            loadUser();

            //retrieve topicStatus array and create user object
            //sleep for some time
            //call intent to homeActivity and pass user, topicCount, chapterList, topicStatusExists


///////////////////////////////////////////////////////


///////////////////////////////////////////////////////


            Log.d("debug","end- if user not null");
        }
        else {
            Log.d("debug","start- if user is null");
            //enable signUp button
            googleSignInButton.setVisibility(View.VISIBLE);
            googleSignInButton.setClickable(true);
            Log.d("debug","end- if user is null");
        }




        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("debug","start onClick of googleSignInButton");
                //inside signUp button onClick Listener call signUp activity which contains different signUp methods. pass all three variables as well.
                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.GoogleBuilder().build()
//                        new AuthUI.IdpConfig.FacebookBuilder().build()
                );

                // Create and launch sign-in intent
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);

                Log.d("debug","end onClick of googleSignInButton");

            }
        });


        Log.d("debug","exit onStart");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("debug","inside onActivityResult");
        if (requestCode == RC_SIGN_IN) {
            Log.d("debug","inside if RC_SIGN_IN");
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                Log.d("debug","inside if RESULT_OK");
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //save firebase user to storage with topicStatusArray all false;


                FirebaseUserMetadata metadata = mAuth.getCurrentUser().getMetadata();
                if (metadata.getCreationTimestamp() == metadata.getLastSignInTimestamp()) {
                    Log.d("debug","inside if Timestamp comparison");
                    // add user data into database
                    ArrayList<Boolean> topicStatusList = new ArrayList<>();
                    topicStatusList.add(false);
                    for(int i=0;i<topicCount;i++){
                        topicStatusList.add(false);
                    }
                    this.user = new User(user.getUid(),user.getEmail(),user.getDisplayName(),user.getPhotoUrl().toString(),topicStatusList);
                    userLoaded = true;
                    //-----------------------------------------//
                    tryLaunchingIntent();

                    databaseUser.child(user.getUid()).setValue(this.user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(SplashScreen.this, "User data added to database!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SplashScreen.this, "Failed to add User data to database!", Toast.LENGTH_SHORT).show();
                            Log.d("manu",e+"");
                        }
                    });

                }
                else {
                    Log.d("debug","inside else Timestamp comparison");
                    //retrieve current user data from database and store itt in user object
                    loadUser();
                }
                //pass luggage to home activity
                ///////////////////////////////////////////

                ////////////////////////////////////////
                Log.d("debug","exiting if RESULT_OK");
            }
            else {
                Log.d("debug","inside else RESULT_OK");
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
            Log.d("debug","exiting if RC_SIGN_IN");
        }
        Log.d("debug","exit onActivityResult");
    }

    private void tryLaunchingIntent(){
        if(chaptersLoaded&&cryptoLoaded&&userLoaded&&topicCountLoaded&&homePageImagesLoaded&&answerListLoaded&&quizLoaded) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("debug","splash user: "+user.toString());
                    Log.d("debug","splash quiz: "+allQuizList.toString());
                    Log.d("debug","splash answer: "+allAnswersList.toString());
                    Intent intent = HomeActivity.getIntent(SplashScreen.this, new Luggage(allChapterList, allCryptoList, topicCount, user, homePageImages, allQuizList, allAnswersList));
                    //mWebView.destroy();
                    finish();
                    Bungee.slideLeft(SplashScreen.this);
                    startActivity(intent);

                }
            },SPLASH_TIME_OUT);

        }
    }

//        @Override
//    protected void onStart() {
//        super.onStart();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
//                startActivity(intent);
//                mWebView.destroy();
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//    }


//    @Override
//    protected void onPause() {
//        super.onPause();
//        databaseRoot;
//        databaseChapters;
//        databaseCrypto;
//        databaseTopicCount;
//        databaseUser;
//        databaseHomePageImages;
//
//    }
    private void loadUser(){
    final FirebaseUser currentUser = mAuth.getCurrentUser();
    databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            user = dataSnapshot.child(currentUser.getUid()).getValue(User.class);
            userLoaded = true;

            //--------------------------------------------//
            tryLaunchingIntent();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}
}
