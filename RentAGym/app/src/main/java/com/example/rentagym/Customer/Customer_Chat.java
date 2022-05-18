package com.example.rentagym.Customer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentagym.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Customer_Chat extends AppCompatActivity
{
    private DatabaseReference mDatabase;
// ...

    private ArrayAdapter<String> chatValues;
    private FirebaseAuth mAuth;

    Button send;
    TextView text;

    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    ArrayList<ChatMessage> messages;
    String seller;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_chat);
        Bundle bundle = getIntent().getExtras();
        seller = bundle.getString("message");

        mAuth = FirebaseAuth.getInstance();

        send = (Button)findViewById(R.id.sendMessage);
        text = (TextView)findViewById(R.id.textMessage);
        FirebaseUser user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("chatRooms/" + seller + "/messages");

        recyclerView = findViewById(R.id.messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        messages = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messages);
        recyclerView.setAdapter(messageAdapter);
        mDatabase.addValueEventListener(new ValueEventListener() {

            //When a firebase is updated add the element to the array list and update recycler view
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messages.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    //get new data from firebase
                    String mess = dataSnapshot.child("message").getValue(String.class);
                    String user = dataSnapshot.child("fromUser").getValue(String.class);

                    ChatMessage cM = new ChatMessage(user, mess);
                    messages.add(cM);

                }
                messageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //set the listener for send message
        send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference();
                FirebaseUser user = mAuth.getCurrentUser();
                ChatMessage chatMessage = new ChatMessage(user.getEmail(), text.getText().toString());
                mDatabase.child("chatRooms").child(seller).child("messages").push().setValue(chatMessage);
                text.setText("");
            }
        });

    }


}
