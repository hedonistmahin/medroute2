package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import BedAdapter.BedAdapter;
import BedModel.BedModel;


public class Bed extends AppCompatActivity {
RecyclerView recyclerView_bed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }
          recyclerView_bed=findViewById(R.id.bedRecylerview);

        ArrayList<BedModel> list=new ArrayList<>();
        list.add(new BedModel (R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new BedModel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new BedModel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new BedModel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new BedModel(R.drawable.japan, "Japan Bangladesh Friendship Hospital"));
        list.add(new BedModel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new BedModel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new BedModel(R.drawable.popular, "Popular Medical College Hospital"));
        list.add(new BedModel(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital"));
        list.add(new BedModel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new BedModel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new BedModel(R.drawable.ma, "Chattogram Maa O Shishu HospitalModel.Hospital Medical College"));
        list.add(new BedModel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new BedModel(R.drawable.lch, "Labaid Cardiac Hospitale"));
        list.add(new BedModel(R.drawable.labaed, "Labaid Specialized Hospital"));
        list.add(new BedModel (R.drawable.anowr, "Anwer Khan Modern Medical College Hospital"));
        list.add(new BedModel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new BedModel(R.drawable.united, "United Hospital"));

        list.add(new BedModel(R.drawable.kurmi,"Kurmitola General Hospital" ));
        list.add(new BedModel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new BedModel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new BedModel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new BedModel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new BedModel(R.drawable.squre, "SQUARE HOSPITALS LTD"));







        list.add(new BedModel (R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new BedModel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new BedModel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new BedModel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new BedModel(R.drawable.japan, "Japan Bangladesh Friendship Hospital"));
        list.add(new BedModel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new BedModel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new BedModel(R.drawable.popular, "Popular Medical College Hospital"));
        list.add(new BedModel(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital"));
        list.add(new BedModel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new BedModel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new BedModel(R.drawable.ma, "Chattogram Maa O Shishu HospitalModel.Hospital Medical College"));
        list.add(new BedModel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new BedModel(R.drawable.lch, "Labaid Cardiac Hospitale"));
        list.add(new BedModel(R.drawable.labaed, "Labaid Specialized Hospital"));
        list.add(new BedModel (R.drawable.anowr, "Anwer Khan Modern Medical College Hospital"));
        list.add(new BedModel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new BedModel(R.drawable.united, "United Hospital"));

        list.add(new BedModel(R.drawable.kurmi,"Kurmitola General Hospital" ));
        list.add(new BedModel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new BedModel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new BedModel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new BedModel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new BedModel(R.drawable.squre, "SQUARE HOSPITALS LTD"));



        BedAdapter adepter=new BedAdapter( list,this);

        recyclerView_bed.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_bed.setLayoutManager(layoutManager);
    }
}