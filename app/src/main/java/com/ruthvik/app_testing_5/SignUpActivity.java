package com.ruthvik.app_testing_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.ruthvik.app_testing_5.Models.Users;
import com.ruthvik.app_testing_5.databinding.ActivitySignInBinding;
import com.ruthvik.app_testing_5.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // hiding the action bar.
        getSupportActionBar().hide();

        // getting the instance from firebase.
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // creating dialog
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("please hold back");

        // onclick signup button.
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Displaying the progress bar when user clicks on sign up button.
                progressDialog.show();

                // creating user
                auth.createUserWithEmailAndPassword(binding.userEmail.getText().toString(), binding.userPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    // Disable the progress bar after task is successful.
                                    progressDialog.dismiss();

                                    // storing users in Realtime Databse.
                                    Users user = new Users(
                                            binding.userName.getText().toString(),
                                            binding.userEmail.getText().toString(),
                                            binding.userPassword.getText().toString()
                                    );

                                    // getting user id after completion of task <AuthResult>.
                                    String id = task.getResult().getUser().getUid();
                                    // creating data instances of each user.
                                    database.getReference().child("Users").child(id).setValue(user);

                                    // A small pop-up will appear to let user know that account created successfully.
                                    Toast.makeText(SignUpActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                                    // After account is created this will redirect the user to welcome page.
                                    Intent intent = new Intent(SignUpActivity.this, continueToLoginActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}