package com.example.jeffs.firebase_chat_demo.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jeffs.firebase_chat_demo.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jeffs on 4/5/2017.
 */

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    public ChatMessageAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChatMessage> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null)
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(
                    R.layout.chat_msg_item,parent,false);

        TextView msgBody = (TextView)convertView.findViewById(R.id.chat_item_body);
        TextView username = (TextView)convertView.findViewById(R.id.chat_item_username);
        TextView msgTime = (TextView)convertView.findViewById(R.id.chat_item_msgtime);

        ChatMessage message = getItem(position);

        msgBody.setText(message.getMsg());
        username.setText(message.getUsername());
        msgTime.setText(message.getMsgTime());

        return super.getView(position, convertView, parent);
    }
}
