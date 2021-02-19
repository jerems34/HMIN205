package com.example.capteurs;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.widget.ConstraintLayout;

        import android.content.Context;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

public class Ex6 extends AppCompatActivity implements SensorEventListener{

    TextView isAvailable, data;
    ImageView img;
    SensorManager Smanager;
    Sensor myProximitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_6);
        isAvailable = (TextView) findViewById(R.id.tv2);
        data = (TextView) findViewById(R.id.tv3);
        img = (ImageView) findViewById(R.id.image);
        Smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }
    @Override
    protected void onPause() {
        super.onPause();
        Smanager.unregisterListener((SensorEventListener) this, Smanager.getDefaultSensor(Sensor.TYPE_PROXIMITY));
    }
    @Override
    protected void onResume() {
        super.onResume();
        myProximitySensor = Smanager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            isAvailable.setText("\nPas de détecteur de proximité!\n");
        } else {
            Smanager.registerListener(this,myProximitySensor,SensorManager.SENSOR_DELAY_NORMAL);
            isAvailable.setText("\nDétecteur de proximité disponible\n");

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0) {
                data.setText("Proche");
                img.setImageDrawable(getDrawable(R.drawable.signal_fort));
            } else {
                data.setText("Loin");
                img.setImageDrawable(getDrawable(R.drawable.signal_faible));
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
