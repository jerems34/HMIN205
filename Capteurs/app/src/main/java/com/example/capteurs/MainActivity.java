package com.example.capteurs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.Character.getType;

public class MainActivity extends AppCompatActivity {
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
        }
            private void switchActivity(int act){
                Intent intent = null;
                switch (act) {
                    case 1:
                        intent = new Intent(this, Ex1.class);
                        break;
                    case 2:
                        intent = new Intent(this, Ex2.class);
                        break;
                    case 3:
                        intent = new Intent(this, Ex3.class);
                        break;

                    case 4:
                        intent = new Intent(this, Ex4.class);
                        break;
                    case 5:
                        intent = new Intent(this, Ex5.class);
                        break;
                    case 6:
                        intent = new Intent(this, Ex6.class);
                        break;
                }
                startActivity(intent);

            }

}