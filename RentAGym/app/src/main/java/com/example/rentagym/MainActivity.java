package com.example.rentagym;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rentagym.Customer.Customer_Register;
import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.MenuOption.Setting;
import com.example.rentagym.Scanner.qr_code;
import com.example.rentagym.Seller.Seller_Register;
import com.example.rentagym.Workout.Workout_Login;

public class MainActivity extends AppCompatActivity
{
    Button bCustomer;
    Button bSeller;
    Button bQRCode;
    Button bWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Customer Button Action
        bCustomer = findViewById(R.id.bCustomer);
        bCustomer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Customer_Register.class);
                startActivity(intent);
            }
        });

        //Seller Button Action
        bSeller = (Button) findViewById(R.id.bSeller);
        bSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Seller_Register.class);
                startActivity(intent);
            }
        });

        //QR Code
        bQRCode = findViewById(R.id.bQRcode);
        bQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, qr_code.class);
                startActivity(intent);
            }
        });

        //Workout App
        bWorkout = findViewById(R.id.bWorkout);
        bWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Workout_Login.class);
                startActivity(intent);
            }
        });
    }

    //Menu Options
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
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.Item2:
                Toast.makeText(this, "Google maps", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(MainActivity.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Setting.class);
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