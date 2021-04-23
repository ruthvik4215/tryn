package com.ruthvik.app_testing_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ruthvik.app_testing_5.Adapters.FragmentsAdapter;
import com.ruthvik.app_testing_5.Fragments.CallsFragment;
import com.ruthvik.app_testing_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        auth = FirebaseAuth.getInstance();

        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(auth.getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.addUser:
                Toast.makeText(MainActivity.this, "Users will be updated constantly in current viewing page.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.markallread:
                Toast.makeText(MainActivity.this, "No unread message found", Toast.LENGTH_SHORT).show();
                break;

            case R.id.scanner:
                Toast.makeText(MainActivity.this, "coming soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.SettingsDialog);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.settings, (ViewGroup) findViewById(R.id.settings));
                sheetView.findViewById(R.id.profileSettings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, profileActivity.class);
                        startActivity(intent);
                    }
                });
                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
                break;

            case R.id.logout:
                auth.signOut();
                Toast.makeText(MainActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}