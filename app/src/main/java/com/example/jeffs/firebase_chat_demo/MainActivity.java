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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    private Button sendBtn;
    private String senderName="JohnDoe";
    EditText editText;
    ArrayAdapter<String> adapter;
    ChatMessageAdapter mChatMessageAdapter;
    ArrayList<String> lstOfMsgs =new ArrayList<String>();

    DatabaseReference myRef;
    ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef = FirebaseDatabase.getInstance().getReference("chats");

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
                //mChatMessageAdapter.add(new ChatMessage(str,senderName,getCurrentTime()));

                myRef.push().setValue(new ChatMessage(str,senderName,getCurrentTime()));

                editText.getText().clear();
            }
        });

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatMessage msg = dataSnapshot.getValue(ChatMessage.class);
                mChatMessageAdapter.add(msg);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        myRef.addChildEventListener(mChildEventListener);
    }

    public static String getCurrentTime(){

        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
        return format.format(Calendar.getInstance().getTime());
    }
}