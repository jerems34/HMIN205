package com.example.persistance;

import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Utilisation implements LifecycleObserver {
   public int utilisation = 0;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void nbUtilisations() {
        utilisation++;
    }
}


