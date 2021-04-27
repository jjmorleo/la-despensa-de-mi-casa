package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Producto


@Dao
abstract class ProductoDao: BaseDao<Producto>() {

    @Query("SELECT * from productos")
    abstract suspend fun findAll(): List<Producto>

   @Query("SELECT * from productos where categoria=:categoria")
   abstract suspend fun findAllByCategoria(categoria:String): List<Producto>



}
