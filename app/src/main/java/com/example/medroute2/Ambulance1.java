package com.example.medroute2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import AmbulanceAdapter.AmbulanceAdapter;
import AmbulanceModel.AmbulanceModel;

public class Ambulance1 extends AppCompatActivity {
    RecyclerView recyclerView_ambulance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        recyclerView_ambulance=findViewById(R.id.ambulanceRecylarview);
        ArrayList<AmbulanceModel> list=new ArrayList<>();
        list.add(new AmbulanceModel ("Shotota ambulance service(Islami bank)","01728-215630 "));
        list.add(new AmbulanceModel ("Ibne Sina ambulance service  ","01911707189"));
        list.add(new AmbulanceModel ("Ambulance Bd 24","01919339689"));
        list.add(new AmbulanceModel ("Shondhani ","01682683811 "));
        list.add(new AmbulanceModel ("Ad-Deen ambulance Service ","88 02 7276032"));
        list.add(new AmbulanceModel ("Signboard Ambulance Service","01791-118502 "));
        list.add(new AmbulanceModel ("Lamia ambulance Service )","9130800-19  "));
        list.add(new AmbulanceModel ("Ural ambulance Service","01969906555 "));
        list.add(new AmbulanceModel ("Rejent ambulance Service ","01728215630 "));
        list.add(new AmbulanceModel ("Al amin ambulance Service nk)","0172-0448666 "));
        list.add(new AmbulanceModel ("Abir ambulance Servic","01921-189289 "));
        list.add(new AmbulanceModel ("","01787-665907"));
        list.add(new AmbulanceModel ("Al sakib ambulance Service ","01711-060025"));
        list.add(new AmbulanceModel ("AR ambulance Service  ","01876-213338 "));
        list.add(new AmbulanceModel ("Bashar ambulance Service  ","01719-570876   "));
        list.add(new AmbulanceModel ("Best Care ambulance Service","01911-008118  "));
        list.add(new AmbulanceModel ("Dabir ambulance Service ","01716-523576 "));
        list.add(new AmbulanceModel ("Abdul ambulance service ","01724-464422  "));
        list.add(new AmbulanceModel ("Ad-Deen Hospital ambulance service ","0961-2345666 "));
        list.add(new AmbulanceModel ("Care hospital ambulance service ","01733-588337  "));
        list.add(new AmbulanceModel ("Sikandar ambulance servic ","01611-512616"));
        list.add(new AmbulanceModel ("atrabari ambulance service","01871-677962"));
        list.add(new AmbulanceModel ("Air Ambulance service","019770485470  "));
        list.add(new AmbulanceModel ("New Bangladesh Ambulance Servicee ","01675-934778 "));


        list.add(new AmbulanceModel ("F Rahman Ambulance Service ","01718-210413   "));
        list.add(new AmbulanceModel ("Life Friend Ambulance Service ","01821-884669  "));
        list.add(new AmbulanceModel ("Ambulence service limited","01821-884669 "));
        list.add(new AmbulanceModel ("Trust Ambulance Service ","01712-244294  "));
        list.add(new AmbulanceModel ("•Ambulance service","01716-500074 "));
        list.add(new AmbulanceModel ("Narayanganj Ambulance Service","01783-631253 "));
        list.add(new AmbulanceModel ("Mirpur Ambulance service","01785-906599"));
        list.add(new AmbulanceModel ("Ambulance Service in Dhaka BD","01775-969157 "));
        list.add(new AmbulanceModel ("Alorpathe ambulance service","01726-732808"));
        list.add(new AmbulanceModel ("ICU Ambulance Gulshan","01993-700900"));
        list.add(new AmbulanceModel ("Freezing Ambulance Service","01786-433932"));
        list.add(new AmbulanceModel ("Lam Alif Ambulance Service","01962-108855 "));
        list.add(new AmbulanceModel ("ICU ambulance service","01318-553121"));
















        AmbulanceAdapter adepter=new AmbulanceAdapter( list,this);

        recyclerView_ambulance.setAdapter(adepter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView_ambulance.setLayoutManager(layoutManager);


    }
}