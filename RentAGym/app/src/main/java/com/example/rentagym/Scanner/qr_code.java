package com.example.rentagym.Scanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagym.R;

public class qr_code extends AppCompatActivity
{
    Button bCustomer;
    Button bSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        bCustomer = findViewById(R.id.bCustomer1);
        bSeller = findViewById(R.id.bSeller2);
        bCustomer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(qr_code.this, Customer_QR_code.class);
                startActivity(intent);
            }
        });
        bSeller.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(qr_code.this, Seller_QR_Code.class);
                startActivity(intent);
            }
        });
    }
}
