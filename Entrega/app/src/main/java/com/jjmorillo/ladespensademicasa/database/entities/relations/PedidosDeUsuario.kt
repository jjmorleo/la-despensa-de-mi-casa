package com.jjmorillo.ladespensademicasa.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.jjmorillo.ladespensademicasa.database.entities.Pedido
import com.jjmorillo.ladespensademicasa.database.entities.Usuario

data class PedidosDeUsuario(

    @Embedded
    val usuario:Usuario,

    @Relation(
        parentColumn = "id",//este es el id del usuario
        entityColumn = "usuario_id"

    )
    val pedidos: List<Pedido>


)



