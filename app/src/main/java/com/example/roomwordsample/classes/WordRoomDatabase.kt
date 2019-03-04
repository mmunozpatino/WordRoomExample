package com.example.roomwordsample.classes

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context


@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordRoomDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

    //-> lo hacemos singleton
    companion object {
        private var INSTANCE: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        WordRoomDatabase::class.java, "word_database"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
}