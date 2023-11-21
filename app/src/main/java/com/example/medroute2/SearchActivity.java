package com.example.medroute2;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import HopitalAdapter.HospitalAdapter;
import HospitalModel.Hospital;

public class SearchActivity extends Activity {

    private List<Hospital> hospitals;
    private HospitalAdapter hospitalAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.blackTransparent));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_search);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), dash_bord.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_search) {
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), user_profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });

        hospitals = new ArrayList<>();
        hospitals.add(new Hospital(R.drawable.dhaka, "Dhaka Medical College Hospital", "Information about Dhaka Medical College Hospital"));
        hospitals.add(new Hospital(R.drawable.cmc, "Chittagong Medical Collge", "Information about Chittagong Medical Collge"));
        hospitals.add(new Hospital(R.drawable.islamic, "Islami Bank Medical College Hospital", "Information about Islami Bank Medical College Hospital"));
        hospitals.add(new Hospital(R.drawable.squre, "SQUARE HOSPITALS LTD", "Information about SQUARE HOSPITALS LTD"));
        hospitals.add(new Hospital(R.drawable.japan, "Japan Bangladesh Friendship Hospital", "Information about Japan Bangladesh Friendship Hospital"));
        hospitals.add(new Hospital(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University", "Information about Bangabandhu Sheikh Mujib Medical University"));
        hospitals.add(new Hospital(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL", "Information about BIRDEM GENERAL HOSPITAL"));
        hospitals.add(new Hospital(R.drawable.popular, "Popular Medical College Hospital", "Information about Popular Medical College Hospital"));
        hospitals.add(new Hospital(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital", "Information about Shaheed Suhrawardy Medical College Hospital"));
        hospitals.add(new Hospital(R.drawable.evercare, "Evercare Hospitals Bangladesh", "Information about Evercare Hospitals Bangladesh"));
        hospitals.add(new Hospital(R.drawable.brb, "BRB Hospitals Limited", "Information about BRB Hospitals Limited"));
        hospitals.add(new Hospital(R.drawable.ma, "Chattogram Maa O Shishu Hospital Medical College", "Information about Chattogram Maa O Shishu Hospital Medical College"));
        hospitals.add(new Hospital(R.drawable.rajshahi, "Rajshahi Medical College", "Information about Rajshahi Medical College"));
        hospitals.add(new Hospital(R.drawable.lch, "Labaid Cardiac Hospital", "Information about Labaid Cardiac Hospital"));
        hospitals.add(new Hospital(R.drawable.labaed, "Labaid Specialized Hospital", "Information about Labaid Specialized Hospital"));
        hospitals.add(new Hospital(R.drawable.anowr, "Anwer Khan Modern Medical College Hospital", "Information about Anwer Khan Modern Medical College Hospital"));
        hospitals.add(new Hospital(R.drawable.heard, "National Institute of Cardiovascular Diseases", "Information about National Institute of Cardiovascular Diseases"));
        hospitals.add(new Hospital(R.drawable.united, "United Hospital Limited", "Information about United Hospital Limited"));
        hospitals.add(new Hospital(R.drawable.kurmi, "Kurmitola General Hospital", "Information about Kurmitola General Hospital"));
        hospitals.add(new Hospital(R.drawable.nheard, "National Heart Foundation of Bangladesh", "Information about National Heart Foundation of Bangladesh"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hospitalAdapter = new HospitalAdapter(hospitals);
        recyclerView.setAdapter(hospitalAdapter);

        hospitalAdapter.setOnItemClickListener(hospital -> showHospitalInfoDialog(hospital));

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                hospitalAdapter.filter(newText);
                return true;
            }
        });
    }

    private void showHospitalInfoDialog(Hospital hospital) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(hospital.getName())
                .setMessage(hospital.getInformation())
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

}
