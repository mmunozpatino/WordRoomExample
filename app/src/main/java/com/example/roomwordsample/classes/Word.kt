package com.example.roomwordsample.classes

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull


@Entity(tableName = "word_table")// -> defino la tabla que representa esta clase
class Word(mWord: String) {

    @PrimaryKey // -> es la PK de la tabla @PrimaryKey(autoGenerate = true) para auto generarlas
    @NonNull // -> no puede ser nunca nulo
    @ColumnInfo(name = "word") // -> define el nombre de la tabla, se marca para nombrar la columna distinto al atributo en si
    private var mWord: String = "" //-> todos los atributos deben ser publicos o tener su getter

    fun getWord(): String {
        return this.mWord
    }
}