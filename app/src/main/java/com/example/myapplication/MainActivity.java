package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(1);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(2);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(3);
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(4);
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(5);
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(6);
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(7);
            }
        });

        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(8);
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(9);
            }
        });
        findViewById(R.id.btn10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(10);
            }
        });

    }
    private void switchActivity(int act) {
        Intent intent = null;
        switch (act){
            case 1:
                intent = new Intent(this, Ex1_1.class);
                break;
            case 2:
                intent = new Intent(this, Ex1_2.class);
                break;
            case 3:
                intent = new Intent(this, Ex2.class);
                break;

            case 4:
                intent = new Intent(this, Ex3.class);
                break;
            case 5:
                intent = new Intent(this, Ex4.class);
                break;
            case 6:
                intent = new Intent(this, Ex5.class);
                break;
            case 7:
                intent = new Intent(this, Tp1_Java_fr.class);
                break;
            case 8:
                intent = new Intent(this, Tp1_xml_fr.class);
                break;
            case 9:
                intent = new Intent(this, TP1_Java_en.class);
                break;
            case 10:
                intent = new Intent(this, Tp1_xml_en.class);
                break;
        }

        startActivity(intent);
    }
}