package com.metropolitan.vreme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 100;

 static DatabaseHelper baza;
 static double lat;
 static double lng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baza = new DatabaseHelper(this);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_FINE_LOCATION);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_FINE_LOCATION);
            }
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(new Criteria(), false);
        Location location = locationManager.getLastKnownLocation(provider);

        lat = location.getLatitude();
        lng = location.getLongitude();

        JsonVreme jsonVreme = new JsonVreme();
        jsonVreme.execute("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lng + "&appid=01156fa820c130d70c0bf49074c10b1a");

    }

    public void FragmentJedanClick(View view) {
        Fragment myfragment;
        myfragment = new Vreme();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, myfragment);
        fragmentTransaction.commit();

    }

    public void FragmentDvaClick(View view) {
        Fragment myfragment;
        myfragment = new PetDana();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, myfragment);
        fragmentTransaction.commit();

        JsonPetDana jsonPetDana = new JsonPetDana();
        jsonPetDana.execute("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lng + "&appid=01156fa820c130d70c0bf49074c10b1a");
    }
}
