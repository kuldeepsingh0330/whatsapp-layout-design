package com.ransankul.clonewhatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.ransankul.clonewhatsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setElevation(0);

        binding.viewPager.setAdapter(new fragementAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.newGroup:
                Toast.makeText(this, "new group clicked", Toast.LENGTH_SHORT).show();
            case R.id.newBroadcast:
                Toast.makeText(this, "new broadcast clicked", Toast.LENGTH_SHORT).show();
            case R.id.linkedDevices:
                Toast.makeText(this, "linked device clicked", Toast.LENGTH_SHORT).show();
            case R.id.starredMessage:
                Toast.makeText(this, "starred message clicked", Toast.LENGTH_SHORT).show();
            case R.id.payments:
                Toast.makeText(this, "payment clicked", Toast.LENGTH_SHORT).show();
            case R.id.settings:
                Toast.makeText(this, "setting clicked", Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}
