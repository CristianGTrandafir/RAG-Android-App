package com.example.rentagym.MenuOption;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentagym.Customer.CustomerActivity;
import com.example.rentagym.MainActivity;
import com.example.rentagym.R;

import java.util.ArrayList;

public class Help extends AppCompatActivity
{
    ArrayList<HelperItem> helperList;
    RecyclerView mRecyclerView;
    HelperAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        helperList = new ArrayList<>();
        helperList.add(new HelperItem("What if the equipment I ordered is still not delivered?", "You might want to contact the seller and if you still don't get a reply then contact our customer service."));
        helperList.add(new HelperItem("What if I haven't received my payment and I have already shipped the product?", "If the transaction happened recently, please allow 4-5 business days for the payment to get transferred. If you still don't receive the payment then please contact the customer service."));
        helperList.add(new HelperItem("My customer's renting time expired and I still haven't heard back from them. What should I do?", "Please call us on our customer service number and a representative help you in the matter"));
        helperList.add(new HelperItem("Is the transaction safe?", "Rest assure, the transactions are only seen by the seller and customer and their associated banks. We take privacy very seriously."));
        helperList.add(new HelperItem("The Seller hasn't given me the code yet. What should I do?", "Use the chatting provided in the application itself and if you still don't get a reply then contact Customer Service."));
        helperList.add(new HelperItem("I forgot my account name. What should I do?", "Contact Customer Service and the representative will help you"));
        helperList.add(new HelperItem("I forgot my account password. What should I do?", "Contact Customer Service and the representative will help you"));
        helperList.add(new HelperItem("What if I am renting equipment and it gets damaged when I am using it.", "You will be held liable for the damages unless you were handed in an already damaged product in case you should contact customer service."));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new HelperAdapter(helperList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                filter(s.toString());
            }
        });

    }

    private void filter(String text)
    {
        ArrayList<HelperItem> filteredList = new ArrayList<>();

        for (HelperItem item : helperList)
        {
            if (item.getText1().toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
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
                Intent intent = new Intent(Help.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(Help.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Help.this, Setting.class);
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
