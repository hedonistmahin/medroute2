package com.example.medroute2;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editNumber, editAddress;
    Button saveButton;
    String userId, nameUser, emailUser, numberUser, addressUser, profileImageUrl;
    DatabaseReference reference;
    ProgressDialog progressDialog;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;
    private StorageReference storageRef;
    TextView selectImageButton;
    CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        selectImageButton = findViewById(R.id.selectImageButton);
        profileImage = findViewById(R.id.profile_image1);

        selectImageButton.setOnClickListener(view -> openGallery());

        storageRef = FirebaseStorage.getInstance().getReference();
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

        saveButton.setOnClickListener(view -> {
            showLoadingIndicator();
            saveChanges();
            startActivity(new Intent(getApplicationContext(), user_profile.class));
        });
    }

    private void showData() {
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");
        nameUser = intent.getStringExtra("fullName");
        emailUser = intent.getStringExtra("email");
        numberUser = intent.getStringExtra("phone");
        addressUser = intent.getStringExtra("address");
        profileImageUrl = intent.getStringExtra("profileImageUrl");

        // Set retrieved data to EditText fields
        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editNumber.setText(numberUser);
        editAddress.setText(addressUser);

        Log.d("ProfileImage", "Profile Image URL: " + profileImageUrl);

        // Load and display the profile image using Glide
        if (profileImageUrl != null && !profileImageUrl.isEmpty()) {
            Glide.with(this)
                    .load(profileImageUrl)
                    .skipMemoryCache(true)  // Skip memory cache
                    .diskCacheStrategy(DiskCacheStrategy.NONE)  // Skip disk cache
                    .into(profileImage);
        }
    }

    private void saveChanges() {
        String updatedName = editName.getText().toString().trim();
        String updatedEmail = editEmail.getText().toString().trim();
        String updatedNumber = editNumber.getText().toString().trim();
        String updatedAddress = editAddress.getText().toString().trim();

        reference.child(userId).child("fullName").setValue(updatedName);
        reference.child(userId).child("email").setValue(updatedEmail);
        reference.child(userId).child("phone").setValue(updatedNumber);
        reference.child(userId).child("address").setValue(updatedAddress);

        new android.os.Handler().postDelayed(
                () -> {
                    hideLoadingIndicator();
                    Toast.makeText(EditProfileActivity.this, "Changes saved successfully", Toast.LENGTH_SHORT).show();
                },
                2000
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
            StorageReference fileReference = storageRef.child("profile_images/" + userId + "/" + System.currentTimeMillis() + "." + getFileExtension(imageUri));

            fileReference.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        Log.d("ImageUpload", "Image uploaded successfully");

                        fileReference.getDownloadUrl().addOnSuccessListener(uri -> {
                            reference.child(userId).child("profileImageUrl").setValue(uri.toString());
                            Toast.makeText(EditProfileActivity.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                        });
                    })
                    .addOnFailureListener(e -> {
                        Log.e("ImageUpload", "Image upload failed: " + e.getMessage());
                        Toast.makeText(EditProfileActivity.this, "Image upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}
