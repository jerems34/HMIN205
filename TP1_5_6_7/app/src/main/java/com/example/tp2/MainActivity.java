package com.example.tp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp2.ImplicitIntent;
import com.example.tp2.R;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSubmit= findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                open(arg0);
            }
        });
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Etes vous sûr de vos informations ?" + "\n \n" + infosToString());
        alertDialogBuilder.setPositiveButton("Valider",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        ArrayList<String> infos = getInfos();
                        Intent intent = new Intent(MainActivity.this, ImplicitIntent.class);
                        intent.putExtra("nom", infos.get(0));
                        intent.putExtra("prenom", infos.get(1));
                        intent.putExtra("age", infos.get(2));
                        intent.putExtra("domaine", infos.get(3));
                        intent.putExtra("tel", infos.get(4));
                        startActivity(intent);
                    }
                });
        alertDialogBuilder.setNegativeButton("Modifier",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
        alertDialogBuilder.show();
    }

    private ArrayList<String> getInfos() {
        ArrayList<String> userData = new ArrayList<>();

        EditText nom =findViewById(R.id.nom);
        EditText prenom =findViewById(R.id.prenom);
        EditText age =findViewById(R.id.age);
        EditText domaine =findViewById(R.id.domaine);
        EditText tel =findViewById(R.id.tel);
        userData.add(nom.getText().toString());
        userData.add(prenom.getText().toString());
        userData.add(age.getText().toString());
        userData.add(domaine.getText().toString());
        userData.add(tel.getText().toString());

        return userData;
    }

    private String infosToString() {
        ArrayList<String> infos = getInfos();
        String result = "Vos infos : \n\n" + getString(R.string.nom)  + infos.get(0) + "\n\n "+getString(R.string.prenom) + " : " + infos.get(1)+"\n\n" +
                getString(R.string.age) + " : "  + infos.get(2)+ "\n\n" + getString(R.string.domaine) + " : "  +
                infos.get(3)+ "\n\n" + getString(R.string.telephone)  + " : "  + infos.get(4);

        return result;
    }


}


