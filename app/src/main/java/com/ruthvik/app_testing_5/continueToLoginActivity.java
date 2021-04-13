package com.ruthvik.app_testing_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class continueToLoginActivity extends AppCompatActivity {

    Button signInButton;
    TextView yourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_to_login);

        // hiding the action bar.
        getSupportActionBar().hide();

        signInButton = findViewById(R.id.signInButton);

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