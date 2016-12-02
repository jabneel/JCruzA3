package com.example.mapsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    GoogleMap googleMap;
    MarkerOptions markerOptions;
    LatLng latLng = new LatLng(78.486671,17.385044);

    Marker marker;
    double lng = 78.486671;
    double lat = 17.385044;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.N01035243))
                    .getMap();
            marker = googleMap.addMarker(new MarkerOptions()
                    .title("Jabneel")
                    .position(latLng)
            );


            // Setting a click event handler for the map


                    new Thread(new Runnable() {
                        public void run(){

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    lng+=3;
                                    lat+=3;
                                    // Clears the previously touched position
                                    googleMap.clear();
                                    // Animating to the touched position
                                    //googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                                    // Creating a marker

                                    marker.setPosition(new LatLng(lat, lng));
                                }
                            });
                            pause15();
                        }
                    }).start();

        }
        catch (Exception ex){
            String a = ex.toString();
        }
    }

    public void pause15()
    {
        try{
            Thread.sleep(15);
        }
        catch(java.lang.InterruptedException ex){
            ex.printStackTrace();
        }


    }

}
