package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlanningEntity {
    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name= "creneau")
    public String crenau;

    public PlanningEntity(String id, String crenau){
        this.id= id;
        this.crenau=crenau;
    }
}
