package com.example.medroute2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editNumber, editAddress;
    Button saveButton;
    String userId, nameUser, emailUser, numberUser, addressUser;
    DatabaseReference reference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editNumber = findViewById(R.id.editNumber);
        editAddress = findViewById(R.id.editAddress);
        saveButton = findViewById(R.id.saveButton);

        showData();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.blackTransparent));
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoadingIndicator();
                saveChanges();
                startActivity(new Intent(getApplicationContext(), user_profile.class));
            }
        });
    }

    private void showData() {
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");
        nameUser = intent.getStringExtra("fullName");
        emailUser = intent.getStringExtra("email");
        numberUser = intent.getStringExtra("phone");
        addressUser = intent.getStringExtra("address");

        // Set retrieved data to EditText fields
        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editNumber.setText(numberUser);
        editAddress.setText(addressUser);
    }

    private void saveChanges() {
        String updatedName = editName.getText().toString().trim();
        String updatedEmail = editEmail.getText().toString().trim();
        String updatedNumber = editNumber.getText().toString().trim();
        String updatedAddress = editAddress.getText().toString().trim();

        // Update data in the Firebase Realtime Database
        reference.child(userId).child("fullName").setValue(updatedName);
        reference.child(userId).child("email").setValue(updatedEmail);
        reference.child(userId).child("phone").setValue(updatedNumber);
        reference.child(userId).child("address").setValue(updatedAddress);

        // Simulate a delay for demonstration purposes (replace with your actual data update logic)
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        hideLoadingIndicator();
                        Toast.makeText(EditProfileActivity.this, "Changes saved successfully", Toast.LENGTH_SHORT).show();
                    }
                },
                2000 // 2 seconds delay (adjust as needed)
        );
    }

    private void showLoadingIndicator() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving Changes...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void hideLoadingIndicator() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
