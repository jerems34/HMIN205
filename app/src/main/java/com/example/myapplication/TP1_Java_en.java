package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TP1_Java_en extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView nom = new TextView(this);
        TextView prenom = new TextView(this);
        TextView age = new TextView(this);
        TextView domaine = new TextView(this);
        TextView tel = new TextView(this);
        EditText et1 = new EditText(this);
        EditText et2 = new EditText(this);
        EditText et3 = new EditText(this);
        EditText et4 = new EditText(this);
        EditText et5 = new EditText(this);
        nom.setText(R.string.name);
        prenom.setText(R.string.firstname);
        age.setText(R.string.age);
        domaine.setText(R.string.domain);
        tel.setText(R.string.phone);
        Button validation = new Button(this);
        validation.setText("Submit");
        LinearLayout li = new LinearLayout(this);
        li.setOrientation(LinearLayout.VERTICAL);
        li.addView(nom);
        li.addView(et1);
        li.addView(prenom);
        li.addView(et2);
        li.addView(age);
        li.addView(et3);
        li.addView(domaine);
        li.addView(et4);
        li.addView(tel);
        li.addView(et5);
        li.addView(validation);
        setContentView(li);
    }
}
