package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class BloodBankPage extends AppCompatActivity {
RelativeLayout relativeLayout_AP;
    RelativeLayout relativeLayout_BP;
    RelativeLayout relativeLayout_ABP;
    RelativeLayout relativeLayout_OP;
    RelativeLayout relativeLayout_AN;
    RelativeLayout relativeLayout_ABN;
    RelativeLayout relativeLayout_ON;

    RelativeLayout relativeLayout_BN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_page);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }
        relativeLayout_AP=findViewById(R.id.apositive);
        relativeLayout_BP=findViewById(R.id.bpositive);
        relativeLayout_ABP=findViewById(R.id.abpositive);
        relativeLayout_OP=findViewById(R.id.opositive);
        relativeLayout_AN =findViewById(R.id.anegative);
        relativeLayout_BN=findViewById(R.id.bnegative);
        relativeLayout_ABN=findViewById(R.id.abnegative);
        relativeLayout_ON=findViewById(R.id.onegative);


        relativeLayout_ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_On=new Intent(BloodBankPage.this, Onegative.class);
                startActivity(intent_On);

            }
        });

        relativeLayout_ABN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_ABn=new Intent(BloodBankPage.this, ABnegative.class);
                startActivity(intent_ABn);

            }
        });




        relativeLayout_BN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_Bn=new Intent(BloodBankPage.this, Bnegative.class);
                startActivity(intent_Bn);

            }
        });

        relativeLayout_AN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_An=new Intent(BloodBankPage.this, Anegative.class);
                startActivity(intent_An);

            }
        });

        relativeLayout_OP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_Op=new Intent(BloodBankPage.this, Opositive.class);
                startActivity(intent_Op);

            }
        });



        relativeLayout_ABP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_Abp=new Intent(BloodBankPage.this, ABpositive.class);
                startActivity(intent_Abp);

            }
        });

        relativeLayout_BP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_bp=new Intent(BloodBankPage.this, Bpositive.class);
                startActivity(intent_bp);

            }
        });


        relativeLayout_AP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_ap=new Intent(BloodBankPage.this, Apositive.class);
                startActivity(intent_ap);
            }
        });






    }
}