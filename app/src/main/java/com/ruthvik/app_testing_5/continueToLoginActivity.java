package com.ruthvik.app_testing_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.ruthvik.app_testing_5.Adapters.usersAdapter;
import com.ruthvik.app_testing_5.Models.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class continueToLoginActivity extends AppCompatActivity {

    Button signInButton;
    TextView yourName;
    FirebaseDatabase database;
    FirebaseAuth auth;

    ArrayList<Users> list;
    Context context;

    public continueToLoginActivity(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_to_login);

        // hiding the action bar.
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        signInButton = findViewById(R.id.signInButton);
        yourName = findViewById(R.id.yourName);



        // when user clicks on the button it will redirect to another activity.
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(continueToLoginActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}