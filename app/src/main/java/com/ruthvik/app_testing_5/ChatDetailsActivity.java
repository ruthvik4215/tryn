package com.ruthvik.app_testing_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.ruthvik.app_testing_5.databinding.ActivityChatDetailsBinding;
import com.squareup.picasso.Picasso;

public class ChatDetailsActivity extends AppCompatActivity {

    ActivityChatDetailsBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        String senderId = auth.getUid();
        String recieverId = getIntent().getStringExtra("userId");
        String userName = getIntent().getStringExtra("userName");
        String userProfilePhoto = getIntent().getStringExtra("userProfilePhoto");

        binding.userName3.setText(userName);
        Picasso.get().load(userProfilePhoto).placeholder(R.drawable.ic_man).into(binding.profileImage);
    }
}