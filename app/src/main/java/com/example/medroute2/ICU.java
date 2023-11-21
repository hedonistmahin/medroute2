package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import ICUadapter.ICUadapter;
import ICUmodel.ICUmodel;

public class ICU extends AppCompatActivity {


    RecyclerView recyclerView_icu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        recyclerView_icu = findViewById(R.id.icuRecylarview_1);
        ArrayList<ICUmodel> list=new ArrayList<>();
        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College HospitalModel.Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new ICUmodel(R.drawable.japan, "Japan Bangladesh Friendship HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new ICUmodel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new ICUmodel(R.drawable.popular, "Popular Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.smch, "Shaheed Suhrawardy Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new ICUmodel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new ICUmodel(R.drawable.ma, "Chattogram Maa O Shishu HospitalModel.Hospital Medical College"));
        list.add(new ICUmodel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new ICUmodel(R.drawable.lch, "Labaid Cardiac HospitalModel.Hospital "));
        list.add(new ICUmodel(R.drawable.labaed, "Labaid Specialized HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.anowr, "Anwer Khan Modern Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new ICUmodel(R.drawable.united, "United HospitalModel.Hospital Limited."));

        list.add(new ICUmodel(R.drawable.kurmi,"Kurmitola General HospitalModel.Hospital" ));
        list.add(new ICUmodel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College HospitalModel.Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));








        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College HospitalModel.Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));

        list.add(new ICUmodel(R.drawable.japan, "Japan Bangladesh Friendship HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.bsmmu, "Bangabandhu Sheikh Mujib Medical University "));
        list.add(new ICUmodel(R.drawable.birdem, "BIRDEM GENERAL HOSPITAL"));
        list.add(new ICUmodel(R.drawable.popular, "Popular Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.smch, "Shaheed Suhrawardy Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.evercare, "Evercare Hospitals Bangladesh"));
        list.add(new ICUmodel(R.drawable.brb, "BRB Hospitals Limited"));
        list.add(new ICUmodel(R.drawable.ma, "Chattogram Maa O Shishu HospitalModel.Hospital Medical College"));
        list.add(new ICUmodel(R.drawable.rajshahi, "Rajshahi Medical College"));
        list.add(new ICUmodel(R.drawable.lch, "Labaid Cardiac HospitalModel.Hospital "));
        list.add(new ICUmodel(R.drawable.labaed, "Labaid Specialized HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.anowr, "Anwer Khan Modern Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.heard, "National Institute of Cardiovascular Diseases"));
        list.add(new ICUmodel(R.drawable.united, "United HospitalModel.Hospital Limited."));

        list.add(new ICUmodel(R.drawable.kurmi,"Kurmitola General HospitalModel.Hospital" ));
        list.add(new ICUmodel(R.drawable.nheard, "National Heart Foundation of Bangladesh"));

        list.add(new ICUmodel(R.drawable.dhaka, "Dhaka Medical College HospitalModel.Hospital"));
        list.add(new ICUmodel(R.drawable.cmc, "Chittagong Medical Collge"));

        list.add(new ICUmodel(R.drawable.islamic, "Islami Bank Medical College HospitalModel.Hospital"));

        list.add(new ICUmodel(R.drawable.squre, "SQUARE HOSPITALS LTD"));







        ICUadapter adepter=new ICUadapter( list,this);

        recyclerView_icu.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_icu.setLayoutManager(layoutManager);
    }
}