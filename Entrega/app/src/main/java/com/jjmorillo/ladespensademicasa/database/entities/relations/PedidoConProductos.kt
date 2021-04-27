package com.jjmorillo.ladespensademicasa.database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.jjmorillo.ladespensademicasa.database.entities.Pedido
import com.jjmorillo.ladespensademicasa.database.entities.PedidosProductosCrossRef
import com.jjmorillo.ladespensademicasa.database.entities.Producto

data class PedidoConProductos(

    @Embedded val pedido: Pedido,
    @Relation(
        parentColumn = "id",
        entity= Producto::class,
        entityColumn = "id",
        associateBy = Junction(PedidosProductosCrossRef::class, parentColumn = "pedido_id", entityColumn = "producto_id")


    )

    val productos: List<Producto>

)
