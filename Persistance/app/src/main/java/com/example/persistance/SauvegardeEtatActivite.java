package com.example.persistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class SauvegardeEtatActivite extends AppCompatActivity {
    String fileName;Utilisation util = new Utilisation();
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
         getLifecycle().addObserver(util);
          IDGenerator();

        Button soumission = findViewById(R.id.btnSoumettre);
        Button planning = findViewById(R.id.btnPlanning);
        soumission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    saveMyIdInFile();
                    Intent nextIntent = new Intent(SauvegardeEtatActivite.this,ShowInfos.class);
                    nextIntent.putExtra("fileName",fileName);
                    startActivity(nextIntent);
                } catch (Exception f){

                }
            }
        });

        planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(SauvegardeEtatActivite.this,Planning.class);
                startActivity(nextIntent);
            }
        });
        }

    private void saveMyIdInFile() throws Exception {
        EditText et = findViewById(R.id.nom);
        EditText et1 = findViewById(R.id.prenom);
        EditText et2 = findViewById(R.id.age);
        EditText et3 = findViewById(R.id.phone);
        EditText et4 = findViewById(R.id.pseudo);
        fileName = et.getText().toString() + et4.getText().toString();
        FileOutputStream myFile = openFileOutput(fileName, Context.MODE_PRIVATE);

        String toSave = "Votre nom : " + et.getText().toString()  + "\n\n" + "Votre prénom : " + et1.getText().toString() + "\n\n" + "Votre âge : " + et2.getText().toString()
        +  "\n\n" +"Votre numéro de téléphone : " + et3.getText().toString() + "\n\n"  + "Votre identifiant :  "  + et4.getText().toString() + "\n\n" + "Nombre d'utilisations : " + util.utilisation   ;
        myFile.write(toSave.getBytes());
        myFile.close();
    }


    private void IDGenerator() {
        EditText et = findViewById(R.id.pseudo);
        Random rand = new Random();
        int n = rand.nextInt(5000);
        String id = ""+ n;
        et.setText(id);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "Etat de l'activité restauré",
                Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(this, "Etat de l'activité sauvegardé",
                Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "L'activité est détruite", Toast.LENGTH_SHORT)
                .show();
    }
}

