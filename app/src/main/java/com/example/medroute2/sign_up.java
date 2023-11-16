package com.example.medroute2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends Activity {

    private TextInputLayout Email2, Password2;
    private AppCompatButton Go2;
    private Button sign_up,ForgotPassword;
    private FirebaseAuth auth;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Email2 = findViewById(R.id.memail);
        Password2 = findViewById(R.id.password);
        Go2= findViewById(R.id.go_btn2);
        sign_up = findViewById(R.id.signup_btn);
        forgotPassword = findViewById(R.id.forgotbtn3);

        auth = FirebaseAuth.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sineup.class));
                finish();
            }
        });


        Go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email2.getEditText().getText().toString().trim();
                final String password = Password2.getEditText().getText().toString().trim();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!password.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, password)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(sign_up.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(sign_up.this, dash_bord.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(sign_up.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Password2.setError("Empty fields are not allowed");
                    }
                } else if (email.isEmpty()) {
                    Email2.setError("Empty fields are not allowed");
                } else {
                    Email2.setError("Please enter correct email");
                }
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view ){
            AlertDialog.Builder builder = new AlertDialog.Builder(sign_up.this);
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);

            EditText emailBox = dialogView.findViewById(R.id.emailBox);

            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String userEmail = emailBox.getText().toString();
                if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    Toast.makeText(sign_up.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(sign_up.this, "Check your email", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(sign_up.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });
        }
    }




