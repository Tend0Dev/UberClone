package com.valo.uberclone.providers;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GeoFireProvider {

    private DatabaseReference mDatabase;
    private GeoFire mGeofire;

    public GeoFireProvider(){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("active_drives");
        mGeofire = new GeoFire(mDatabase);
    }

    public void saveLocation(String idDriver, LatLng latLng){
        mGeofire.setLocation(idDriver, new GeoLocation(latLng.latitude, latLng.longitude));
    }

    public void removeLocation(String idDriver){
        mGeofire.removeLocation(idDriver);
    }

    public GeoQuery getActiveDrivers(LatLng currentLatLng){
        return mGeofire.queryAtLocation(new GeoLocation(currentLatLng.latitude, currentLatLng.longitude), 5);
    }
}