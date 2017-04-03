package com.example.jeffs.firebase_chat_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    private Button sendBtn;
    EditText editText;
    ArrayList<String> lstOfMsgs =new ArrayList<String>();
    ArrayList<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 =(ListView)findViewById(R.id.lstview);
        editText =(EditText)findViewById(R.id.input_msg);
        sendBtn =(Button)findViewById(R.id.send_msg);

       final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lstOfMsgs);
        listView1.setAdapter(adapter);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(editText.getText().toString());
            }
        });
    }
}

//testing testing