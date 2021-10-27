package com.example.finalotp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userRestaurant extends AppCompatActivity {

    Button customer;
    Button restaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_restaurant);

        customer=(Button)findViewById(R.id.customer);
        restaurant = (Button)findViewById(R.id.restaurant);

        customer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(userRestaurant.this, loginUser.class);

                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
               startActivity(new Intent(userRestaurant.this, loginOwner.class));


            }
        });
    }
}