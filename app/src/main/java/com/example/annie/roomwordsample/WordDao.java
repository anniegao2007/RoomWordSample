package com.example.annie.roomwordsample;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.annie.roomwordsample.WordEntity;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(WordEntity word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<WordEntity>> getAllWords();
}