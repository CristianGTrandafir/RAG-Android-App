package com.example.rentagym.Workout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentagym.R;

import java.util.ArrayList;

public class Workout_Images_Adapter extends RecyclerView.Adapter<Workout_Images_Adapter.WorkoutViewHolder>
{
    private ArrayList<Workout_Images_Items> WorkoutList;

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mImageView1;
        public ImageView mImageView2;
        public ImageView mImageView3;

        public WorkoutViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mImageView1 = itemView.findViewById(R.id.imageView1);
            mImageView2 = itemView.findViewById(R.id.imageView2);
            mImageView3 = itemView.findViewById(R.id.imageView3);
        }
    }

    public Workout_Images_Adapter(ArrayList<Workout_Images_Items> workoutList)
    {
        WorkoutList = workoutList;
    }

    @Override
    public Workout_Images_Adapter.WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_workout_images_item,
                parent, false);
        Workout_Images_Adapter.WorkoutViewHolder viewHolder = new Workout_Images_Adapter.WorkoutViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Workout_Images_Adapter.WorkoutViewHolder  holder, int position)
    {
        Workout_Images_Items currentItem = WorkoutList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mImageView1.setImageResource(currentItem.getImage1());
        holder.mImageView2.setImageResource(currentItem.getImage2());
        holder.mImageView3.setImageResource(currentItem.getImage3());
    }

    @Override
    public int getItemCount()
    {
        return WorkoutList.size();
    }

    public void filterList(ArrayList<Workout_Images_Items> filteredList)
    {
        WorkoutList = filteredList;
        notifyDataSetChanged();
    }
}
