package com.example.capteurs;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Ex4 extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor accelerometer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        setContentView(R.layout.activity_exo_4);
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
        TextView tv = findViewById(R.id.tv1);
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] history = new float[2];
            float xChange = history[0] - event.values[0];
            float yChange = history[1] - event.values[1];

            history[0] = event.values[0];
            history[1] = event.values[1];

            if (xChange > 2) {
                tv.setText("RIGHT");
                tv.setTextSize(20);
            } else if (xChange < -2) {
                tv.setText("LEFT");
                tv.setTextSize(20);
            }

            if (yChange > 2) {
                tv.setText("DOWN");
                tv.setTextSize(20);
            } else if (yChange < -2) {
                tv.setText("UP");
                tv.setTextSize(20);
            }
        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
