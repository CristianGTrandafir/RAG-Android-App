package com.example.rentagym.MenuOption;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentagym.R;

import java.util.ArrayList;


public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.HelperViewHolder>
{
    private ArrayList<HelperItem> HelperList;

    public static class HelperViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView1;
        public TextView mTextView2;

        public HelperViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public HelperAdapter(ArrayList<HelperItem> helperList)
    {
        HelperList = helperList;
    }

    @Override
    public HelperViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_help_item,
                parent, false);
        HelperViewHolder viewHolder = new HelperViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HelperViewHolder holder, int position)
    {
        HelperItem currentItem = HelperList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount()
    {
        return HelperList.size();
    }

    public void filterList(ArrayList<HelperItem> filteredList)
    {
        HelperList = filteredList;
        notifyDataSetChanged();
    }
}
