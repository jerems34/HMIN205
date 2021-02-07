package com.example.tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2.R;

import java.util.ArrayList;

public class ImplicitIntent extends Activity {
    private String nom,prenom,domaine,tel,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        Intent intent = getIntent();
        this.nom = intent.getStringExtra("nom");
        this.prenom = intent.getStringExtra("prenom");
        this.age = intent.getStringExtra("age");
        this.tel = intent.getStringExtra("tel");
        this.domaine = intent.getStringExtra("domaine");

        TextView infosUser = findViewById(R.id.user_data);
        infosUser.setText(infosToString());

        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent old_intent = getIntent();
                Intent intent = new Intent(ImplicitIntent.this, OkActivity.class);
                intent.putExtra("tel", old_intent.getStringExtra("tel"));
                startActivity(intent);
            }
        });

        findViewById(R.id.return_button).setOnClickListener(v -> {
            this.finish();
        });
    }

    private String infosToString() {
        String result = "Vos infos : \n\n"
                + getString(R.string.nom) +" : " + this.nom + "\n\n"
                + getString(R.string.nom) +" : " + this.prenom + "\n\n"
                + getString(R.string.age) + " : "  + this.age + "\n\n"
                + getString(R.string.telephone) + " : "  + this.tel + "\n\n"
                + getString(R.string.domaine) + " : "  + this.domaine;

        return result;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
