package com.example.rentagym.Seller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.R;
import com.example.rentagym.MenuOption.Setting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Seller_Login extends AppCompatActivity
{
    Button seller_login_register, seller_login_login;
    EditText seller_login_username, seller_login_password;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        //firebase helpers
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        seller_login_username = (EditText)findViewById(R.id.seller_login_username);
        seller_login_password = (EditText)findViewById(R.id.seller_login_password);
        seller_login_login = (Button)findViewById(R.id.seller_login_login);
        seller_login_register = (Button)findViewById(R.id.seller_login_register);

        //set listener for register button
        seller_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.rentagym.Seller.Seller_Login.this, Seller_Register.class);
                startActivity(intent);
            }
        });

        //set listener for login button
        seller_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = seller_login_username.getText().toString();
                String password = seller_login_password.getText().toString();

                //Sign in With Firebase Auth using email and password
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(com.example.rentagym.Seller.Seller_Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //If correct go to seller page
                                    Intent intent = new Intent(com.example.rentagym.Seller.Seller_Login.this, SellerActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(com.example.rentagym.Seller.Seller_Login.this, "Authentication Success.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    //If they dont login correctly add a toast message that lets the user know the attempt
                                    Toast.makeText(com.example.rentagym.Seller.Seller_Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });


    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //Executing Menu option items
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.Item1:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Item2:
                Toast.makeText(this, "Google maps", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Seller_Login.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(Seller_Login.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Seller_Login.this, Setting.class);
                startActivity(i);
                return true;
            case R.id.Item5:
                Toast.makeText(this, "Exit: Closing Application", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

