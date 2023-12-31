package com.example.medroute2;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class Sineup extends Activity {

    public static final String TAG = "TAG";
    private TextInputLayout FullName, Email1, Password1, Re_enter_password, Phone;
    private AppCompatButton Go1;
    private Button Login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sineup);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.blackTransparent));
        }

        mAuth = FirebaseAuth.getInstance();

        FullName = findViewById(R.id.Full_name);
        Email1 = findViewById(R.id.email);
        Password1 = findViewById(R.id.password_signup);
        Re_enter_password = findViewById(R.id.re_enter_passoword);
        Phone = findViewById(R.id.phone);
        Go1 = findViewById(R.id.Go_btn);
        Login = findViewById(R.id.loginbtn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), sign_up.class));
            }
        });


        Go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email1.getEditText().getText().toString().trim();
                final String password = Password1.getEditText().getText().toString().trim();
                final String name = FullName.getEditText().getText().toString().trim();
                final String phone = Phone.getEditText().getText().toString().trim();
                final String address = "";
                if (TextUtils.isEmpty(email)) {

                    Email1.setError("Email is Required");
                    return;

                }

                if (TextUtils.isEmpty(password)) {

                    Password1.setError("Password is Required");
                    return;

                }

                if (password.length() < 6) {

                    Password1.setError("Must be >= 6 character");
                    return;

                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(name) // Set user's name
                                        .build();

                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // Name updated successfully
                                                    // Now, store additional information like phone number
                                                    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users");

                                                    User newUser = new User(name, phone, email, address); // Create a User class with appropriate fields
                                                    userRef.child(user.getUid()).setValue(newUser);

                                                    Toast.makeText(getApplicationContext(), "Register is Successfull", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(), sign_up.class));
                                                    finish();
                                                }
                                            }
                                        });


                            } else {
                                // Handle the case where user is null
                                Toast.makeText(getApplicationContext(), "Registration not successful, please try again", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "User is already registered. Please log in.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration not successful, please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });



                    }


                });
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        String ContactID= ref.push().getKey();
        User user1= new User();

        ref.child(ContactID).setValue(user1);
    }

    public class User {
        private String fullname;
        private String phone;
        private String email;
        private String address; // Add the new field


        public User() {
            // Default constructor required for Firebase
        }

        public User(String fullname, String phone, String email, String address) {
            this.fullname = fullname;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }
       public void user1(){

        }

        public String getfullName() {
            return fullname;
        }

        public String getPhone() {
            return phone;
        }
        public String getEmail() {
            return email;
        }


    }
}