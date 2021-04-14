package com.ruthvik.app_testing_5.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.ruthvik.app_testing_5.Models.Message;
import com.ruthvik.app_testing_5.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {

    ArrayList<Message> message;
    Context context;

    int SENDER_VIEW_TYPE = 1;
    int RECIEVER_VIEW_TYPE = 2;

    public ChatAdapter(ArrayList<Message> message, Context context) {
        this.message = message;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == SENDER_VIEW_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.message_sender, parent, false);
            return new SenderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.message_reciever, parent, false);
            return new RecieverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(message.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())) {
            return SENDER_VIEW_TYPE;
        } else {
            return RECIEVER_VIEW_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message messageModel = message.get(position);

        if(holder.getClass() == SenderViewHolder.class) {
            ((SenderViewHolder)holder).senderMessage.setText(messageModel.getMessage());
        } else {
            ((RecieverViewHolder)holder).recieverMessage.setText(messageModel.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder {

        TextView recieverMessage, recieverTime;
        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);

            recieverMessage = itemView.findViewById(R.id.recieverText);
            recieverTime = itemView.findViewById(R.id.recieverTime);
        }
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder {

        TextView senderMessage, senderTime;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMessage = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.senderTime);
        }
    }
}
