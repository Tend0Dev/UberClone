package com.valo.uberclone.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valo.uberclone.models.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientProvider {

    DatabaseReference mDatabases;

    public ClientProvider(){
        mDatabases = FirebaseDatabase.getInstance().getReference().child("Users").child("Clients");
    }

    public Task<Void> create(Client client){
        Map<String, Object> map = new HashMap<>();
        map.put("name", client.getName());
        map.put("email", client.getEmail());
        return mDatabases.child(client.getId()).setValue(map);


    }
}
