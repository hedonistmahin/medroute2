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

public class Pharmacy extends FragmentActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 101;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);

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

        LatLng[] pharmacyLocations = {


                new LatLng(23.750557691714043, 90.36811922174255),
                new LatLng(23.750242551227643, 90.36830319482856),
                new LatLng(23.74993614053987, 90.36900111811975),
                new LatLng(23.749971125109635, 90.36907286720822),
                new LatLng(23.749804681138926, 90.36915745582296),
                new LatLng(23.750357643955862, 90.36983236669529),
                new LatLng(23.745761210633958, 90.37144864908389),
                new LatLng(23.745458921587858, 90.37167718167386),
                new LatLng(23.746987411451027, 90.37315273323668),
                new LatLng(23.74435682655893, 90.37287596146544),
                new LatLng(23.73960665153087, 90.37153351585351),
                new LatLng(23.739033751644577, 90.37234382943726),
                new LatLng(23.738934447666555, 90.3724868735202),
                new LatLng(23.73888464280275, 90.37516813550899),
                new LatLng(23.73907957678209, 90.37591130006098),
                new LatLng(23.738951289250707, 90.37532418965328),
                new LatLng(23.739158490431038, 90.37509381304461),
                new LatLng(23.74500798021567, 90.37175844422504),
                new LatLng(23.75546028858432, 90.37077281623115),
                new LatLng(23.755407008405513, 90.36895147058146),
                new LatLng(23.758682413850902, 90.35947547758894),
                new LatLng(23.758936763529224, 90.35980036015584),
                new LatLng(23.75906390103952, 90.3593710656315),
                new LatLng(23.75926583320196, 90.35926727111419),
                new LatLng(23.74637703767442, 90.3650554470926),
                new LatLng(23.749429785206694, 90.36363260819549),
                new LatLng(23.749704599029574, 90.36341358906557),
                new LatLng(23.744763276140713, 90.38980872915275),
                new LatLng(23.737998681324555, 90.38397024850335),
                new LatLng(23.738446309322747, 90.38332471623056),
                new LatLng(23.739540589873457, 90.38244407157381),
                new LatLng(23.739521484928005, 90.38218389729938),
                new LatLng(23.739114731900827, 90.38208197336172),
                new LatLng(23.692487633084816, 90.47989962155908),
                new LatLng(23.692170138252816, 90.48119802026027),
                new LatLng(23.692139436427002, 90.481332088811),
                new LatLng(23.677354576374036, 90.4825439258502),
                new LatLng(23.677487874470117, 90.48300730888225),
                new LatLng(23.677437728791837, 90.48313201869807),
                new LatLng(23.67746192292299, 90.48346927720678),
                new LatLng(23.624181964407587, 90.5003262776785),
                new LatLng(23.624151477000616, 90.49982508177837),
                new LatLng(23.64386421261557, 90.49294358118406),
                new LatLng(23.643972783624935, 90.49279756843079),
                new LatLng(23.64370254606951, 90.49281462560378),
                new LatLng(23.64297759719023, 90.48846601041934),
                new LatLng(23.647372419018748, 90.48762745437557),
                new LatLng(23.64846454224792, 90.48751625697096),
                new LatLng(23.648532723068193, 90.48770736436386),

        };

        // Add pharmacy markers
        for (LatLng location : pharmacyLocations) {
            mMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title("Pharmacy")
                    .icon(bitmapDescriptor(getApplicationContext(), R.drawable.pharmacy__1_)));
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
                                        .icon(bitmapDescriptor(getApplicationContext(), R.drawable.baseline_person_pin_circle_24))); // Change the icon as per your icon for current location
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
