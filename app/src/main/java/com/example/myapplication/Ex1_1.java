package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Ex1_1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1_1);
        TextView tv = new TextView(this);
        EditText et = new EditText(this);
        tv.setText("Hello, Android");
        et.setText("Enter text here");
        LinearLayout li = findViewById(R.id.ex1);
        li.setOrientation(LinearLayout.VERTICAL);
        li.addView(tv);
        li.addView(et);

    }
}

