package com.example.rentagym.Seller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagym.Customer.CustomerActivity;
import com.example.rentagym.Customer.Customer_Chat;
import com.example.rentagym.MainActivity;
import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.R;
import com.example.rentagym.MenuOption.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SellerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    BottomNavigationView bottomNavigationView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    SellerHomeFragment firstFragment = new SellerHomeFragment();
    SellerProfileFragment secondFragment = new SellerProfileFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                return true;
        }
        return false;
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
                Intent intent = new Intent(SellerActivity.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(SellerActivity.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SellerActivity.this, Setting.class);
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
