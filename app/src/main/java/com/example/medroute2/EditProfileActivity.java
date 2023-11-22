package com.example.medroute2;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//new
import androidx.annotation.NonNull;
import android.net.Uri;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import android.webkit.MimeTypeMap;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editNumber, editAddress;
    Button saveButton;
    String userId, nameUser, emailUser, numberUser, addressUser;
    DatabaseReference reference;
    ProgressDialog progressDialog;

    //new
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;
    private StorageReference storageRef;
    TextView selectImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //new
        selectImageButton = findViewById(R.id.selectImageButton);
        selectImageButton.setOnClickListener(view -> openGallery());


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
    //new
    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            uploadImage();
        }
    }

    private void uploadImage() {
        if (imageUri != null) {
            // Create a reference to store the image in Firebase Storage
            StorageReference fileReference = storageRef.child("profile_images/" + userId + "/" + System.currentTimeMillis() + "." + getFileExtension(imageUri));

            // Upload image to Firebase Storage
            fileReference.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        // Get the image download URL from Firebase Storage
                        fileReference.getDownloadUrl().addOnSuccessListener(uri -> {
                            // Save the image URL to the user's data in the Realtime Database
                            reference.child(userId).child("profileImageUrl").setValue(uri.toString());

                            // Show a message or update UI upon successful image upload
                            Toast.makeText(EditProfileActivity.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                        });
                    })
                    .addOnFailureListener(e -> {
                        // Handle image upload failure
                        Toast.makeText(EditProfileActivity.this, "Image upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        }
    }

    // ... (Other methods)

    // getFileExtension() method to get the file extension from the URI
    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}



