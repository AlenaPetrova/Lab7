package com.example.examples.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.examples.model.History;
import com.example.examples.model.HistoryDAO;

@Database(entities = {History.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE HISTORY ADD COLUMN PROGRAMS2 INTEGER DEFAULT 0 NOT NULL");
        }
    };
    public abstract HistoryDAO historyDAO();
}

