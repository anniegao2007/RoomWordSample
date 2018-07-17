package com.example.annie.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository myWordRepo;
    private LiveData<List<WordEntity>> allWords;

    public WordViewModel(Application application) {
        super(application);
        myWordRepo = new WordRepository(application);
        allWords = myWordRepo.getAllWords();
    }

    LiveData<List<WordEntity>> getAllWords() {
        return allWords;
    }

    public void insert(WordEntity word) {
        myWordRepo.insert(word);
    }
}
