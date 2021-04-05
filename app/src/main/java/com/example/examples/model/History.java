package com.example.examples.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HISTORY2")
public class History {
    @PrimaryKey(autoGenerate = true)
    public int idHistory;
    @ColumnInfo(name = "programs")
    public  int programs;
    @ColumnInfo(name = "resultS")
    public  String result;
    public History(int programs,String result){

        this.programs=programs;
       this.result=result;


    }

}
