package com.example.stan_mode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.stan_mode.databinding.ActivityMainBinding;
import com.example.stan_mode.ui.GirlFragment;
import com.example.stan_mode.ui.HomeFragment;
import com.example.stan_mode.ui.ManFragment;
import com.example.stan_mode.ui.WomanFragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacementFragement(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replacementFragement(new HomeFragment());
                return true;
            } else if (itemId == R.id.woman) {
                replacementFragement(new WomanFragment());
                return true;
            } else if (itemId == R.id.child) {
                replacementFragement(new GirlFragment());
                return true;
            } else if (itemId == R.id.men) {
                replacementFragement(new ManFragment());
                return true;
            }
            return false;
        });


    }
private void replacementFragement(Fragment fragment) {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.frame_layout, fragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();

}
}
