package com.example.persistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanningDao {
    @Query("SELECT * FROM PLANNINGENTITY")
    LiveData<PlanningEntity> getAllCreneaux();

    @Insert
    public void insertCrenaux(PlanningEntity ... planningEntity);

}
