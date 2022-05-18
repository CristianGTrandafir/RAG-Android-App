package com.example.rentagym.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagym.MainActivity;
import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.R;
import com.example.rentagym.MenuOption.Setting;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Customer_GridItem extends AppCompatActivity
{
    TextView gridData;
    TextView gridPrice;
    TextView sellername;
    TextView sellerAddress;
    TextView sellerPhone;
    ImageView imageView;
    Button bCustomerChat;
    Button bCustomerChatAi;
    private DatabaseReference mDatabase;
    private DatabaseReference roomRef;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_griditem);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        roomRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        bCustomerChat = findViewById(R.id.bCustomerChat);
        bCustomerChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seller = sellername.getText().toString().substring(14,sellername.length());
                String sells = seller.substring(0, seller.indexOf('@') ).toLowerCase();
                roomRef.child("chatRooms").addValueEventListener(new ValueEventListener() {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String seller = sellername.getText().toString().substring(14,sellername.length());
                    String sell = seller.substring(0, seller.indexOf('@') ).toLowerCase();

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(!snapshot.child(sell).exists()){
                            ChatRoom newRoom = new ChatRoom(new ChatMessage("someUser", "Temp"), user.getEmail(), seller);
                            mDatabase.child("chatRooms").child(sell).setValue(newRoom);
                        }
                        else{

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Intent intent = new Intent(Customer_GridItem.this, Customer_Chat.class);
                intent.putExtra("message", sells);
                startActivity(intent);
            }
        });
        bCustomerChatAi = findViewById(R.id.bCustomerChatai);
        bCustomerChatAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_GridItem.this, Customer_ChatAI.class);
                startActivity(intent);
            }
        });
        gridData = findViewById(R.id.griddata);
        gridPrice = findViewById(R.id.gridprice);
        sellername = findViewById(R.id.gridsellername);
        sellerAddress = findViewById(R.id.gridselleraddress);
        sellerPhone = findViewById(R.id.gridsellerphone);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        String receivedPrice = intent.getStringExtra("price");
        String receivedSellerName = intent.getStringExtra("sellername");
        String receivedSellerAddress = intent.getStringExtra("sellerAddress");
        String receivedSellerPhone = intent.getStringExtra("sellerPhone");
        int receivedImage = intent.getIntExtra("image",0);

        gridData.setText(receivedName);
        gridPrice.setText(receivedPrice);
        sellername.setText(receivedSellerName);
        sellerAddress.setText(receivedSellerAddress);
        sellerPhone.setText(receivedSellerPhone);
        imageView.setImageResource(receivedImage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                Intent intent = new Intent(Customer_GridItem.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(Customer_GridItem.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Customer_GridItem.this, Setting.class);
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
