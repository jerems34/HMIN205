package com.example.persistance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ShowInfos extends AppCompatActivity {
    String fileName;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        Intent thisIntent= getIntent();
        Bundle b = thisIntent.getExtras();

        if(b!=null)
        {
            fileName =(String) b.get("fileName");

        }

        try {
            openMyInfoFile();
        } catch (Exception E){

        }

    }

    private void openMyInfoFile()throws Exception {
        TextView tv = findViewById(R.id.fileContent);
        FileInputStream myFile = openFileInput(fileName);
        String text = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(myFile));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append("\n");
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();
       tv.setText(out);

    }

}
