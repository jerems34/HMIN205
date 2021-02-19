package com.example.capteurs;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static android.os.Build.VERSION_CODES.M;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public class Ex5 extends AppCompatActivity implements SensorEventListener {
        SensorManager sensorManager;
        Sensor accelerometer;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            setContentView(R.layout.activity_exo_5);
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
        Boolean flash=false;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onSensorChanged(SensorEvent event) {
            TextView tv = findViewById(R.id.tv1);
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float[] history = new float[2];

                float xChange = history[0] - event.values[0];
                float yChange = history[1] - event.values[1];
                history[0] = event.values[0];
                history[1] = event.values[1];
                if (xChange > 10 && yChange > 10) {
                    if (!flash) {
                        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                        try {
                            String cameraId = cameraManager.getCameraIdList()[0];
                            if (Build.VERSION.SDK_INT >= M) {
                                cameraManager.setTorchMode(cameraId, true);
                            }
                            flash = true;
                        } catch (CameraAccessException e) {
                        }
                    }
                    else {
                        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                        try {
                            String cameraId = cameraManager.getCameraIdList()[0];
                            if (Build.VERSION.SDK_INT >= M) {
                                cameraManager.setTorchMode(cameraId, false);
                            }
                            flash = false;
                        } catch (CameraAccessException e) {
                        }
                    }
                }
            }
        }




        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }



