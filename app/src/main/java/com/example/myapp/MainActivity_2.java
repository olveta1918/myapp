package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_2 extends AppCompatActivity {

    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        str="";
    }


    public void onClick(View view)
    {
        TextView txtRes = (TextView)findViewById(R.id.txtRes2);
        EditText editText = (EditText)findViewById(R.id.edittext12);

        if(!str.trim().isEmpty())
            str +="\n";
        str += editText.getText();
        editText.setText("");
        txtRes.setText(str);


    }

}