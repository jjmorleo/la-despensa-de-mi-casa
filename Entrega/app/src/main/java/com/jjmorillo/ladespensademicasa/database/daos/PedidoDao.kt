package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jjmorillo.ladespensademicasa.database.entities.Pedido
import com.jjmorillo.ladespensademicasa.database.entities.Usuario

interface PedidoDao {

    @Query("SELECT * from pedidos")
    suspend fun findAll(): List<Pedido>

    @Query("SELECT * from usuarios where id=:id")
    suspend fun findOneById(id:Long): Usuario

    @Insert
    suspend fun save(pedido: Pedido): Long //DEVUELVE EL ID GENERADO PARA ESTE SAVE

    @Update
    suspend fun update(pedido: Pedido)

    @Delete
    suspend fun delete(pedido: Pedido)
}