package com.example.rentagym.Seller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.rentagym.Customer.Customer_Chat;
import com.example.rentagym.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SellerHomeFragment extends Fragment
{
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public SellerHomeFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_seller_home, container, false);
        // Inflate the layout for this fragment
        Button button = view.findViewById(R.id.goToChat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the current user
                FirebaseUser user = mAuth.getCurrentUser();
                String userEmail = user.getEmail();
                String newEmail = userEmail.substring(0, userEmail.indexOf("@"));
                Intent intent = new Intent(getActivity(), Customer_Chat.class);
                //pass the current user to chat interface
                intent.putExtra("message", newEmail);
                startActivity(intent);
            }
        });
        return view;
    }


}
