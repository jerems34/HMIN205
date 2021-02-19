package com.example.capteurs;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.SENSOR_SERVICE;

public class Ex1 extends AppCompatActivity {
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_1);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        listSensor();

    }


    private void listSensor() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer sensorDesc = new StringBuffer();

        for (Sensor sensor : sensors) {
            sensorDesc.append("\t" + sensor.getName()
                    + "\r\n\n\n");
        }
//        Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();
        ScrollView sv = findViewById(R.id.scroll);
        TextView tv = new TextView(this);
        tv.setText(sensorDesc);
        tv.setTextSize(20);
        sv.addView(tv);

    }
}

