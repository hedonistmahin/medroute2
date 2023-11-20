package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import ICUadapter.ICUadapter;
import ICUmodel.ICUmodel;

public class ICU extends AppCompatActivity {


    RecyclerView recyclerView_icu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icu);
        recyclerView_icu = findViewById(R.id.icuRecylarview_1);
        ArrayList<ICUmodel> list=new ArrayList<>();
        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new ICUmodel(R.drawable.japan, "Japan Bangladesh Friendship Hospital"));
        list.add(new ICUmodel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new ICUmodel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new ICUmodel(R.drawable.popular, "Popular Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new ICUmodel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new ICUmodel(R.drawable.ma, "Chattogram Maa O Shishu Hospital Medical College"));
        list.add(new ICUmodel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new ICUmodel(R.drawable.lch, "Labaid Cardiac Hospital "));
        list.add(new ICUmodel(R.drawable.labaed, "Labaid Specialized Hospital"));
        list.add(new ICUmodel(R.drawable.anowr, "Anwer Khan Modern Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new ICUmodel(R.drawable.united, "United Hospital Limited."));

        list.add(new ICUmodel(R.drawable.kurmi,"Kurmitola General Hospital" ));
        list.add(new ICUmodel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));








        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new ICUmodel(R.drawable.japan, "Japan Bangladesh Friendship Hospital"));
        list.add(new ICUmodel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new ICUmodel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new ICUmodel(R.drawable.popular, "Popular Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.smch, "Shaheed Suhrawardy Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new ICUmodel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new ICUmodel(R.drawable.ma, "Chattogram Maa O Shishu Hospital Medical College"));
        list.add(new ICUmodel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new ICUmodel(R.drawable.lch, "Labaid Cardiac Hospital "));
        list.add(new ICUmodel(R.drawable.labaed, "Labaid Specialized Hospital"));
        list.add(new ICUmodel(R.drawable.anowr, "Anwer Khan Modern Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new ICUmodel(R.drawable.united, "United Hospital Limited."));

        list.add(new ICUmodel(R.drawable.kurmi,"Kurmitola General Hospital" ));
        list.add(new ICUmodel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));







        ICUadapter adepter=new ICUadapter( list,this);

        recyclerView_icu.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_icu.setLayoutManager(layoutManager);
    }
}