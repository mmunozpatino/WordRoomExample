package com.example.roomwordsample.classes

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.support.annotation.WorkerThread

class WordRepository {

    //TODO: https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#8

    private var mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    constructor(application: Application){
        val db = WordRoomDatabase.getInstance(application)
        mWordDao = db!!.wordDao()
        mAllWords = mWordDao!!.getAll()
    }

    fun getAll(): LiveData<List<Word>>? {
        return mAllWords
    }

    class WordRepository(private val wordDao: WordDao) {

        val allWords: LiveData<List<Word>> = wordDao.getAll()

        @WorkerThread
        suspend fun insert(word: Word) {
            wordDao.insert(word)
        }
    }
}