package com.example.rentagym.Customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentagym.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private String[] localDataSet;
    Context context;
    ArrayList<ChatMessage> messages;

    public MessageAdapter(Context context, ArrayList<ChatMessage> messages){
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.message, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChatMessage cM = messages.get(position);
        holder.message.setText(cM.message);
        holder.user.setText(cM.fromUser);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView message, user;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            message = itemView.findViewById(R.id.content);
            user = itemView.findViewById(R.id.user);
        }
    }



}

