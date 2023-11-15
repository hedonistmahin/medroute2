package com.example.medroute2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
                finish();
            }
        });


        Go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email1.getEditText().getText().toString().trim();
                final String password = Password1.getEditText().getText().toString().trim();
                final String name = FullName.getEditText().getText().toString().trim();
                final String phone = Phone.getEditText().getText().toString().trim();

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
                            Toast.makeText(getApplicationContext(), "Register is Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Register is Not Successfull", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
            }

        });
    }
}


