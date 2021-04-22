package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Usuario

@Dao
interface UsuarioDao {

    @Query("SELECT * from usuarios")
    suspend fun findAll(): List<Usuario>

    @Query("SELECT * from usuarios where email=:emailUsuario")
    suspend fun findOneByEmail(emailUsuario:String):Usuario

    @Insert
    suspend fun save(usuario: Usuario): Long //DEVUELVE EL ID GENERADO PARA ESTE SAVE

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)
}