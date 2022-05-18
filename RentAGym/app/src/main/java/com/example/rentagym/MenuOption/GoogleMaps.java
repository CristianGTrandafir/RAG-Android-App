package com.example.rentagym.MenuOption;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagym.Customer.CustomerActivity;
import com.example.rentagym.MainActivity;
import com.example.rentagym.R;

public class GoogleMaps extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        startActivity(new Intent(Intent.ACTION_VIEW));
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
                Intent intent = new Intent(GoogleMaps.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(GoogleMaps.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(GoogleMaps.this, Setting.class);
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
