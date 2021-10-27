package com.example.finalotp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class directed extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directed);

        firebaseAuth = FirebaseAuth.getInstance();



        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,loginOwner.class));
        }
        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,loginOwner.class));
        }
    }
}