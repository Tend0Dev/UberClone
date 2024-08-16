package com.valo.uberclone.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valo.uberclone.models.Driver;

public class DriverProvider {

    DatabaseReference mDatabases;

    public DriverProvider(){
        mDatabases = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers");
    }

    public Task<Void> create(Driver driver) {
        return mDatabases.child(driver.getId()).setValue(driver);
    }
}
