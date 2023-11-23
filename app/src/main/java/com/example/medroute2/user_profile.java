package com.example.medroute2;

import static com.example.medroute2.sign_up.SHARED_PREFS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_profile extends Activity {

    private FirebaseAuth mAuth;

    private Button Logout;
    private TextInputEditText profileName, profileEmail, profileNumber, profileAddress;
    TextView displayName;
    Button editprofile;
    CircleImageView profileimage;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_search);

        profileName = findViewById(R.id.fullName1);
        profileEmail = findViewById(R.id.email1);
        profileNumber = findViewById(R.id.phoneN);
        profileAddress = findViewById(R.id.address);
        displayName = findViewById(R.id.fullnameu);
        editprofile = findViewById(R.id.editbtn);
        profileimage = findViewById(R.id.profile_image2);
        showUserData();


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home){
                startActivity(new Intent(getApplicationContext(), dash_bord.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;

            } else if (item.getItemId() == R.id.bottom_search) {
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                return true;

            }

            return false;
        });

        Logout = findViewById(R.id.logoutbtn);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passUserData();
            }
        });

    }

    public void showUserData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String nameUser = dataSnapshot.child("fullName").getValue(String.class);
                        String nameEmail = dataSnapshot.child("email").getValue(String.class);
                        String nameNumber = dataSnapshot.child("phone").getValue(String.class);
                        String userAddress = dataSnapshot.child("address").getValue(String.class);
                        String profileImageUrl = dataSnapshot.child("profileImageUrl").getValue(String.class); // Get the profile image URL

                        displayName.setText(nameUser); // Set display name
                        profileName.setText(nameUser);
                        profileEmail.setText(nameEmail);
                        profileNumber.setText(nameNumber);
                        profileAddress.setText(userAddress); // Display the address

                        // Load and display the profile image using Glide
                        if (profileImageUrl != null && !profileImageUrl.isEmpty()) {
                            Glide.with(user_profile.this)
                                    .load(profileImageUrl)
                                    .skipMemoryCache(true)  // Skip memory cache
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)  // Skip disk cache
                                    .into(profileimage);
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



    public void passUserData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users").child(userId);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String nameFromDB = snapshot.child("fullName").getValue(String.class);
                        String emailFromDB = snapshot.child("email").getValue(String.class);
                        String phoneNumberFromDB = snapshot.child("phone").getValue(String.class);
                        String addressFromDB = snapshot.child("address").getValue(String.class);
                        String profileImageUrl = snapshot.child("profileImageUrl").getValue(String.class); // Get the profile image URL
                        Intent intent = new Intent(user_profile.this, EditProfileActivity.class);
                        intent.putExtra("userId", userId); // Pass the user's UID
                        intent.putExtra("fullName", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone", phoneNumberFromDB);
                        intent.putExtra("address", addressFromDB);
                        intent.putExtra("profileImageUrl", profileImageUrl); // Pass the profile image URL
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error
                }
            });
        }
    }



    private void logoutUser() {
        // Clear the Remember Me state
        clearRememberMeState();

        // Redirect to login page or another activity
        Intent intent = new Intent(user_profile.this, sign_up.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void clearRememberMeState() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Clear Remember Me state
        editor.remove("name");
        editor.apply();
    }
}
