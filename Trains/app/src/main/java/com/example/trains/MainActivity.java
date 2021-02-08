package com.example.trains;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Marseille");
        cities.add("Montpellier");
        cities.add("Paris");

        ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
        itineraries.add(new Itinerary("Marseille","Montpellier","08h00"));
        itineraries.add(new Itinerary("Marseille","Montpellier","09h00"));
        itineraries.add(new Itinerary("Marseille","Montpellier","10h00"));
        itineraries.add(new Itinerary("Montpellier","Paris","08h00"));
        itineraries.add(new Itinerary("Montpellier","Paris","09h00"));
        itineraries.add(new Itinerary("Montpellier","Paris","10h00"));

        //Pour le autocomplete
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,cities);
        AutoCompleteTextView startItinerary = findViewById(R.id.auto_cities);
        startItinerary.setAdapter(adapter);
        AutoCompleteTextView endItinerary = findViewById(R.id.auto_cities2);
        endItinerary.setAdapter(adapter);

        //On click event
        Button btnSearch = findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(v -> {
                LinearLayout result = findViewById(R.id.result);
                //Si on a deja fait une recherche
                result.removeAllViews();
                String beginCity =  ((AutoCompleteTextView) findViewById(R.id.auto_cities)).getText().toString();
                String endCity = ((AutoCompleteTextView) findViewById(R.id.auto_cities2)).getText().toString();

                for(Itinerary t : itineraries) {
                    if (beginCity.equals(t.beginCity) && endCity.equals(t.endCity)) {
                        TextView itinerary = new TextView(MainActivity.this);
                        itinerary.setText(beginCity + "-" + endCity + " : " + t.horaire);
                        result.addView(itinerary);
                    }
                }
                //Si le linear layout n'a pas d'enfant => pas de trains dispo
                     if(result.getChildCount()==0){
                        TextView noItinerary = new TextView(MainActivity.this);
                        noItinerary.setText("Pas de trains pour l'itineraire choisi " + beginCity + "-" +  endCity);
                        result.addView(noItinerary);
                    }
        });
    }
}