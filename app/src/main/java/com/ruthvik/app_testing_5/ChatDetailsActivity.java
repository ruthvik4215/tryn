package com.ruthvik.app_testing_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ruthvik.app_testing_5.databinding.ActivityChatDetailsBinding;

public class ChatDetailsActivity extends AppCompatActivity {

    ActivityChatDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}