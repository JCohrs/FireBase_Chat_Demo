package com.example.jeffs.firebase_chat_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jeffs.firebase_chat_demo.model.ChatMessage;
import com.example.jeffs.firebase_chat_demo.model.ChatMessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    private Button sendBtn;
    EditText editText;
    ArrayAdapter<String> adapter;
    ChatMessageAdapter mChatMessageAdapter;
    ArrayList<String> lstOfMsgs =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ChatMessage> listOfChatMessages = new ArrayList<>();

        listView1 =(ListView)findViewById(R.id.lstview);
        editText =(EditText)findViewById(R.id.input_msg);
        sendBtn =(Button)findViewById(R.id.send_msg);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lstOfMsgs);

        mChatMessageAdapter = new ChatMessageAdapter(this,R.layout.chat_msg_item,listOfChatMessages);
        listView1.setAdapter(mChatMessageAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                mChatMessageAdapter.add(new ChatMessage(str,"JohnDoe","09:00:00"));
                editText.getText().clear();
            }
        });
    }
}