package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Tornillo
import com.jjmorillo.ladespensademicasa.database.entities.Usuario

@Dao
interface TornilloDao {
    @Query("SELECT * from tornillos")
    suspend fun findAll(): List<Tornillo>

    @Query("SELECT * from usuarios where email=:emailUsuario")
    suspend fun findOneByEmail(emailUsuario: String): Usuario

    @Insert
    suspend fun save(tornillo: Tornillo): Long //DEVUELVE EL ID GENERADO PARA ESTE SAVE

    @Update
    suspend fun update(tornillo: Tornillo)

    @Delete
    suspend fun delete(tornillo: Tornillo)


}