package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import BnegativeAdapter.BnegativeAdapter;
import BnegativeModel.BnegativeModel;
import BpositiveAdapter.BpositiveAdapter;
import BpositiveModel.BpositiveModel;

public class Bnegative extends AppCompatActivity {
    RecyclerView recyclerView_bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnegative);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        recyclerView_bn=findViewById(R.id.b_neagtiveRecylerview);
        ArrayList<BnegativeModel> list=new ArrayList<>();


        list.add(new BnegativeModel ("ALIF BLOOD BANK & TRANSFUSION CENTER"," 44/11, West Panthapath ,Dhaka"));
        list.add(new BnegativeModel ("BADHAN BLOOD BANKCENTER","Central Office, T.S.C(Ground Floor), Dhaka-1000"));
        list.add(new BnegativeModel ("BANGLADESH RED CRESCENT BLOOD BANK","7/5, Aurongzeb Road, Mohammadpur, Dhaka."));
        list.add(new BnegativeModel("ISLAMI BANK HOSPITAL BLOOD BANK","30, VIP Road, Kakrail Dhaka-1000"));
        list.add(new  BnegativeModel ("NEW BANGLADESH PATHOLOGY & BLOOD BANK"," House-69,Road-9/A,Dhanmondi-R/A,Dhaka-1209."));
        list.add(new  BnegativeModel("ORIENTAL BLOOD BANK","Green Center, 2B/30, Green Road, Dhanmondi, Dhaka"));
        list.add(new BnegativeModel("POLICE BLOOD BANK","Central Police Hospital, Rajarbag, Dhaka."));
        list.add(new BnegativeModel ("QUANTUM BLOOD BANK","Shantinagar, Dhaka"));
        list.add(new BnegativeModel("SHANDHANI, DHAKA DENTAL COLLEGE BRANCH","Dhaka Dental College Branch, Mirpur-14, Dhaka"));
        list.add(new BnegativeModel ("THALASSEMIA BLOOD BANK","30 Chamelibag, 1st Lane, Dhaka 1217"));
        list.add(new BnegativeModel("Sandhani (Central)"," BSMMU, Shahabag, Dhaka – 1000"));
        list.add(new BnegativeModel ("Bangladesh Blood Bank And Transfusion Center","Holding no-22/12,Mohammadpur, Dhaka"));
        list.add(new BnegativeModel("Islamia Digital Lab And Hospital","North Side of Pakiza Mills, Savar, Dhaka"));
        list.add(new BnegativeModel ("Holy Family Red Crescent Medical College And Hospital","Road-Eskaton Garden Road, Moghbazar, Dhaka"));
        list.add(new BnegativeModel ("Famous Blood Bank And Diagnostic Center"," Road-Humayan Road, College Gate, Dhaka"));
        list.add(new BnegativeModel ("The Diagnosis Blood Bank And Pathology"," Lake Circus, Dhaka"));
        list.add(new BnegativeModel("Savar Central Hospital Limited","Savar Thana, Dhaka"));





        list.add(new  BnegativeModel("ORIENTAL BLOOD BANK","Green Center, 2B/30, Green Road, Dhanmondi, Dhaka"));
        list.add(new BnegativeModel("POLICE BLOOD BANK","Central Police Hospital, Rajarbag, Dhaka."));
        list.add(new BnegativeModel ("QUANTUM BLOOD BANK","Shantinagar, Dhaka"));
        list.add(new BnegativeModel("SHANDHANI, DHAKA DENTAL COLLEGE BRANCH","Dhaka Dental College Branch, Mirpur-14, Dhaka"));
        list.add(new BnegativeModel ("THALASSEMIA BLOOD BANK","30 Chamelibag, 1st Lane, Dhaka 1217"));
        list.add(new BnegativeModel("Sandhani (Central)"," BSMMU, Shahabag, Dhaka – 1000"));
        list.add(new BnegativeModel ("Bangladesh Blood Bank And Transfusion Center","Holding no-22/12,Mohammadpur, Dhaka"));
        list.add(new BnegativeModel("Islamia Digital Lab And Hospital","North Side of Pakiza Mills, Savar, Dhaka"));
        list.add(new BnegativeModel ("Holy Family Red Crescent Medical College And Hospital","Road-Eskaton Garden Road, Moghbazar, Dhaka"));
        list.add(new BnegativeModel ("Famous Blood Bank And Diagnostic Center"," Road-Humayan Road, College Gate, Dhaka"));
        list.add(new BnegativeModel ("The Diagnosis Blood Bank And Pathology"," Lake Circus, Dhaka"));
        list.add(new BnegativeModel("Savar Central Hospital Limited","Savar Thana, Dhaka"));


        list.add(new BnegativeModel ("ALIF BLOOD BANK & TRANSFUSION CENTER"," 44/11, West Panthapath ,Dhaka"));
        list.add(new BnegativeModel ("BADHAN BLOOD BANKCENTER","Central Office, T.S.C(Ground Floor), Dhaka-1000"));
        list.add(new BnegativeModel ("BANGLADESH RED CRESCENT BLOOD BANK","7/5, Aurongzeb Road, Mohammadpur, Dhaka."));
        list.add(new BnegativeModel("ISLAMI BANK HOSPITAL BLOOD BANK","30, VIP Road, Kakrail Dhaka-1000"));
        list.add(new  BnegativeModel ("NEW BANGLADESH PATHOLOGY & BLOOD BANK"," House-69,Road-9/A,Dhanmondi-R/A,Dhaka-1209."));
        list.add(new  BnegativeModel("ORIENTAL BLOOD BANK","Green Center, 2B/30, Green Road, Dhanmondi, Dhaka"));
        list.add(new BnegativeModel("POLICE BLOOD BANK","Central Police Hospital, Rajarbag, Dhaka."));





        BnegativeAdapter adepter=new BnegativeAdapter( list,this);

        recyclerView_bn.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_bn.setLayoutManager(layoutManager);












    }
}