package com.example.capteurs;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Ex3 extends AppCompatActivity implements SensorEventListener {
        SensorManager sensorManager;
        Sensor accelerometer;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            setContentView(R.layout.activity_exo_3);
        }
        @Override
        protected void onPause() {
            // unregister the sensor (désenregistrer le capteur)
            sensorManager.unregisterListener(this, accelerometer);
            super.onPause();
        }
        @Override
        protected void onResume() {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
            super.onResume();
        }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
            float dist = (float) sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
            LinearLayout li = findViewById(R.id.accel);
            if (x<=-1| y<=-1 | z<=-1) {
                li.setBackgroundColor(GREEN);
            }
            else {
                if ((x>0 && x <5)| (y>0 && y <5) | (z>0 && z <5)) {
                    li.setBackgroundColor(BLACK);
                }
                else{
                        li.setBackgroundColor(RED);
                    }
                }
            }
        }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
