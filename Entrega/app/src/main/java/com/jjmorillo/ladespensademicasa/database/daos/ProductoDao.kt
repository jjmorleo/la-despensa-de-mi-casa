package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Producto



@Dao
interface ProductoDao {

    @Query("SELECT * from productos")
    suspend fun findAll(): List<Producto>

    @Query("SELECT * from productos where marca=:marcaProducto")
    suspend fun findOneByMarca(marcaProducto: String): Producto

    @Insert
    suspend fun save(producto: Producto): Long

    @Update
    suspend fun update(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)
}
