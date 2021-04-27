package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Usuario
import com.jjmorillo.ladespensademicasa.database.entities.relations.PedidosDeUsuario

@Dao
abstract class UsuarioDao : BaseDao<Usuario>() {

    @Query("SELECT * from usuarios")
    abstract suspend fun findAll(): List<Usuario>

    @Query("SELECT * from usuarios where email=:emailUsuario")
    abstract suspend fun findOneByEmail(emailUsuario: String): Usuario

    @Query("SELECT * from usuarios where id=:usuarioId")
    abstract suspend fun findAllByIdWithPedidos(usuarioId:Long):PedidosDeUsuario
    @Transaction
    @Query("SELECT * from usuarios")
    abstract suspend fun findAllByIdWithPedidos(): List<PedidosDeUsuario>//2 OPERACIONES SELECT DE LOS USUARIOS Y SELECT DE LOS PEDIDOS


}