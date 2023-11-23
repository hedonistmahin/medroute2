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
        hospitals.add(new Hospital(R.drawable.dhaka, "Dhaka Medical College Hospital", "Location: Secretariat Rd, Dhaka 1000\nContacts: +8801727001199"));
        hospitals.add(new Hospital(R.drawable.cmc, "Chittagong Medical Collge", "Location: 57 K.B. Fazlul Kader Rd, Chattogram 4203\nContacts: 02333360179"));
        hospitals.add(new Hospital(R.drawable.islamic, "Islami Bank Medical College Hospital", "Location: 30,vip road,Kakrail.\n" + "Contacts: 0181000016"));
        hospitals.add(new Hospital(R.drawable.squre, "SQUARE HOSPITALS LTD", "Location: 18F, Bir Uttam Qazi Nuruzzaman Sarak,\n" +
                "West Panthapath, Dhaka 1205\nContacts: (880-2) 8144400, 8142431"));
        hospitals.add(new Hospital(R.drawable.japan, "Japan Bangladesh Friendship Hospital", "Zigatola Bus Stand, 55 Satmasjid Road, Dhaka 1209\nContacts: +8801713443360"));
        hospitals.add(new Hospital(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University", "Location: Shahbag, Dhaka-1000\nContacts: +88 02 9661064"));
        hospitals.add(new Hospital(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL", "Location: 122 Kazi Nazrul Islam Ave,Dhaka\nContacts: 0241060479"));
        hospitals.add(new Hospital(R.drawable.popular, "Popular Medical College Hospital", "Location: House # 25, Road # 2, Dhanmondi\n" +
                "Dhaka - 1205, Bangladesh\nContacts: +8801727001199"));
        hospitals.add(new Hospital(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital", "Location: Sher-E-Bangla Nagar, Dhaka-1207\nContacts: 48116011"));
        hospitals.add(new Hospital(R.drawable.evercare, "Evercare Hospitals Bangladesh", "Location: Plot 81, Block-E, Bashundhara Rd, Dhaka 1229\nContacts: 02-55037242"));
        hospitals.add(new Hospital(R.drawable.brb, "BRB Hospitals Limited", "Location: 77/A Panthapath, Dhaka 1215\nContacts: ++2222 40300,2222 42540,2222 41441"));
        hospitals.add(new Hospital(R.drawable.ma, "Chattogram Maa O Shishu Hospital Medical College", "Location: Agrabad, Chattogram 4100, Bangladesh\nContacts: 880-31- 711236; 718521; 718525; 02333320063; 02333331457"));
        hospitals.add(new Hospital(R.drawable.rajshahi, "Rajshahi Medical College", "Location: Medical College Road, Laxmipur\n" +
                "Rajpara, Rajshahi-6100\nContacts: 02588857150"));
        hospitals.add(new Hospital(R.drawable.lch, "Labaid Cardiac Hospital", "Location: Address: House- 01 &amp; 03, Road-04, Dhanmondi Dhaka-1205, Bangladesh\nContacts: +88 0241060908-18 , +88 02 58610793-8 "));
        hospitals.add(new Hospital(R.drawable.labaed, "Labaid Specialized Hospital", "Location: House- 06, Road-04, Dhanmondi, Dhaka 1205, Bangladesh.\nContacts: +88 02 58610793-8, +88 0241060908-18 "));
        hospitals.add(new Hospital(R.drawable.anowr, "Anwer Khan Modern Medical College Hospital", "House# 17 &amp; 17/1, Road# 8, Dhanmondi, Dhaka-1205.\nContacts: 10652, 09678010652"));
        hospitals.add(new Hospital(R.drawable.heard, "National Institute of Cardiovascular Diseases", "Location: National Institute of Cardiovascular Diseases, Sher-e-Bangla Nagar, Dhaka-1207, Bangladesh\nContacts: 88-02-9122560-74"));
        hospitals.add(new Hospital(R.drawable.united, "United Hospital Limited", "Location: UNITED HOSPITAL LIMITED. Plot 15, Road 71, Gulshan, Dhaka 1212\nContacts: +88 02 8836444, +88 02 8836000"));
        hospitals.add(new Hospital(R.drawable.kurmi, "Kurmitola General Hospital", "Location: New Airport Road, Kurmitola, Dhaka Cantonment, Dhaka-1206\nContacts: +8802 55062350 (For Emergency)\n" +
                "55062201, 55062349 (8am to 3pm)\n"));
        hospitals.add(new Hospital(R.drawable.nheard, "National Heart Foundation of Bangladesh", "Location: Plot-7/2, Section-2, Mirpur, Dhaka-1216, Bangladesh\nContacts: +58054708-12"));
        hospitals.add(new Hospital(R.drawable.apollo, "Apollo hospital", "Location: Plot # 81, Block # E, Basundhara R/A, Dhaka – 1229, Bangladesh\nContacts: +880-2-8401661, 8845242, Cell: +880 1841276556"));

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
