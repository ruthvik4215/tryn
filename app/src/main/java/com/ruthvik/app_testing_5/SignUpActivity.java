package com.ruthvik.app_testing_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ruthvik.app_testing_5.databinding.ActivitySignInBinding;
import com.ruthvik.app_testing_5.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
    }
}