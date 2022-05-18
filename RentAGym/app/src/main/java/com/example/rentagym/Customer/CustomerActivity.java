package com.example.rentagym.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.MainActivity;
import com.example.rentagym.R;
import com.example.rentagym.MenuOption.Setting;

public class CustomerActivity extends AppCompatActivity
{
    GridView gridView;

    String[] customerTitle =
    {
        "Treadmills",
        "Ellipticals",
        "Exercise Bike",
        "Dumbbell Set",
        "Functional Trainers",
        "Stretching Yoga",
        "Abs",
        "Plates",
        "Bars",
        "Upright Bikes",
        "Rowing Machines",
        "Flooring Mats"
    };

    String[] customerPrice =
    {
        "$1000",
        "$900",
        "$700",
        "$600",
        "$500",
        "$400",
        "$300",
        "$200",
        "$100",
        "$70",
        "$50",
        "$40",
    };

    String[] sellerName =
    {
            "Seller Email: martyg@gmail.com",
            "Seller Email: paulclark@yahoo.com",
            "Seller Email: amckenney@gmail.com",
            "Seller Email: ashleighSMcVay@gmail.com",
            "Seller Email: WilliamErwin@gmail.com",
            "Seller Email: CharlesBell@yahoo.com",
            "Seller Email: DanialRoss@gmail.com",
            "Seller Email: WillardS@gmail.com",
            "Seller Email: JohnMorries@gmail.com",
            "Seller Email: MelisaOjeda@gmail.com",
            "Seller Email: RafaelBlakeslee@gmail.com",
            "Seller Email: JessicaJackson@gmail.com"
    };

    String[] sellerAddress =
    {
         "Seller Address: 700 Vine Street, Chicago, IL",
         "Seller Address: 3973 Bolman Court, Chicago, IL",
         "Seller Address: 1528 Oakmound Drive, Chicago, IL",
         "Seller Address: 3287 Johnstown Road, Chicago, IL",
         "Seller Address: 4682 Vesta Drive, Chicago, IL",
         "Seller Address: 582 Pringle Drive, Chicago, IL",
         "Seller Address: 4050 Virginia Street, Chicago, IL",
         "Seller Address: 913 Walkers Ridge Way, Chicago, IL",
         "Seller Address: 145 Cherry Camp Road, Chicago, IL",
         "Seller Address: 3526 Nash Street, Chicago, IL",
         "Seller Address: 2707 Patterson Fork Road, Chicago, IL",
         "Seller Address: 837 Pinewood Drive, Chicago, IL"
    };

    String[] sellerPhone =
    {
        "Mobile Number: 773-738-2933",
        "Mobile Number: 773-876-6466",
        "Mobile Number: 773-616-8485",
        "Mobile Number: 708-305-7852",
        "Mobile Number: 773-497-0280",
        "Mobile Number: 773-610-5479",
        "Mobile Number: 708-833-0238",
        "Mobile Number: 773-367-0356",
        "Mobile Number: 773-552-0007",
        "Mobile Number: 773-991-8073",
        "Mobile Number: 773-716-7373",
        "Mobile Number: 773-986-3956"
    };

    int[] customerImage =
    {
      R.drawable.treadmills,
      R.drawable.ellipticals,
      R.drawable.exercise_bike,
      R.drawable.dumbbell_set,
      R.drawable.functional_trainers,
      R.drawable.stretching_yoga,
      R.drawable.abs,
      R.drawable.plates,
      R.drawable.bars,
      R.drawable.upright_bikes,
      R.drawable.rowing_machines,
      R.drawable.flooring_mats
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        //finding listview
        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getApplicationContext(), Customer_GridItem.class);
                intent.putExtra("name", customerTitle[i]);
                intent.putExtra("image", customerImage[i]);
                intent.putExtra("price",customerPrice[i]);
                intent.putExtra("sellername",sellerName[i]);
                intent.putExtra("sellerAddress",sellerAddress[i]);
                intent.putExtra("sellerPhone",sellerPhone[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return customerImage.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View view1 = getLayoutInflater().inflate(R.layout.activity_customer_row_data,null);
            TextView name = view1.findViewById(R.id.title);
            TextView price = view1.findViewById(R.id.price);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(customerTitle[i]);
            price.setText(customerPrice[i]);
            image.setImageResource(customerImage[i]);
            return view1;
        }
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
                Intent intent = new Intent(CustomerActivity.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(CustomerActivity.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(CustomerActivity.this, Setting.class);
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
