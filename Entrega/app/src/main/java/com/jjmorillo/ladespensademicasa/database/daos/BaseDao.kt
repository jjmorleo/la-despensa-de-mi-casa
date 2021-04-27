package com.jjmorillo.ladespensademicasa.database.daos


import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.jjmorillo.ladespensademicasa.database.entities.BaseEntity
import java.util.*

abstract class BaseDao<T> where T : BaseEntity {

    @Delete
    abstract fun delete(t: T)

    @Insert
    abstract fun save(t: T): Long

    @Update
    protected abstract fun updatePrivado(t: T)

    fun update(t: T) {

        t.updateAt = Date(System.currentTimeMillis())
        updatePrivado(t)
    }

//Esto como lo resuelvo
    /*@Insert
    abstract suspend fun saveAll(t: List<T>)*/
}