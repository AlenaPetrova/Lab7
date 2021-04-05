package com.example.examples.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface HistoryDAO {
    @Insert
    void addHistory(History history);
    @Query("select * from HISTORY2")
    List<History> getHistory();


}
