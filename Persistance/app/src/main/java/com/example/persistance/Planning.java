package com.example.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.UUID;

public class Planning extends AppCompatActivity {

    String crenau1 ="08h-10h : Rencontre client Dupont \n 10h-12h : Travailler le dossier de recrutement" +
            "14h-16h : Réunion Equipe \n 16h-18h : Préparation dossier vente";
    @Override
    public void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        try {
            createFichierPlanningLendemain();
        }catch (Exception e){

        }
        //J'avais fait dans quatre attributs pour chaque créneau mais j'ai simplifié en mettant tout dans un seul string
        TextView tv1 = findViewById(R.id.creneau1);
        TextView tv2 = findViewById(R.id.creneau2);
        TextView tv3 = findViewById(R.id.creneau3);
        TextView tv4 = findViewById(R.id.creneau4);


        //Probleme pour db impossbile de crrer une instance de planningmodel....
        PlanningModel model = new ViewModelProvider(this).get(PlanningModel.class);
       // final String creneau_id = UUID.randomUUID().toString();
     //   PlanningEntity planningEntity = new PlanningEntity(creneau_id,"vhrzvuirhvuirhviuzrvhzrvhithzvuizrhv");
       // model.insert(planningEntity);

        model.initPlanning(crenau1);
        //System.out.println("herrre " + model.planningToString());
        tv1.setText(model.planningToString());
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                tv1.setText(newName);
            }
        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the
        model.getCurrentPlanning().observe(this,nameObserver);

        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (currentHour > 11) {
            try {
                FileInputStream planningFile = openFileInput("planning");
            BufferedReader reader = new BufferedReader(new InputStreamReader(planningFile));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append("\n");
            }   //Prints the string content read from input stream
            reader.close();
            model.updatePlanning(out.toString());
            //tv1.setText(model.crenau1); Avant livedata
            } catch (Exception e){}
        }
    }

    private void createFichierPlanningLendemain() throws Exception{
        FileOutputStream myFile = openFileOutput("planning", Context.MODE_PRIVATE);

        String toSave = "08h-10h : Cours HMIN210\n\n" +
        "10h-12h : Cours HMIN210\n\n"+
        "14h-16h : Cours Android \n\n"+
        "16h-18h : Cours Android\n\n";
        myFile.write(toSave.getBytes());
        myFile.close();
    }
}
