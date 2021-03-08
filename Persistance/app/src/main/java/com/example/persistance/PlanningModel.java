package com.example.persistance;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

public class PlanningModel extends ViewModel {
    private MutableLiveData<String> currentPlanning = new MutableLiveData<>();
    private PlanningRepository planningRepository;


    //Probleme pour db impossible de creer une instance de planningmodel....
/*
    PlanningModel(Application application) {
        super(application);
        planningRepository= new PlanningRepository(application);

    }
*/

    public void insert(PlanningEntity planning){
        planningRepository.insert(planning);
    }

    public void initPlanning(String value) {
            currentPlanning = new MutableLiveData<>();
            currentPlanning.setValue(value);
    }
    public MutableLiveData<String>  getCurrentPlanning() {
         return currentPlanning;
    }
    public String planningToString(){
        return currentPlanning.getValue();
    }
    public void updatePlanning(String newPlanning){
        currentPlanning.setValue(newPlanning);
    }

}
