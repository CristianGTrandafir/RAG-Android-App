package com.example.rentagym.Workout;

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

import com.example.rentagym.MainActivity;
import com.example.rentagym.MenuOption.GoogleMaps;
import com.example.rentagym.MenuOption.Help;
import com.example.rentagym.MenuOption.Setting;
import com.example.rentagym.R;

import java.util.ArrayList;

public class Workout_Images_Main extends AppCompatActivity
{
    ArrayList<Workout_Images_Items> WorkoutList;
    RecyclerView mRecyclerView;
    Workout_Images_Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_images);

        WorkoutList = new ArrayList<>();
        WorkoutList.add(new Workout_Images_Items("1. Treadmills ", "A treadmill is a machine that allows you to walk, run, or climb while remaining stationary.",R.drawable.workout_treadmill_1, R.drawable.workout_treadmill_2, R.drawable.workout_treadmill_3));
        WorkoutList.add(new Workout_Images_Items("2. Ellipticals", "An elliptical trainer, also known as a cross-trainer, is a stationary exercise machine that allows you to stair climb, walk, or run without putting too much strain on your joints, lowering your risk of impact injuries.",R.drawable.workout_ellipticals_1, R.drawable.workout_ellipticals_2, R.drawable.workout_ellipticals_3));
        WorkoutList.add(new Workout_Images_Items("3. Exercise Bike", "A stationary bicycle is a piece of exercise equipment that is used for indoor cycling. It has a saddle, pedals, and handlebars similar to those found on a bicycle.",R.drawable.workout_exercisebike_1, R.drawable.workout_exercisebike_2, R.drawable.workout_exercisebike_3));
        WorkoutList.add(new Workout_Images_Items("4. Dumbbell Set", "Weight training is a popular type of strength training that is used to increase the strength and size of skeletal muscles.",R.drawable.workout_dumbbellset_1, R.drawable.workout_dumbbellset_2,R.drawable.workout_dumbbellset_3));
        WorkoutList.add(new Workout_Images_Items("5. Functional Trainers ", "Functional training is a type of exercise that involves preparing the body for activities that occur in daily life.",R.drawable.workout_functionaltrainers_1,R.drawable.workout_functionaltrainers_2,R.drawable.workout_functionaltrainers_3));
        WorkoutList.add(new Workout_Images_Items("6. Stretching Yoga", "Functional training is a type of exercise that involves preparing the body for activities that occur in daily life.",R.drawable.workout_yoga_1,R.drawable.workout_yoga_2,R.drawable.workout_yoga_3));
        WorkoutList.add(new Workout_Images_Items("7. Abdominal crunch", "The abdominal crunch focuses on the abdominal muscles, which are a part of your core muscle group. Most physical activities and sports are easier to perform when your core muscles are strong.",R.drawable.workout_crunch_1,R.drawable.workout_crunch_2,R.drawable.workout_crunch_3));
        WorkoutList.add(new Workout_Images_Items("8. Weight Plates", "A weight plate is a flat, heavy object, usually made of cast iron, that is used in conjunction with barbells or dumbbells to create a bar with a desired total weight for physical exercise.",R.drawable.workout_plates_1,R.drawable.workout_plates_2,R.drawable.workout_plates_3));
        WorkoutList.add(new Workout_Images_Items("9. Bench Bars ", "A flat, rigid barbell about 7 feet long, or a few inches longer, can be found in most commercial gyms across the country. These bars are typically made of American steel and weigh 45 pounds, or about 20.5 kilograms.",R.drawable.workout_bars_1,R.drawable.workout_bars_2,R.drawable.workout_bars_3));
        WorkoutList.add(new Workout_Images_Items("10. Uprights Bikes", "A stationary bicycle is a piece of exercise equipment that is used for indoor cycling. It has a saddle, pedals, and handlebars similar to those found on a bicycle.",R.drawable.workout_uprightbike_1,R.drawable.workout_uprightbike_2,R.drawable.workout_uprightbike_3));
        WorkoutList.add(new Workout_Images_Items("11. Rowing Machines", "An indoor rower, also known as a rowing machine, is a machine that simulates the action of watercraft rowing for the purposes of exercise or rowing training. Because they measure the work done by the rower, modern indoor rowers are often referred to as ergometers.",R.drawable.workout_rowing_1,R.drawable.workout_rowing_2,R.drawable.workout_rowing_3));
        WorkoutList.add(new Workout_Images_Items("12. Flooring Mats", "A wrestling or gymnastics mat, or an anti-vibration mat, is used to protect what is above the mat.",R.drawable.workout_mats_1,R.drawable.workout_mats_2,R.drawable.workout_mats_3));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Workout_Images_Adapter(WorkoutList);

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
        ArrayList<Workout_Images_Items> filteredList = new ArrayList<>();

        for (Workout_Images_Items item : WorkoutList)
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
                Intent intent = new Intent(Workout_Images_Main.this, GoogleMaps.class);
                startActivity(intent);
                return true;
            case R.id.Item3:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(Workout_Images_Main.this, Help.class);
                startActivity(helpIntent);
                return true;
            case R.id.Item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Workout_Images_Main.this, Setting.class);
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
