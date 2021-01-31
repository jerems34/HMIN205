package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ex4 extends Activity {
    private Button button,afficherSecret,appuiLong;
    private TextView tv;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4);
        button = (Button) findViewById(R.id.mainbutton);
        tv = findViewById(R.id.secret);
        tv.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"Message Bouton 1", Toast.LENGTH_LONG).show();
            }
        });
        afficherSecret = findViewById(R.id.affichesecret);
        afficherSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                tv.setText("Exercice 4");
                if(tv.getVisibility() == View.VISIBLE){
                    tv.setVisibility(View.INVISIBLE);
                    afficherSecret.setText("Voir le message secret");
                }else{
                    tv.setVisibility(View.VISIBLE);
                    afficherSecret.setText("Cacher le message secret");
                }
            }
        });

        appuiLong = findViewById(R.id.longbtnpress);
        appuiLong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Appui long", Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}
