package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.edittext2);
        textRes = findViewById(R.id.txtRes);
    }

    public void onDel(View view)
    {
        textRes.setText("");
        int a = Integer.parseInt(editText1.getText().toString());
        int b = Integer.parseInt(editText2.getText().toString());

        if(b == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.TOAST_STRING, Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            int res = a / b;
            String restxt = "Результат: " + res;
            textRes.setText(restxt);
        }
    }

    public void onMultp(View view)
    {
        textRes.setText("");
        int a = Integer.parseInt(editText1.getText().toString());
        int b = Integer.parseInt(editText2.getText().toString());
        int res = a * b;
        String restxt = "Результат: " + res;
        textRes.setText(restxt);
    }


    public void onMinus(View view)
    {
        textRes.setText("");
        int a = Integer.parseInt(editText1.getText().toString());
        int b = Integer.parseInt(editText2.getText().toString());
        int res = a - b;
        String restxt = "Результат: " + res;
        textRes.setText(restxt);
    }

    public void onPlus(View view)
    {
        textRes.setText("");
        //if(isNumber(editText1.getText().toString()) && isNumber(editText2.getText().toString())) {
            int a = Integer.parseInt(editText1.getText().toString());
            int b = Integer.parseInt(editText2.getText().toString());
            int res = a + b;
            String restxt = "Результат: " + res;
            textRes.setText(restxt);
       // }
        //else
        //{
         //   Toast toast = Toast.makeText(getApplicationContext(),
            //        "Одно из полей некорректно заполнено", Toast.LENGTH_SHORT);
           // toast.show();
       // }
    }

    public void onClickSecond(View view)
    {
        Intent intent = new Intent(MainActivity.this, MainActivity_2.class);
        startActivity(intent);

    }
}