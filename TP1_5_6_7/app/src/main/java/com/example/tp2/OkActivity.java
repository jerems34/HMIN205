package com.example.tp2;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tp2.R;

public class OkActivity extends Activity {
    String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok);
        Intent intent = this.getIntent();
        this.tel = intent.getStringExtra("tel");
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:"+tel));
        findViewById(R.id.phone_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(OkActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(phoneIntent);
                } else {
                    ActivityCompat.requestPermissions(OkActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            10);
                }
            }
        });
    }
}
