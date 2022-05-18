package com.example.rentagym.Workout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentagym.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workout_Link_Main extends AppCompatActivity
{
    ArrayList<String> titles;
    ArrayList<Integer> images;
    RecyclerView recyclerView;
    Workout_Link_MyAdapter adapter;
    Workout_Link_MyAdapter2 adapter2;

    String [] gymtrainingLink =
            {
                    "https://www.youtube.com/watch?v=kIfDGtrJGU8",
                    "https://www.youtube.com/watch?v=JrYYscsmzKA",
                    "https://www.youtube.com/watch?v=rEqRmKAQ5xM",
                    "https://www.youtube.com/watch?v=v2vLQiU8lJQ",
                    "https://www.youtube.com/watch?v=U1XXOLGfGBk",
                    "https://www.youtube.com/watch?v=4pKly2JojMw",
                    "https://www.youtube.com/watch?v=_O1xunCfYEM",
                    "https://www.youtube.com/watch?v=6rDbWw5js8s",
                    "https://www.youtube.com/watch?v=vthMCtgVtFw",
                    "https://www.youtube.com/watch?v=pwQhPq1XrNo",
                    "https://www.youtube.com/watch?v=1YQVix6LpUQ",
                    "https://www.youtube.com/watch?v=3-h63U7T8uI"
            };

    String [] gymWikiHow =
            {
                    "https://www.wikihow.fitness/Use-a-Treadmill-For-Beginners",
                    "https://www.wikihow.com/Use-an-Elliptical-Machine",
                    "https://www.wikihow.com/Use-an-Exercise-Bike",
                    "https://www.wikihow.com/Work-Out-at-Home-Using-Hand-Weights",
                    "https://www.wikihow.com/Use-Gym-Equipment",
                    "https://www.wikihow.com/Use-a-Yoga-Block",
                    "https://www.wikihow.com/Do-Crunches#:~:text=Raise%20your%20legs%20to%20bring,your%20balance%20and%20maintain%20control.",
                    "https://www.wikihow.com/Make-a-Homemade-Weight-Set",
                    "https://www.wikihow.com/Bench-Press#:~:text=Begin%20with%20just%20the%20bar,the%20sternum%20%E2%80%94%20with%20the%20bar.",
                    "https://www.wikihow.com/Adjust-Exercise-Bike-Resistance",
                    "https://www.wikihow.com/Row-on-a-Rowing-Machine",
                    "https://www.wikihow.com/Keep-Puzzle-Mats-Together"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_link_main);
        recyclerView = findViewById(R.id.recyclerView);
        registerForContextMenu(recyclerView);

        List<String> title = Arrays.asList(
                "Treadmills","Ellipticals","Exercise Bike","Dumbbell Set",
                "Functional Trainers","Stretching Yoga","Abdominal Crunch",
                "Weight Plates", "Bench Bars", "Upright Bikes", "Rowing Machines",
                "Flooring Mats");

        titles = new ArrayList<>();
        titles.addAll(title);

        images = new ArrayList<>();

        images.add(R.drawable.treadmills);
        images.add(R.drawable.ellipticals);
        images.add(R.drawable.exercise_bike);
        images.add(R.drawable.dumbbell_set);
        images.add(R.drawable.functional_trainers);
        images.add(R.drawable.stretching_yoga);
        images.add(R.drawable.abs);
        images.add(R.drawable.plates);
        images.add(R.drawable.bars);
        images.add(R.drawable.upright_bikes);
        images.add(R.drawable.rowing_machines);
        images.add(R.drawable.flooring_mats);

        //Defines listener with lamba, gives access.
        RVClickListener listener = (view,position)->
        {
            TextView name = (TextView)view.findViewById(R.id.title);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(gymtrainingLink[position]));
            view.getContext().startActivity(intent);
        };

        //List View
        adapter = new Workout_Link_MyAdapter(this,titles,images,listener, gymtrainingLink, gymWikiHow);

        //Grid View
        adapter2 = new Workout_Link_MyAdapter2(this,titles,images,listener, gymtrainingLink, gymWikiHow);

        //List View to Default
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            //Gird View
            case R.id.menu1:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(adapter2);
                return true;

            //List View
            case R.id.menu2:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
                return true;
        }
        //Default
        return super.onOptionsItemSelected(item);
    }
}
