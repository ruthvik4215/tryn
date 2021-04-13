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
import com.ruthvik.app_testing_5.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;
    // intitializing the progress bar.
    ProgressDialog progressDialog;

    // intializing the firebase auth
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding the layout of the class SignInActivity.
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // getting instance of Firebase
        auth = FirebaseAuth.getInstance();

        // hiding the action bar.
        getSupportActionBar().hide();

        // progress dialog will pop-up on the current activity
        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setTitle("Signing In");
        progressDialog.setMessage("logging you in");

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();

                // siging in user using firebase auth
                auth.signInWithEmailAndPassword(
                        binding.userEmail.getText().toString(),
                        binding.userPassword.getText().toString()
                )
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // on completion of task dialog will disappear
                                progressDialog.dismiss();

                                // if task is successful then user will be redirected to the home page.
                                if(task.isSuccessful()) {
                                    Toast.makeText(SignInActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

        // don't have an account
        binding.registerAccountTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // auto-login
        if(auth.getCurrentUser() != null) {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}