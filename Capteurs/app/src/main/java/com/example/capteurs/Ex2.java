package com.example.capteurs;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex2 extends AppCompatActivity {
    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_2);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        TextView tv = findViewById(R.id.tv);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) !=null){
           tv.setText("Vous avez un capteur de temperature"); ;
        } else {
            tv.setText("Vous n'avez pas de capteur de temperature");
        }
    }
}

