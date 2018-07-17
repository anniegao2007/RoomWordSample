package com.example.annie.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao myWordDao;
    private LiveData<List<WordEntity>> allWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        myWordDao = db.wordDao();
        allWords = myWordDao.getAllWords();
    }

    LiveData<List<WordEntity>> getAllWords() {
        return allWords;
    }

    public void insert(WordEntity word) {
        new insertAsyncTask(myWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<WordEntity, Void, Void> {
        private WordDao myAsyncTaskDao;
        insertAsyncTask(WordDao dao) {
            myAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordEntity... params) {
            myAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
