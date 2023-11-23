package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import ApositiveAdapter.ApositiveAdapter;
import ApositiveModel.ApositiveModel;
import BpositiveAdapter.BpositiveAdapter;
import BpositiveModel.BpositiveModel;

public class Bpositive extends AppCompatActivity {
    RecyclerView recyclerView_bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpositive);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        recyclerView_bp=findViewById(R.id.bpositiveRecylerview);
        ArrayList<BpositiveModel> list=new ArrayList<>();


        list.add(new BpositiveModel ("ALIF BLOOD BANK & TRANSFUSION CENTER"," 44/11, West Panthapath ,Dhaka"));
        list.add(new BpositiveModel ("BADHAN BLOOD BANKCENTER","Central Office, T.S.C(Ground Floor), Dhaka-1000"));
        list.add(new BpositiveModel ("BANGLADESH RED CRESCENT BLOOD BANK","7/5, Aurongzeb Road, Mohammadpur, Dhaka."));
        list.add(new BpositiveModel("ISLAMI BANK HOSPITAL BLOOD BANK","30, VIP Road, Kakrail Dhaka-1000"));
        list.add(new  BpositiveModel ("NEW BANGLADESH PATHOLOGY & BLOOD BANK"," House-69,Road-9/A,Dhanmondi-R/A,Dhaka-1209."));
        list.add(new  BpositiveModel ("ORIENTAL BLOOD BANK","Green Center, 2B/30, Green Road, Dhanmondi, Dhaka"));
        list.add(new BpositiveModel ("POLICE BLOOD BANK","Central Police Hospital, Rajarbag, Dhaka."));
        list.add(new BpositiveModel ("QUANTUM BLOOD BANK","Shantinagar, Dhaka"));
        list.add(new BpositiveModel ("SHANDHANI, DHAKA DENTAL COLLEGE BRANCH","Dhaka Dental College Branch, Mirpur-14, Dhaka"));
        list.add(new BpositiveModel ("THALASSEMIA BLOOD BANK","30 Chamelibag, 1st Lane, Dhaka 1217"));
        list.add(new BpositiveModel ("Sandhani (Central)"," BSMMU, Shahabag, Dhaka – 1000"));
        list.add(new BpositiveModel ("Bangladesh Blood Bank And Transfusion Center","Holding no-22/12,Mohammadpur, Dhaka"));
        list.add(new BpositiveModel ("Islamia Digital Lab And Hospital","North Side of Pakiza Mills, Savar, Dhaka"));
        list.add(new BpositiveModel ("Holy Family Red Crescent Medical College And Hospital","Road-Eskaton Garden Road, Moghbazar, Dhaka"));
        list.add(new BpositiveModel ("Famous Blood Bank And Diagnostic Center"," Road-Humayan Road, College Gate, Dhaka"));
        list.add(new BpositiveModel ("The Diagnosis Blood Bank And Pathology"," Lake Circus, Dhaka"));
        list.add(new BpositiveModel ("Savar Central Hospital Limited","Savar Thana, Dhaka"));








        list.add(new BpositiveModel ("ALIF BLOOD BANK & TRANSFUSION CENTER"," 44/11, West Panthapath ,Dhaka"));
        list.add(new BpositiveModel ("BADHAN BLOOD BANKCENTER","Central Office, T.S.C(Ground Floor), Dhaka-1000"));
        list.add(new BpositiveModel ("BANGLADESH RED CRESCENT BLOOD BANK","7/5, Aurongzeb Road, Mohammadpur, Dhaka."));
        list.add(new BpositiveModel("ISLAMI BANK HOSPITAL BLOOD BANK","30, VIP Road, Kakrail Dhaka-1000"));
        list.add(new  BpositiveModel ("NEW BANGLADESH PATHOLOGY & BLOOD BANK"," House-69,Road-9/A,Dhanmondi-R/A,Dhaka-1209."));
        list.add(new  BpositiveModel ("ORIENTAL BLOOD BANK","Green Center, 2B/30, Green Road, Dhanmondi, Dhaka"));
        list.add(new BpositiveModel ("POLICE BLOOD BANK","Central Police Hospital, Rajarbag, Dhaka."));
        list.add(new BpositiveModel ("QUANTUM BLOOD BANK","Shantinagar, Dhaka"));
        list.add(new BpositiveModel ("SHANDHANI, DHAKA DENTAL COLLEGE BRANCH","Dhaka Dental College Branch, Mirpur-14, Dhaka"));
        list.add(new BpositiveModel ("THALASSEMIA BLOOD BANK","30 Chamelibag, 1st Lane, Dhaka 1217"));
        list.add(new BpositiveModel ("Sandhani (Central)"," BSMMU, Shahabag, Dhaka – 1000"));
        list.add(new BpositiveModel ("Bangladesh Blood Bank And Transfusion Center","Holding no-22/12,Mohammadpur, Dhaka"));
        list.add(new BpositiveModel ("Islamia Digital Lab And Hospital","North Side of Pakiza Mills, Savar, Dhaka"));
        list.add(new BpositiveModel ("Holy Family Red Crescent Medical College And Hospital","Road-Eskaton Garden Road, Moghbazar, Dhaka"));
        list.add(new BpositiveModel ("Famous Blood Bank And Diagnostic Center"," Road-Humayan Road, College Gate, Dhaka"));
        list.add(new BpositiveModel ("The Diagnosis Blood Bank And Pathology"," Lake Circus, Dhaka"));
        list.add(new BpositiveModel ("Savar Central Hospital Limited","Savar Thana, Dhaka"));













        BpositiveAdapter adepter=new BpositiveAdapter( list,this);

        recyclerView_bp.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_bp.setLayoutManager(layoutManager);
    }
}