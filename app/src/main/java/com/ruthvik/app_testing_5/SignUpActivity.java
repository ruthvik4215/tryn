package com.ruthvik.app_testing_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.ruthvik.app_testing_5.databinding.ActivitySignInBinding;
import com.ruthvik.app_testing_5.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // hiding the action bar.
        getSupportActionBar().hide();

        // getting the instance from firebase.
        auth = FirebaseAuth.getInstance();
    }
}