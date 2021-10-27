package com.example.finalotp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalotp.ui.register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginOwner extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText email;
    private EditText password;
    private Button btnReg;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_owner);

        firebaseAuth = FirebaseAuth.getInstance();

            if(firebaseAuth.getCurrentUser()!=null){
                finish();
                startActivity(new Intent(getApplicationContext(),directed.class));
            }
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);

        buttonSignIn = (Button) findViewById(R.id.buttonSignin);
        btnReg = (Button)findViewById(R.id.btnReg);

        progressDialog = new ProgressDialog(this);
        buttonSignIn.setOnClickListener(this);
        btnReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), register.class);

                startActivity(intent);
            }
        });
    }

    private void userLogin(){
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(mail,pass)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()){

                        startActivity(new Intent(getApplicationContext(),directed.class));
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        if(v == buttonSignIn){
            userLogin();
        }


    }
}
