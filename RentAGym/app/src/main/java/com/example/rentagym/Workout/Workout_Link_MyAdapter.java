package com.example.rentagym.Workout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rentagym.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Workout_Link_MyAdapter extends RecyclerView.Adapter<Workout_Link_MyAdapter.ViewHolder>
{
    ArrayList<String> titles;
    List<Integer> images;

    LayoutInflater inflater;

    RVClickListener RVlistener;

    String [] gymClip;
    String [] gymWikiHow;

    //Passing Data & Listener from MainActivity
    public Workout_Link_MyAdapter(Context ctx, ArrayList<String> titles, List<Integer> images, RVClickListener listener, String [] gymClip, String [] gymWikiHow)
    {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.RVlistener = listener;
        this.gymClip = gymClip;
        this.gymWikiHow = gymWikiHow;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.activity_workout_link_list_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listView, RVlistener);
        return (viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.imageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener,View.OnCreateContextMenuListener
    {
        View itemView;
        TextView title;
        ImageView imageView;
        RVClickListener listener;

        Intent intent = new Intent(Intent.ACTION_VIEW);

        public ViewHolder(@NonNull View itemView,RVClickListener passedListener)
        {
            super(itemView);

            //ID's
            title = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.gymImage);

            this.itemView = itemView;
            this.listener = passedListener;

            //set short click listener
            itemView.setOnClickListener(this);

            //set long click listener
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onClick(View v)
        {
            listener.onClick(v, getAdapterPosition());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo)
        {
            //Inflate menu from context_menu.xml
            MenuInflater inflater = new MenuInflater(view.getContext());
            inflater.inflate(R.menu.context_menu,menu);

            menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
            {
                @Override
                public boolean onMenuItemClick(MenuItem item)
                {
                    intent.setData(Uri.parse(gymClip[getAdapterPosition()]));
                    view.getContext().startActivity(intent);
                    return false;
                }
            });

            menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
            {
                @Override
                public boolean onMenuItemClick(MenuItem item)
                {
                    intent.setData(Uri.parse(gymWikiHow[getAdapterPosition()]));
                    view.getContext().startActivity(intent);
                    return false;
                }
            });
        }
    }
}