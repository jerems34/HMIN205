package com.example.persistance;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

public class PlanningRepository  {
    private MutableLiveData<String> currentPlanning = new MutableLiveData<>();
    private PlanningDao planningDao;
    PlanningRepository(Application application) {
        AppDatabase planningDB = AppDatabase.getDatabase(application);
        planningDao = planningDB.planningDao();
    }
    public void insert(PlanningEntity planning){
        new InsertAsyncTask(planningDao).execute(planning);
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


    private class InsertAsyncTask extends AsyncTask<PlanningEntity,Void,Void> {
        PlanningDao planningDao;
        public InsertAsyncTask(PlanningDao planningDao) {
            this.planningDao= planningDao;
        }

        @Override
        protected Void doInBackground(PlanningEntity ... planningEntity) {
            planningDao.insertCrenaux(planningEntity[0]);
            return null;
        }
    }
}
