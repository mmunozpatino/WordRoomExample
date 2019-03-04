package com.example.roomwordsample.classes

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table") // -> no hay anotacion para el borrado de muchas, usamos la generica
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAll(): LiveData<List<Word>> // -> esto nos permite ser reactivos a los cambios

    // para solucion de conflictos al insrtar podemos usar algo como @Insert(onConflict = OnConflictStrategy.REPLACE)
}