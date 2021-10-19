package com.example.android_chatting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_chatting.DTO.ChatData;
import com.example.android_chatting.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder>{
    private List<ChatData> mDataset;
    private String myNickName;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;
        public MyViewHolder(View v) {
            super(v);
            //TextView_nickname = v.findViewById(R.id.TextView_nickname);
            //TextView_msg = v.findViewById(R.id.TextView_msg);
            rootView = v;

        }
    }

    public ChatAdapter(List<ChatData> myDataset, Context context, String myNickName) {
        //{"1","2"}
        mDataset = myDataset;
        this.myNickName = myNickName;
    }

    @NonNull
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MyViewHolder holder, int position) {
        ChatData chat = mDataset.get(position);

        holder.TextView_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getMessage());

        if(chat.getNickname().equals(this.myNickName)) {
            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else {
            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }

    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 :  mDataset.size();
    }

    public ChatData getChat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    public void addChat(ChatData chat) {
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1); //갱신
    }
}
