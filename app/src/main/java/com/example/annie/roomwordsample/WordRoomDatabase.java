package com.example.annie.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = { WordEntity.class }, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    //provide abstract getter method for each @Dao
    public abstract WordDao wordDao();

    //make WordRoomDatabase a singleton (prevent multiple instances of db open at same time
    private static WordRoomDatabase INSTANCE;
    public static WordRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if(INSTANCE == null) {
                    //create database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").build();                }
            }
        }
        return INSTANCE;
    }
}
