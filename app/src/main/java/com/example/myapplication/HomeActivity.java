package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_home);

        fragmentManager = getSupportFragmentManager();

        // Set up bottom navigation
        ImageView homeIcon = findViewById(R.id.homeIcon);
        ImageView storesIcon = findViewById(R.id.storesIcon);
        ImageView insuranceIcon = findViewById(R.id.insuranceIcon);

      //  homeIcon.setOnClickListener(v -> replaceFragment(new HomeFragment()));
      //  storesIcon.setOnClickListener(v -> replaceFragment(new StoresFragment()));
      //  insuranceIcon.setOnClickListener(v -> replaceFragment(new InsuranceFragment()));

        // Set up Tree Management icons
        setupTreeManagementIcons();
    }

    private void setupTreeManagementIcons() {
        findViewById(R.id.toMobileNumber).setOnClickListener(v -> openTreeManagementFragment("Plant a tree..."));
        findViewById(R.id.toBankUPI).setOnClickListener(v -> openTreeManagementFragment("My trees"));
        findViewById(R.id.toSelfAccount1).setOnClickListener(v -> openTreeManagementFragment("Bookings"));
        findViewById(R.id.checkBankBalance1).setOnClickListener(v -> openTreeManagementFragment("Appointments"));
        findViewById(R.id.toMobileNumber1).setOnClickListener(v -> openTreeManagementFragment("My groups"));
        findViewById(R.id.toBankUPI1).setOnClickListener(v -> openTreeManagementFragment("Near nursery"));
        findViewById(R.id.toSelfAccount).setOnClickListener(v -> openTreeManagementFragment("Events"));
    }

    private void openTreeManagementFragment(String text) {
        Fragment fragment = TreeManagementFragment.newInstance(text);
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer1, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
