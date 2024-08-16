package com.valo.uberclone.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.valo.uberclone.R;
import com.valo.uberclone.activities.client.Register;
import com.valo.uberclone.activities.driver.RegisterDriverActivity;
import com.valo.uberclone.includes.MyToolbar;

public class SelectOptionActivity extends AppCompatActivity {

    Button mButtonGoToLogin;
    Button mButtonGoToRegister;
    SharedPreferences mPref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_option);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //        toolbar
        MyToolbar.show(this, "Seleccionar opcion", true);

        mButtonGoToLogin = findViewById(R.id.btnGoToLogin);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToLogin();
            }
        });
        mButtonGoToRegister = findViewById(R.id.btnGoToRegister);
        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);
    }

    public void goToLogin(){
        Intent intent = new Intent(SelectOptionActivity.this, LoginActivity.class );
        startActivity(intent);
    }

    public void goToRegister(){
        String typeUser = mPref.getString("user", "");

        if (typeUser .equals("client")){
            Intent intent = new Intent(SelectOptionActivity.this, Register.class );
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(SelectOptionActivity.this, RegisterDriverActivity.class );
            startActivity(intent);
        }
    }
}