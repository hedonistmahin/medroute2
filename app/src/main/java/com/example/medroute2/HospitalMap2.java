

package com.example.medroute2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HospitalMap2 extends FragmentActivity implements OnMapReadyCallback {
    FusedLocationProviderClient fusedLocationClient;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 101;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_map2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.prime_color));
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        checkLocationPermission();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng[] hospitalLocations = {
                new LatLng(23.69250693784333, 90.48171661587175),
                new LatLng(23.739060781301664, 90.38218745642789),
                new LatLng(23.739060781301664, 90.38218745642789),
                new LatLng(23.739660124866482, 90.37514086174068),
                new LatLng(23.74540838800781, 90.37232314301923),
                new LatLng(23.750398497515132, 90.36981991957107),
                new LatLng(23.732293925962804, 90.43008729883567),
                new LatLng(23.726021989108176, 90.39757730701172),
                new LatLng(23.72589809440442, 90.405153632679),
                new LatLng(23.74648643749481, 90.38580401445982),
                new LatLng(23.75284234285185, 90.3815600001809),
                new LatLng(23.752251401637906, 90.38554844022612),
                new LatLng(23.75553019258006, 90.37615546461821),
                new LatLng(23.75167611589156, 90.36724907177462),
                new LatLng(23.751341331746453, 90.36885332664868),
                new LatLng(23.75400668740448, 90.36548934830127),
                new LatLng(23.73838741166644, 90.39536822777403),
                new LatLng(23.73214564398376, 90.40601586797465),
                new LatLng(23.711204992972473, 90.40125272701906),
                new LatLng(23.742142101491673, 90.38299358102404),
                new LatLng(23.62715638531866, 90.50768925983056),
                new LatLng(23.608786799850893, 90.50296648825112),
                new LatLng(23.82000840312233, 90.40945339011824),
                new LatLng(23.81573651787181, 90.39896954429325),
                new LatLng(23.810276504631556, 90.43132342321272),
                new LatLng(23.83588891308382, 90.45337826976771),
                new LatLng(23.804003230088433, 90.36193475843001),
                new LatLng(23.76925256760104, 90.3713720683034),
                new LatLng(23.752138778285488, 90.38499563303593),
                new LatLng(23.751626769042183, 90.385576227077),
                new LatLng(23.74345792854966, 90.38268227569958),
                new LatLng(23.738918039360215, 90.396412260722),
                new LatLng(23.69366927496729, 90.48413056697775),
                new LatLng(23.693482497141325, 90.46637152020882),
                new LatLng(23.69626002874646, 90.4662816232613),
                new LatLng(23.77615767318014, 90.41154649967696),
                new LatLng(23.777161884255083, 90.4100624201204)

        };


        for (LatLng location : hospitalLocations) {
            mMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title("Hospital")
                    .icon(bitmapDescriptor(getApplicationContext(), R.drawable.h33)));
        }

        checkLocationPermission();
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            enableMyLocation();
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);

                FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(this, location -> {
                            if (location != null) {
                                LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                                mMap.addMarker(new MarkerOptions()
                                        .position(currentLatLng)
                                        .title("Your Location")
                                        .icon(bitmapDescriptor(getApplicationContext(), R.drawable.baseline_person_pin_circle_24)));
                            }
                        });
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private BitmapDescriptor bitmapDescriptor(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
