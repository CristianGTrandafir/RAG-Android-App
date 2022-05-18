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

import com.example.rentagym.Customer.User;
import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.R;
import com.example.rentagym.MenuOption.Setting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class Seller_Register extends AppCompatActivity
{

    private FirebaseAuth mAuth;
    EditText seller_username, seller_password, seller_cpassword;
    Button seller_register, seller_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_register);

        mAuth = FirebaseAuth.getInstance();

        seller_username = (EditText)findViewById(R.id.seller_username);
        seller_password = (EditText)findViewById(R.id.seller_password);
        seller_cpassword = (EditText)findViewById(R.id.seller_cpassword);
        seller_register = (Button)findViewById(R.id.seller_register);
        seller_login = (Button)findViewById(R.id.seller_login);

        //Set on click lister for login to go to the login page
        seller_login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(com.example.rentagym.Seller.Seller_Register.this, Seller_Login.class);
                startActivity(intent);
            }
        });

        //Set on click listener for the register page so the account can register
        seller_register.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String username = seller_username.getText().toString();
                String password = seller_password.getText().toString();
                String confirm_password = seller_password.getText().toString();

                //simple error checking for user input
                if (username.equals("") || password.equals("") || confirm_password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                } else {

                    if (password.equals(confirm_password)) {
                        //Create the user with their email and password
                        mAuth.createUserWithEmailAndPassword(username, password)
                                .addOnCompleteListener(com.example.rentagym.Seller.Seller_Register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // New user created and put into firebase
                                            User newUser = new User(username, "seller");
                                            FirebaseDatabase.getInstance().getReference("users").
                                                    child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                                                    setValue(newUser);
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            Toast.makeText(com.example.rentagym.Seller.Seller_Register.this, "Registration Success.",
                                                    Toast.LENGTH_SHORT).show();
                                            ;

                                        } else {
                                            // If registration fails then a toast message is given
                                            Toast.makeText(com.example.rentagym.Seller.Seller_Register.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                    }

                }
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
                Intent intent = new Intent(Seller_Register.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(Seller_Register.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Seller_Register.this, Setting.class);
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

