package com.example.medroute2;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class dash_bord extends Activity {

    private FirebaseAuth mAuth;
    TextView displayNamed;
    RelativeLayout relativeLayoutICU;
    RelativeLayout relativeLayoutBed, relativeLayoutBlood,relativeLayoutAmbulance ;
    CircleImageView profileimage1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord);
        relativeLayoutICU=findViewById(R.id.icu);
        relativeLayoutBed=findViewById(R.id.bed);
        relativeLayoutBlood=findViewById(R.id.blood);
        profileimage1 = findViewById(R.id.profile_image);

        relativeLayoutAmbulance=findViewById(R.id.ambulance);




         relativeLayoutICU.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intentICU= new Intent(dash_bord.this, ICU.class);
                 startActivity(intentICU);
             }
         });

         relativeLayoutBed.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intentBed= new Intent(dash_bord.this, Bed.class);
                 startActivity(intentBed);
             }
         });

        relativeLayoutBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBed= new Intent(dash_bord.this, BloodBankPage.class);
                startActivity(intentBed);
            }
        });
        relativeLayoutAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentA=new Intent(dash_bord.this,Ambulance1.class);
                startActivity(intentA);
            }
        });


        displayNamed = findViewById(R.id.displayName);
        showData();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.a11, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.b22, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.c33, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.d44, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.e55, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.f1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.g1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.h1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i1, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_search);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home){
                return true;

            } else if (item.getItemId() == R.id.bottom_search) {
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), user_profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;

            }

            return false;
        });
    }

    public void showData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String nameUser = dataSnapshot.child("fullName").getValue(String.class);
                        String profileImageUrl = dataSnapshot.child("profileImageUrl").getValue(String.class); // Get the profile image URL

                        displayNamed.setText(nameUser); // Set display name

                        // Load and display the profile image using Glide
                        if (profileImageUrl != null && !profileImageUrl.isEmpty()) {
                            CircleImageView profileImage = findViewById(R.id.profile_image);
                            Glide.with(dash_bord.this)
                                    .load(profileImageUrl)
                                    .skipMemoryCache(true)  // Skip memory cache
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)  // Skip disk cache
                                    .into(profileimage1);
                        }
                    } else {
                        // Handle the case where data for the user does not exist
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle error
                }
            });
        }
    }

}
